### JAEHYUN fintech

## 📢 프로젝트 설명
- 제로베이스 부트캠프 백엔드 스쿨 10기 프로젝트 "실전 대출 심사 프로젝트" 이다.

## ⚙ 개발 환경
- 운영체제 : MacOS
- 통합개발환경(IDE) : IntelliJ
- JDK 버전 : JDK 11
- 데이터 베이스 : mysql
- 빌드 툴 : Gradle 7.3.0
- 관리 툴 : GitHub

## 🔌 Library/Framework
- SpringBoot(Multi Module)
- JPA(Spring Data JPA)
- Kafka
- Spring Cloud Gateway -> NginX
- JUnit5
- Swagger

## 🔌 Infrastructure
- MySQL
- Redis
- Docker


## 💻 기술 스택
- 백엔드
    - Kotlin, SpringBoot
- 데이터베이스
    - mysql</br>

## 👾 프로젝트 설명
✅ 대출 심사 요청을 보내면 결과를 받는 프로젝트이다.

## 👾 API 설명
✅ SWAGGER
![image](https://github.com/IamAnjaehyun/zero-base/assets/101981639/8a37caf0-c164-49ed-9845-060c4665d215)

- 대출 심사 요청 API
![image](https://github.com/IamAnjaehyun/zero-base/assets/101981639/f66782de-e925-4533-944f-475b15b93b7d)

- 대출 결과 요청 API
![image](https://github.com/IamAnjaehyun/zero-base/assets/101981639/60b3c973-ea8f-44e0-8642-43f888f62091)

✅ DOCKER
<img width="1172" alt="image" src="https://github.com/IamAnjaehyun/zero-base/assets/101981639/3acb02da-6bbf-4dc3-8e82-a80d034cbc31">

✅ ERD
<img width="491" alt="image" src="https://github.com/IamAnjaehyun/zero-base/assets/101981639/3831e807-c642-41cb-8d3a-0bda023ecb26">


## 🌝 느낀점
- docker에 등록한 mysql-fintech database가 springboot 와 연동이 되지 않아 프로젝트 진행 내내</br>
  이 에러때문에 고생했는데, 호스트의 /etc/hosts 파일에서 fintech-mysql 과 관련된 항목 중에 </br>
  127.0.0.1 fintech-mysql 이 부분이 없어서 그랬던 것.. 코틀린이라는 새로운 벽을 마주하여 힘들었지만 </br>
  오랬동안 에러와 싸우다 내가 이겼을 때의 쾌감은 정말 끝내준다는걸 다시한 번 알게해준 프로젝트.. 😝

