## 데이터베이스 연동

- 보안상의 이유로 안드로이드 스튜디오에서 MySQL 데이터베이스를 직접적으로 연결할 수 없다.
- 그러므로 중계역할을 하는 PHP를 통해 데이터베이스에 연동할 수 있도록 실습을 해보았다.

### 1. XAMPP 설치 ([설치 경로](https://www.apachefriends.org/index.html))

### 2. PHP 코드 작성 
##### [주요 코드] 
  - mysqli_connect("localhost", "root", "Password", "DatabaseName");   
    > 데이터베이스와 PHP간 연결  
  - mysqli_query(연결된 객체, "select * from user");  
    > user 테이블 내 데이터 값들을 조회  
  - array_push($result, array('userID'=>$row[0], 'userPassword'=>$row[1], 'userName'=>$row[2], 'userAge'=>$row[3]));
    > result 배열에 배열 형태로 값 삽입  
    > 'userID', 'userPassword', 'userName', 'userAge' 이름으로 삽입  
  - echo json_encode(array("result"=>$result));
    > json 형태의 String 값들 확인

### 3. 안드로이드 스튜디오에서 연결
  - activity_main.xml : listView 배치
  - list_item.xml : TextView 형태로 userID, userPassword, userName, userAge 배치
  - "http://IP주소/php파일명.php" 을 통해 웹 서버에서 result값 추출
  - HashMap 형태로 데이터 구성하여 ArrayList에 추가

### 4. 추가
  - AndroidManifest.xml : 아래의 코드를 필수적으로 추가!
    > android:usesCleartextTraffic="true"  
    > \<uses-permission android:name="android.permission.INTERNET"/>  


### 5. 실행 결과
| 데이터베이스 | 실행 화면 |
|:--------|:--------:|
| ![데이터베이스](https://user-images.githubusercontent.com/54324782/152309926-dc6d0e7b-5392-4652-a271-aa258b823d40.png) | ![실행 화면](https://user-images.githubusercontent.com/54324782/152309708-64bf13cb-7246-4f3e-a279-fa6482665d6f.png)


#### [참고사이트](https://yoo-hyeok.tistory.com/19?category=708422)
