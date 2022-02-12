package com.example.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lotteryNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        // 익명 객체
        val countDownTimer = object: CountDownTimer(3000, 100) { // 3초 타이머
            override fun onTick(p0: Long) {
                lotteryNumbers.forEach {
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }

            override fun onFinish() {
            }
        }

        // lottery버튼을 클릭 했을 때
        lotteryButton.setOnClickListener {
            if (lotteryButton.isAnimating) { // 에니메이션 중이면
                lotteryButton.cancelAnimation() // 에니메이션을 멈추고
                countDownTimer.cancel() // 카운트다운 타이머도 멈춘다.
            } else {
                lotteryButton.playAnimation() // 에니메이션 호출
                countDownTimer.start() // 카운트 다운 시작
            }
        }
    }
}