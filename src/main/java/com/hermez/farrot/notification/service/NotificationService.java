package com.hermez.farrot.notification.service;

import com.hermez.farrot.admin.service.AdminService;
import com.hermez.farrot.member.entity.Member;
import com.hermez.farrot.notification.dto.NotificationRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

  private final FcmService fcmService;
  private final AdminService adminService;

  private static final Map<String, String> tokenMap = new HashMap<>();

  public void register(String userEmail, String token) {
    tokenMap.put(userEmail, token);
  }

  public void creatNotification(Member sender, Member receiver) {
    log.info("========={}=====",receiver.getEmail());
    log.info("=========={}======",getToken(receiver.getEmail()));
    try {
      NotificationRequest request = NotificationRequest.builder()
              .title("안녕하세요 Farrot 입니다 \uD83D\uDC2D")
              .token(getToken(receiver.getEmail()))
              .message(receiver.getNickname()+"님!!! "+sender.getNickname()+", 님 으로부터 메시지가 도착했습니다.")
              .build();
      sendNotification(request);
    } catch (ExecutionException | InterruptedException e) {
      log.info("알림 에러 발생", e);
    }
  }

  public void creatNotification(List<Integer> selectedIds, String message) {
    try {
      for(Integer selectId : selectedIds) {
        Member receiver = adminService.findMemberById(selectId);

        NotificationRequest request = NotificationRequest.builder()
                .title("안녕하세요 관리자 입니다 \uD83D\uDE47")
                .token(getToken(receiver.getEmail()))
                .message(receiver.getNickname()+"님!!! "+ message)
                .build();
        sendNotification(request);
      }

    } catch (ExecutionException | InterruptedException e) {
      log.info("알림 에러 발생", e);
    }
  }

  private String getToken(String receiverEmail) {
    return tokenMap.get(receiverEmail);
  }

  private void sendNotification(NotificationRequest request)
          throws ExecutionException, InterruptedException {
    fcmService.send(request);
  }

}





