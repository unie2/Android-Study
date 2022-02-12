## 로또번호 생성기

### 실행 화면

| 초기화면(Splash 화면) | Main 화면 | 룰렛 클릭 시
|:--------|:--------:|:--------:|
| ![Splash](https://user-images.githubusercontent.com/54324782/153706019-3f89ac5e-604c-4550-a3f9-72317b27b9d1.png) | ![Main](https://user-images.githubusercontent.com/54324782/153706031-f831ce8d-ae08-4d19-9280-945bacc0632d.png) | ![룰렛](https://user-images.githubusercontent.com/54324782/153706062-0918ecb4-3c01-4806-b879-e7a08d3c6948.png)
| 3초 후 Main 화면으로 전환 | 


### 시스템 주요 기능
- [애니메이션 사이트](https://lottiefiles.com/)에서 3개의 json 파일 다운로드 (lottery 2개, money 1개)
- 애니메이션 API 사용 : build.gradle(Module)에 삽입  
  > 코드는 [여기서](http://airbnb.io/lottie/#/android)  
  > 버전 : 3.4.2  
- SplashActivity가 가장 먼저 실행될 수 있도록 Intent 적용
- 숫자공 스타일을 위해 Resource Manager에서 색상 추가
  > ballStroke(#3f51b5)  
  > ballSolid(#03a9f4)  
- Splash 화면의 애니메이션 클릭 혹은 3초 경과 시 Main 화면으로 화면 전환
- 룰렛 클릭 시 3초 동안 랜덤한 값 연속으로 배치
  > millisInFuture: 3000  
  > countDownInterval: 100  
- 모든 애니메이션 자동으로 계속 재생
  > app:lottie_loop="true"  
  > app:lottie_autoPlay="true"  
