package com.example.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        handler.postDelayed(runnable, 3000)

        // 에니메이션을 클릭 했을 때
        animationView.setOnClickListener {
            handler.removeCallbacks(runnable) // runnable 콜백 제거
            // MainActivity 로 이동
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // 이전 화면 전환 시 이동되지 않고 종료된다.
        }

        /*// 메인 스레드와 연관된 Looper를 가져와서 메인 스레드쪽에 Runnable 객체를 붙여주게 된다.
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000) // 약 3초 후 실행*/
    }
}