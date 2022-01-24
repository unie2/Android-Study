## 레이아웃 (Layout)

### RelativeLayout
  : 상대적인 위치를 결정
  
| 코드 | 디자인 |
|:--------|:--------:|
| ![코드](https://user-images.githubusercontent.com/54324782/150738228-e9d80613-1ce6-496f-8e02-2226f150d638.png) | ![디자인](https://user-images.githubusercontent.com/54324782/150738190-172e3716-e5a0-4cca-b8cb-93bbfa4f272e.png)

- 중간 위쪽에 배치
  > android:layout_alignParentTop  
  > android:layout_centerHorizontal

- 중간 아래쪽에 배치
  > android:layout_alignParentBottom  
  > android:layout_centerHorizontal
-----------------------

### TableLayout
  : 테이블 형식의 디자인을 구성할 수 있다.

| 내부 코드 | 디자인 |
|:--------|:--------:|
| ![코드](https://user-images.githubusercontent.com/54324782/150734810-1abe97fd-cb73-4086-b483-025b425da0ee.png) | ![디자인](https://user-images.githubusercontent.com/54324782/150734865-74f64f91-9dde-41a2-86ca-b4589929a74c.png)

- TableRow : 하나의 행에 대한 정보를 넣어줄 수 있다.
- android:layout_span : 하나의 버튼이 n개의 열을 차지할 수 있도록 해준다.
- android:layout_column : 버튼이 처음 시작하는 위치를 정해줄 수 있다. (n번째 테이블 위치)
-----------------------

### GridLayout
  : TableLayout처럼 테이블을 구성할 수 있다.
  
| 코드 | 디자인 |
|:--------|:--------:|
| ![코드](https://user-images.githubusercontent.com/54324782/150736208-95253dda-cba4-4904-8158-f7247d9f8021.png) | ![디자인](https://user-images.githubusercontent.com/54324782/150736595-24269833-1577-48e4-9a1d-dae94bd14cf3.png)

- android:columnCount="n" : 전체 열의 개수를 정해준다.
- android:rowCount="n" : 전체 행의 개수를 정해준다.
- 행 쪽 수직적으로 2개만큼 차지
  > android:layout_rowSpan="2"  
  > android:layout_gravity="fill_vertical"
- 열 쪽 수평적으로 3개만큼 차지
  > android:layout_columnSpan="3"  
  > android:layout_gravity="fill_horizontal"
-----------------------

### FrameLayout
  : 하나의 틀 안에서 다양한 프레임이 바뀔 수 있도록 해준다.
  
| 코드 | 디자인 |
|:--------|:--------:|
| ![코드](https://user-images.githubusercontent.com/54324782/150737084-5255f675-eac3-4a4a-9964-19cee904ab93.png) | ![디자인](https://user-images.githubusercontent.com/54324782/150737122-b8121ac5-f721-4efa-b39c-8271a855f261.png)

-----------------------

### LinearLayout

| 코드 | 디자인 |
|:--------|:--------:|
| ![코드](https://user-images.githubusercontent.com/54324782/150737796-9fbafd9e-8a85-44ae-97cb-f8b48211fffa.png) | ![디자인](https://user-images.githubusercontent.com/54324782/150737836-8f0a6699-ae2e-4791-bb2e-01a4effad044.png)

- android:orientation : 수평적(horizontal) 혹은 수직적(vertical)으로 정의한다.
