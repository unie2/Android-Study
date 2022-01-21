## 유튜브 API 연동 (YouTube API)

### 실행 화면
  
| 초기 화면 | 재생 버튼 클릭 시 영상 재생 |
|:--------|:--------:|
| ![초기 화면](https://user-images.githubusercontent.com/54324782/150467617-258ec6bd-7c7f-4841-ae64-3dc74c368622.png) | ![영상 재생](https://user-images.githubusercontent.com/54324782/150467649-bace2f03-c05c-479c-91b1-719f53a044ea.png)


### 시스템 주요 기능
- AndroidManifest.xml : uses-permission 세팅 (android.permission.INTERNET)
- activity_main.xml : View, Button 생성
- [YouTube Android Player API](https://developers.google.com/youtube/android/player/downloads?hl=ko)에서 JAR 파일 다운 후 프로젝트 libs에 삽입
- Google API Console에서 API 키 생성 후 사용자 인증서 디지털 지문 등록
  > SHA-1 지문은 gradlew signingReport 를 통해 확인
- YouTubePlayerView, Button 객체 생성 & 이벤트 처리를 할 수 있도록 리스너 생성
- 재생 버튼 클릭 시 API코드로 초기화를 수행하고 리스너에 전달
- 초기화가 이루어졌을 때 loadVideo()를 통해 지정된 유튜브 비디오 로드
