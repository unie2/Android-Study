package com.example.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView youtubeView; // YouTubePlayerView 객체 생성
    Button button; // Button 객체 생성
    YouTubePlayer.OnInitializedListener listener; // 이벤트 처리를 할 수 있도록 리스너 생성

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.youtubeButton);
        youtubeView = (YouTubePlayerView) findViewById(R.id.youtubeView);
        listener = new YouTubePlayer.OnInitializedListener() {
            // 초기화가 이루어졌을 때 해당 비디오를 띄어줌

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("txifUq2n8Ho"); // 비디오 로드
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        // 버튼을 클릭했을 때 이벤트 처리
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                youtubeView.initialize("", listener); // API코드로 초기화 수행 후 리스너에 전달
            }
        });
    }
}