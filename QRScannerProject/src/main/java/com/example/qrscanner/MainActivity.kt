package com.example.qrscanner

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // QR코드리더 버튼을 클릭했을 때 실행
    fun startBarcodeReader(view: View) {
        // 바코드 스캐너가 실행
        IntentIntegrator(this).initiateScan()
    }

    fun startBarcodeReaderCustom(view: View) {
        val integrator = IntentIntegrator(this)
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE) // 원하는 규격 설정 가능
        integrator.setPrompt("QR 코드를 스캔하여 주세요") // 스캔 시 하단 문구 설정
        integrator.setCameraId(0) // 후면 카메라 (1은 전면 카메라)
        integrator.setBeepEnabled(true) // 바코드 인식 시 Beep 소리 발생
        integrator.setBarcodeImageEnabled(true) // OnActivityResult에 바코드에 대한 결과값과 사진도 함께 전달
        integrator.initiateScan()
    }

    fun startBarcodeReaderCustomActivity(view: View) {
        val integrator = IntentIntegrator(this)
        integrator.setBarcodeImageEnabled(true) // OnActivityResult에 바코드에 대한 결과값과 사진도 함께 전달
        integrator.captureActivity = MyBarcodeReaderActivity::class.java // 클래스 전달
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            if (result.contents != null) {
                Toast.makeText(this, "scannerd: ${result.contents} format: ${result.formatName}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            }
            if (result.barcodeImagePath != null) {
                val bitmap = BitmapFactory.decodeFile(result.barcodeImagePath) // 바코드 이미지 경로 전달
                scannedBitmap.setImageBitmap(bitmap)
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}