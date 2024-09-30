# 🛍️ Farrot 선생님 중고거래 플랫폼
<div align="center">

![farrot](https://github.com/user-attachments/assets/dcb62b7f-041a-4bad-be19-4c0d697762f6)
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fteam-hermez%2Ffarrot&count_bg=%238FB0C6&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=%F0%9F%A6%A6&edge_flat=false)](https://hits.seeyoufarm.com)

</div>

## 🔗 Link
-  [Farrot 최종발표/영상 및 자료 ⭕](https://www.miricanvas.com/v/13opefh)
-  [Farrot Notion 📚](https://distinct-dinghy-f0c.notion.site/04f2d7ecba8f43feba12401690dd7846?v=ee36d65d2721455faa8e894dfb2423c9&pvs=4)
  
<br>

## 🗓️ 개발 기간 및 작업 관리

### 개발 기간

- 기획 : 2024년 9월 11일 ~ 2024년 9월 12일
- 기능 설계 : 2024년 9월 12일 ~ 2024년 9월 13일
- View 구현 : 2024년 9월 19일 ~ 2024년 9월 20일
- 서버 구현 : 2024년 9월 19일 ~ 2024년 9월 23일
- 발표 : 2024년 9월 23일

<br>

### 작업 관리

- GitHub Projects를 사용하여 진행 상황을 공유했습니다.
- 만나서 회의를 진행하며 작업 순서와 방향성에 대한 고민을 나누고 노션 및 디스코드에 회의 내용을 기록했습니다.

<br>

## 📢 프로젝트 소개

- Farrot은 교사들이 안전하고 신뢰할 수 있는 환경에서 중고 물품을 거래할 수 있도록 설계된 플랫폼입니다.
- 교사들 간의 원활한 소통과 상호 신뢰를 기반으로 한 거래를 목표로 하며, 교육자들이 필요한 물품을 쉽게 등록하고 검색할 수 있는 기능을 제공합니다.
- 주요 기능으로는 상품 등록 및 검색, 거래 게시판, 교사들 간의 실시간 채팅 및 알림 기능이 포함됩니다.
- 교사들만의 안전한 커뮤니티를 형성하고, 사용자 간의 효율적인 거래를 지원하는 것이 Farrot의 핵심 목적입니다.

#### Farrot will provide a secure platform for trading used goods among teachers.
You can easily register, search, and manage transactions with our user-friendly interface. Our service also includes real-time communication and notification features to enhance the trading experience.

#### Farrot's platform will offer a seamless trading experience.

Our platform supports the following features:
1. Easy product registration and search functionalities.
2. A transaction bulletin board for posting and managing trades.
3. Real-time chat and notification options for effective communication.
4. A secure community exclusively for teachers to support efficient transactions.


<br>

## 👨‍👩‍👦‍👦 웹개발팀 소개

|      👑김혁진       |          엄진수         |       허상범         |       김다은        |
| :----------------: | :----------------------: | :-----------------: | :----------------: |
|   ![image](https://github.com/user-attachments/assets/c5349ab8-be7a-440c-8335-93bdd1a644ab)   |  ![image](https://github.com/user-attachments/assets/b9e11116-3777-4458-83a8-0c0d188ff458)    |  ![image](https://github.com/user-attachments/assets/f6792437-0999-4464-ad63-3614c3b9231b)  |   ![image](https://github.com/user-attachments/assets/971f010f-1724-475b-86e4-ba8cd34edb78)   |
|   [@hyoekjin](https://github.com/HS-hyeokjin)   |    [@jinsu](https://github.com/Gitdoolgi)  | [@sangbum](https://github.com/tokkaiiii)  | [@daeun](https://github.com/kde0707)  |
| 천재교육 풀스택 6기 | 천재교육 풀스택 6기 | 천재교육 풀스택 6기 | 천재교육 풀스택 6기 |

<br>

## ⚙️ 개발 환경

- **Front-end** : HTML, CSS, JavaScript, Thymeleaf
- **Back-end** : Spring Boot, JPA, MariaDB, SAFERROT(안전 결제 서버)
- **버전 및 이슈관리** : Git, GitHub
- **협업 툴** : Discord, Notion, GitHub, Slack, VScode
- **서비스 배포 환경** : Tomcat
![Stacks](https://github.com/user-attachments/assets/d09856ad-8226-4d8c-bc66-7be38f8d2b0b)


<br>

## ✅ 채택한 개발 기술과 브랜치 전략

### 브랜치 전략

- Git-flow 전략을 기반으로 main, dev 브랜치를 운용했습니다.
- main, dev 브랜치로 나누어 개발하였습니다.
    - **main** 브랜치는 배포 단계에서만 사용하는 브랜치입니다.
    - **dev** 브랜치는 개발 단계에서 git-flow의 master 역할을 하는 브랜치입니다.

<br>

## 🪜 프로젝트 구조

```
farrot/
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── public/
│   └── firebase-messaging-sw.js
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── hermez/
│   │   │           └── farrot/
│   │   │               ├── admin/
│   │   │               ├── category/
│   │   │               ├── chat/
│   │   │               ├── common/
│   │   │               ├── config/
│   │   │               ├── image/
│   │   │               ├── index/
│   │   │               ├── member/
│   │   │               ├── notification/
│   │   │               ├── oauth/
│   │   │               ├── payment/
│   │   │               ├── product/
│   │   │               ├── report/
│   │   │               ├── util/
│   │   │               └── wishlist/
│   │   └── FarrotApplication.java
│   │
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   ├── img/
│       │   ├── js/
│       │   ├── default-member-image.png
│       │   ├── default-product-image.png
│       │   ├── farrot4-1.png
│       │   └── farrot6.png
│       └── templates/
│           ├── admin/
│           ├── chat/
│           ├── error/
│           ├── index/
│           ├── layout/
│           ├── member/
│           ├── notification/
│           ├── payment/
│           ├── product/
│           └── wishlist/
│
└── test/
    └── java/
        └── com/
            └── hermez/
                └── farrot/
                    └── FarrotApplicationTests.java
```

<br>


<br>

## 🙏 역할 분담


### 🐈‍⬛ 엄진수

- **UI**
    - 페이지 : 회원가입 및 인증 페이지, 마이페이지

- **기능**
    - 로그인 기능 구현
    - 회원가입 기능 구현
    - 회원 상세 페이지 구현
    - 상세 정보 업데이트 서비스 구현
    - OAtuth2 소셜 로그인 기능 구현
    - JWT토큰 기반 인증 시스템 구현
  
<br>
    
### 🕊️ 김혁진

- **UI**
    - 페이지 : 상품 관련 페이지, 결제 관련 페이지 

- **기능**
    - 상품 등록 수정 삭제 기능 구현
    - 상품 이미지 등록 및 조회 구현
    - 다중 검색 필터 구현
    - 결제 서비스 구현
    - 에스크로 서비스 구현
    - 배송 추적 서비스 구현
    - 결제 관리 서비스 구현

<br>

### 🐈 허상범

- **UI**
    - 페이지 : 채팅 페이지, 알림 페이지, 위시리스트 페이지

- **기능**
    - 대화 실시간 읽음 처리 구현
    - 메시지 바로 알림 서비스 구현
    - 채팅 메시지 및 찜 실시간 알림 서비스 구현
    - 상품 위시리스트 추가 구현
    - 이미지 스토리지(firebase) 구현

<br>

### 🐇 김다은
- **UI**
    - 페이지 : 관리자 페이지( 회원관리, 상품관리, 신고관리) 구현

- **기능**
    - 회원, 비회원, 회원 상세 보기 등 회원관리 서비스 구현
    - 상품 거래량, 상품 등록 순, 실시간 상품 등록 확인 서비스 구현
    - 신고하기 서비스 구현
    - 실시간 통계 조회 서비스 구현
    - 상품별 카테고리 관리

<br>


## 📺 화면 구성

| 메인 페이지 1 |  메인 페이지 2   |
| :-------------------------------------------: | :------------: | 
|  ![메인 페이지](https://github.com/user-attachments/assets/fff93cd9-0107-4c60-b4d4-f96c92c1620d)   |  ![메인 페이지 2](https://github.com/user-attachments/assets/9354b37f-1e7d-4a46-97d4-0537cdcb1c4a) |  
| 회원가입 페이지   |   로그인 페이지   |  
| ![회원가입](https://github.com/user-attachments/assets/5f5334e2-6543-4c95-920a-cbffb2d86b0d)  | ![로그인](https://github.com/user-attachments/assets/a06d1942-d194-4763-a215-d3bf034c491a)   |  
| 마이페이지   |    상품 페이지   |  
| ![마이페이지](https://github.com/user-attachments/assets/773d670b-b8e1-4fa0-b60d-bbc63f24a1fa) |  ![상품목록 페이지](https://github.com/user-attachments/assets/79de6de5-8a54-49bd-a5ba-14ce4c1c49bd)  | 
| 상품 상세 페이지   |  안전결제 페이지  | 
| ![상품상세페이지](https://github.com/user-attachments/assets/74e41cde-104a-45fd-b878-39c872064451)   |  ![안전결제](https://github.com/user-attachments/assets/9d0ce543-fc80-4984-9880-d14f879cd4aa)  |
| 구매 내역 페이지   |  채팅 페이지   |  
| ![구매 내역](https://github.com/user-attachments/assets/7e5ebc53-7601-4c6f-91c5-20f2fc4dcbd1)  |  ![채팅](https://github.com/user-attachments/assets/778a53e1-dac3-424a-a557-79c2162cc6b8) |
| 대화방 페이지  |  알림 및 위시리스트   |
| ![대화방](https://github.com/user-attachments/assets/d4768eb1-5853-40e8-8868-14f1081ef4f6) | ![알림 및 위시리스트](https://github.com/user-attachments/assets/a10e35e0-afd7-405c-a30b-88a49b7eeb9d) |
| 관리자 페이지 | 회원관리 페이지 |
| ![관리자](https://github.com/user-attachments/assets/d1c63429-dc84-4e74-8630-9cac48d0c89e) | ![회원관리](https://github.com/user-attachments/assets/a1b9decd-c69e-4176-9139-a30056d05837) |
| 비회원관리 페이지 | 상품관리 페이지 |
| ![비회원](https://github.com/user-attachments/assets/484a3f4a-0a32-4865-8b54-fb4d6729d10c) | ![상품관리](https://github.com/user-attachments/assets/6277d141-621f-458f-86b2-691fb8700327) |

<br>


## 📦 화면별 기능 

| 기능 | 영상 |
| :-------------------------: | :-------------------------------------------: |
| 로그인 | <a href="https://youtu.be/QZKYJJ-fXMg" target="_blank">![로그인 영상](https://img.youtube.com/vi/QZKYJJ-fXMg/0.jpg)</a> |
| 상품, 안전결제 | <a href="https://youtu.be/M84pOMKOqmU" target="_blank">![상품 영상](https://img.youtube.com/vi/M84pOMKOqmU/0.jpg)</a> |
| 찜, 채팅, 알림 | <a href="https://youtu.be/otyEuD0k36w" target="_blank">![채팅 영상](https://img.youtube.com/vi/otyEuD0k36w/0.jpg)</a> |
| 신고, 관리자 | <a href="https://youtu.be/Bc7_gGjL_N4" target="_blank">![관리자 영상](https://img.youtube.com/vi/Bc7_gGjL_N4/0.jpg)</a> |

<br>

## 🏁 클론 및 의존성 설치

### Requirements

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Gradle 7.5](https://gradle.org/releases/)
- [MariaDB 10.11.8](https://mariadb.org/download/?t=mariadb&p=mariadb&r=10.11.8)


```bash
git clone https://github.com/team-hermez/farrot.git
cd farrot
# Java 및 Gradle 설치 필요
./gradlew build
```

### 실행방법
```
./gradlew bootRun
```

<br>

## 🎯 개선 목표

- 이전 프로젝트인 flone을 연결하여 선생님의 중고거래 사이트 정체성 확립
- 에스크로 서비스 구체화
- 채팅을 위한 ERD 보완

<br>

## ⌨️ 프로젝트 후기

### (❁´◡`❁) 엄진수

이런저런 욕심을 내다보니 꽤 힘든 점도 있었습니다. 그래도 여러 기능을 사용해 보기 위해 많이 찾아보면서 직접 로직을 구현했고 실제로 구동이 되는 걸 보면서 굉장히 즐거웠습니다. 또한 예상치 못한 트러블이 생기는 것을 많이 경험한 프로젝트이기도 합니다. 다음 프로젝트에선 스케줄링을 좀 더 고려해야 하는 것을 많이 느꼈습니다.

<br>

### (●'◡'●) 김혁진

부족한 부분이 많지만 팀원들과 소통하며 즐겁게 개발했습니다.
트러블 없이 개발하였으며, 개인적인 부분과 팀적인 부분이 적당히 나누어져 스스로는 만족할 수 있는 결과를 만든 것 같아서 좋았습니다.

<br>

### ༼ つ ◕_◕ ༽つ 허상범

채팅이란 흥미 있는 주제로 프로젝트를 해볼 수 있어서 재밌었습니다. 개발을 하기 전엔 대표적인 채팅 앱인 카카오톡에서 쉬워 보였던 기능들이라든지 왜 아직도 이런 기능이 구현이 안 돼있을까 싶은 것들을 조금은 이해하게 된 계기가 된 것 같습니다.

<br>

### ╰(*°▽°*)╯ 김다은

관리자 페이지를 하면서 여러 가지 sql 문을 경험해 볼 수 있었습니다. 처음에만 어려웠지 뒤로 갈수록 jpa에 익숙해지니 마무리가 될 때쯤 어렵지 않다고 느꼈습니다. 관리자 페이지를 하면서 팀원들과 많이 소통했는데 그 부분이 제일 재미있었던 것 같습니다.

<br>

## 📞 연락처

프로젝트 관련 문의는 [team-Hermez](https://github.com/team-hermez)으로 문의주시길 바랍니다.
