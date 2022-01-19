package com.example.tutorial5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ImageAdapter extends ArrayAdapter<String> {
     ImageAdapter(Context context, String[] items) {
        super(context, R.layout.image_layout, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater imageInflater = LayoutInflater.from(getContext());
        View view = imageInflater.inflate(R.layout.image_layout, parent, false); // image_layout을 가져옴
        String item = getItem(position); // 하나의 아이템 객체를 정의해줌
        TextView textView = (TextView) view.findViewById(R.id.textView); // textView 객체
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView); // imageView 객체
        textView.setText(item); // 가져온 아이템을 textView에 넣어줌
        imageView.setImageResource(R.mipmap.hacker);
        return view;
    }
}
