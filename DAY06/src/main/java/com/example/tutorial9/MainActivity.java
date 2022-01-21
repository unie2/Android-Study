package com.example.tutorial9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // 실행 부분
    Adapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPager) findViewById(R.id.view); // ViewPager 초기화
        adapter = new Adapter(this); // Adapter 초기화
        viewPager.setAdapter(adapter); // VierPager에서 Adapter 설정
    }
}