package com.hermez.farrot.chat.chatmessage.service;


import com.hermez.farrot.chat.chatmessage.dto.request.SendMessageRequest;
import com.hermez.farrot.chat.chatmessage.dto.response.ChatRoomResponse;
import com.hermez.farrot.chat.chatmessage.entity.ChatMessage;
import com.hermez.farrot.chat.chatmessage.exception.NoMatchUniqueReceiverException;
import com.hermez.farrot.chat.chatmessage.repository.ChatMessageRepository;
import com.hermez.farrot.chat.chatmessage.repository.ChatMessageRepositoryImpl;
import com.hermez.farrot.chat.chatroom.dto.response.ChatRoomEnterResponse;
import com.hermez.farrot.chat.chatroom.entity.ChatRoom;
import com.hermez.farrot.chat.chatroom.repository.ChatRoomRepository;
import com.hermez.farrot.chat.chatroom.repository.ChatRoomRepositoryCustom;
import com.hermez.farrot.member.entity.Member;
import com.hermez.farrot.member.repository.MemberRepository;
import com.hermez.farrot.notification.service.NotificationService;
import jakarta.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ChatMessageService {

  private final ChatMessageRepository chatMessageRepository;
  private final ChatRoomRepository chatRoomRepository;
  private final ChatRoomRepositoryCustom chatRoomRepositoryCustom;
  private final MemberRepository memberRepository;
  private final NotificationService notificationService;
  private final SimpMessagingTemplate simpMessagingTemplate;
  private final ChatMessageRepositoryImpl chatMessageRepositoryImpl;

  public void sendMessageToUser(String sessionId, String destination, ChatRoomResponse response) {
    MessageHeaders headers = createMessageHeaders(sessionId);
    simpMessagingTemplate.convertAndSendToUser(sessionId, destination, response, headers);
  }


  @Transactional
  public Integer save(SendMessageRequest request) {
    ChatRoom chatRoom = chatRoomRepository.findById(request.chatRoomId())
        .orElseThrow(() -> new RuntimeException("채팅방이 없습니다."));
    Member sender = memberRepository.findByEmail(request.email())
        .orElseThrow(() -> new RuntimeException("해당하는 멤버가 없습니다."));
    ChatMessage chatMessage = ChatMessage.createChatMessage(chatRoom, sender, request.message(),
        request.type(), chatRoom.getConnect());
    return chatMessageRepository.save(chatMessage).getReadCount();
  }

  public int getReadCount(Integer memberId, Integer chatRoomId) {
    return chatMessageRepositoryImpl.countReadCountByChatRoomId(memberId, chatRoomId);
  }

  public List<ChatRoomResponse> findAllByChatRoomId(ChatRoomEnterResponse response) {
    List<ChatMessage> chatMessages = chatMessageRepository.findAllByChatRoomId(response.roomId());
    Integer myId = response.senderId();
    return chatMessages.stream().map(c -> {
          Integer senderId = c.getSender().getId();
          String nickname = c.getSender().getNickname();
          return ChatRoomResponse.builder()
              .nickName(nickname)
              .senderId(senderId)
              .message(c.getMessage())
              .type(c.getType())
              .readCount(Objects.equals(senderId, myId) ? c.getReadCount() : null)
              .sendTime(formatTime(c.getCreatedAt()))
              .build();
        }
    ).toList();
  }


  public void sendChatNotification(SendMessageRequest request, Integer productId) {
    Member seller = chatRoomRepositoryCustom.findSellerByProductId(productId);
    Member buyer = chatRoomRepositoryCustom.findBuyerByChatRoomId(request.chatRoomId());
    Member sender = memberRepository.findById(request.senderId())
        .orElseThrow(() -> new RuntimeException("해당 유저가 없습니다."));
    if (Objects.equals(sender.getId(), seller.getId())) {
      log.info("구매자에게 보내기");
      notificationService.createNotification(sender, buyer,request.message());
    } else if (Objects.equals(sender.getId(), buyer.getId())) {
      log.info("판매자에게 보내기");
      notificationService.createNotification(sender, seller,request.message());
    } else {
      throw new NoMatchUniqueReceiverException("알림을 받을 유저를 찾을 수 없습니다.");
    }
  }

  private MessageHeaders createMessageHeaders(@Nullable String sessionId) {
    SimpMessageHeaderAccessor headerAccessor = SimpMessageHeaderAccessor.create(
        SimpMessageType.MESSAGE);
    if (sessionId != null) {
      headerAccessor.setSessionId(sessionId);
    }
    headerAccessor.setLeaveMutable(true);
    return headerAccessor.getMessageHeaders();
  }

  private String formatTime(LocalDateTime time) {
    return time.format(DateTimeFormatter.ofPattern("a h:mm"));
  }

}
