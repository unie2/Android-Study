## 리스트 뷰 꾸미기 (Custom ListView)

### 실행 화면
  
| 초기 화면 | 특정 아이템(포도 쥬스) 클릭 시 |
|:--------|:--------:|
| ![초기 화면](https://user-images.githubusercontent.com/54324782/150060279-0c3fa97b-660a-4f40-bf77-470cba3192e9.png) | ![포도 쥬스](https://user-images.githubusercontent.com/54324782/150060384-74efe8f7-38d7-4fc7-96f7-fa48d05bffb7.png)


### 추가
* LayoutInflater [참고 링크](https://yejinson97gaegul.tistory.com/entry/LayoutInflater%EB%9E%80)
  - 안드로이드에서 View를 만드는 방법 중 하나
  - xml에 정의된 Resource를 View 객체로 반환해 주는 역할을 한다.
  - xml에 미리 정해둔 틀을 실제 메모리에 올려주는 역할을 한다.
  - xml 레이아웃 파일에 대한 뷰를 생성할 때 LayoutInflater를 이용해야 한다.
  - LayoutInflater 객체의 inflate 메서드를 이용해 새로운 뷰를 생성할 수 있다.
    > inflate(xml파일, 만든 뷰를 넣을 부모 layout/container, 바로 inflate할지의 여부)
  - inflate() 된 view의 child view는 inflate된 view.findViewById로 찾아야 한다.
  - inflate된 뷰에서 다시 layout inflater를 사용할 경우, 기존의 findViewById와 event 설정들이 모두 사라진다.
