package com.example.tutorial3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] items = {"망고 쥬스", "토마토 쥬스", "포도 쥬스"}; // List Items

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listButton = (Button) findViewById(R.id.listButton); // UI로부터 버튼에 대한 정보를 가져와서 버튼 객체로 생성
        listButton.setOnClickListener(new View.OnClickListener() { // 이벤트 추가
            @Override
            public void onClick(View view) { // 버튼을 클릭했을 때의 함수 처리 부분
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // MainActivity에 종속
                builder.setTitle("리스트"); // 팝업 창 제목
                builder.setItems(items, new DialogInterface.OnClickListener() { // 리스트 내용
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) { // 아이템을 클릭했을 때의 함수 처리 부분
                        Toast.makeText(getApplicationContext(), items[i], Toast.LENGTH_SHORT).show(); // 클릭한 해당 인덱스의 내용을 Toast를 통해 띄워줌
                    }
                });
                AlertDialog alertDialog = builder.create(); // Dialog 객체 할당
                alertDialog.show(); // Dialog 보여줌
            }
        });

        Button exitButton = (Button) findViewById(R.id.exitButton); // UI로부터 버튼에 대한 정보를 가져와서 버튼 객체로 생성
        exitButton.setOnClickListener(new View.OnClickListener() { // 이벤트 추가
            @Override
            public void onClick(View view) { // 버튼을 클릭했을 때의 함수 처리 부분
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // MainActivity에 종속
                builder.setMessage("정말로 종료하시겠습니까?"); // 알림창 메시지 설정
                builder.setTitle("종료 알림창").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // 제목 및 관련 정보 세팅 (사용자가 임의로 종료할 수 없도록)
                    // 'Yes' 버튼 클릭 시 이벤트 처리
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish(); // 함수 및 프로그램 종료
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    // 'No' 버튼 클릭 시 이벤트 처리
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel(); // Dialog 창이 종료
                    }
                });
                AlertDialog alert = builder.create(); // Dialog 객체 받아줌
                alert.setTitle("종료 알림창"); // Dialog 제목 설정
                alert.show(); // Dialog 보여줌
            }
        });
    }
}