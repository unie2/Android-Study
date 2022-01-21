package com.example.tutorial9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Adapter extends PagerAdapter {

    private int[] images = {R.drawable.normal, R.drawable.hover, R.drawable.click}; // images
    private LayoutInflater inflater;
    private Context context;

    // 생성자 정의
    public Adapter(Context context) {
        this.context = context; // 해당 context가 자신의 context와 똑같이 되도록
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((LinearLayout) object); // object를 LinearLayout으로 변환했을 때 view와 같은지에 대한 내용을 반환
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // inflater 초기화
        View v = inflater.inflate(R.layout.slider, container, false); // View 초기화
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView); // ImageView 초기화
        TextView textView = (TextView) v.findViewById(R.id.textView); // TextView 초기화
        imageView.setImageResource(images[position]); // ImageView 객체에서 현재 이미지를 선택할 수 있도록
        textView.setText((position + 1) + "번째 이미지입니다."); // 현재 가리키고 있는 이미지가 몇번째 이미지인지 보여줄 수 있도록
        container.addView(v); // container에 해당 View를 추가

        return v;
    }

    // 아이템 객체의 할당을 해지
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
