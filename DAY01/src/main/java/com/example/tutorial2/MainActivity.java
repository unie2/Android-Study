package com.example.tutorial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1); // number1 값
        EditText number2 = (EditText) findViewById(R.id.number2); // number2 값
        TextView result = (TextView) findViewById(R.id.result); // 결과 값
        int n1 = Integer.parseInt(number1.getText().toString()); // 정수형으로 저장
        int n2 = Integer.parseInt(number2.getText().toString()); // 정수형으로 저장
        result.setText(Integer.toString(n1 + n2)); // 덧셈 결과 출력
    }

    public void subtractClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1); // number1 값
        EditText number2 = (EditText) findViewById(R.id.number2); // number2 값
        TextView result = (TextView) findViewById(R.id.result); // 결과 값
        int n1 = Integer.parseInt(number1.getText().toString()); // 정수형으로 저장
        int n2 = Integer.parseInt(number2.getText().toString()); // 정수형으로 저장
        result.setText(Integer.toString(n1 - n2)); // 뺄셈 결과 출력
    }

    public void multiplyClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1); // number1 값
        EditText number2 = (EditText) findViewById(R.id.number2); // number2 값
        TextView result = (TextView) findViewById(R.id.result); // 결과 값
        int n1 = Integer.parseInt(number1.getText().toString()); // 정수형으로 저장
        int n2 = Integer.parseInt(number2.getText().toString()); // 정수형으로 저장
        result.setText(Integer.toString(n1 * n2)); // 곱셈 결과 출력
    }

    public void divideClick(View v) {
        EditText number1 = (EditText) findViewById(R.id.number1); // number1 값
        EditText number2 = (EditText) findViewById(R.id.number2); // number2 값
        TextView result = (TextView) findViewById(R.id.result); // 결과 값
        int n1 = Integer.parseInt(number1.getText().toString()); // 정수형으로 저장
        int n2 = Integer.parseInt(number2.getText().toString()); // 정수형으로 저장
        result.setText(Integer.toString(n1 / n2)); // 나눗셈 결과 출력
    }

} 