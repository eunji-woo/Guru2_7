package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    lateinit var Homebutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        Homebutton=findViewById(R.id.Homebutton)


        Homebutton.setOnClickListener{
            // Home 으로 이동
            val intent = Intent(this, NaviActivity::class.java)
            startActivity(intent)
        }
    }


}