package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MypageActivity : AppCompatActivity() {

    lateinit var ChangePWbutton : Button
    lateinit var Billbutton : Button
    lateinit var Outbutton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        ChangePWbutton = findViewById(R.id.ChangePWbutton)
        Billbutton = findViewById(R.id.Billbutton)
        Outbutton = findViewById(R.id.Outbutton)

        ChangePWbutton.setOnClickListener{
            // 비밀번호 변경 창으로 이동
            val intent = Intent(this, ChangeActivity::class.java)
            startActivity(intent)
        }
    }
}