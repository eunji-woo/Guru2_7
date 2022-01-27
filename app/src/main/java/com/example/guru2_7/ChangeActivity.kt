package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ChangeActivity : AppCompatActivity() {
    lateinit var ChangeOkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        ChangeOkButton = findViewById(R.id.ChangeOkButton)

        ChangeOkButton.setOnClickListener{
            // 처음 화면으로 이동 (=재로그인)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}