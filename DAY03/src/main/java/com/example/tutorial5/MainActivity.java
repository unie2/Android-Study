package com.example.tutorial5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = {"망고 쥬스", "토마토 쥬스", "포도 쥬스"}; //
        ListAdapter adapter = new ImageAdapter(this, items); // 현재 해당하는 MainActivity객체가 this로 들어가고, items가 매개변수로 들어감
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter); // items 요소들이 들어감

        /* listView에 대한 이벤트 처리 */
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        String item = String.valueOf(parent.getItemAtPosition(i)); // 클릭한 위치에 있는 그 아이템을 받아서 문자열에 담는다.
                        Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show(); // 해당 아이템을 출력
                    }
                }
        );
    }
}