package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.guru2_7.joinActivity

class MainActivity : AppCompatActivity() {
    lateinit var LoginButton: Button
    lateinit var joinButton: Button
    lateinit var idEdittext: EditText
    lateinit var pwEdittext: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginButton=findViewById(R.id.LoginButton)
        idEdittext=findViewById(R.id.idEdittext)
        pwEdittext=findViewById(R.id.pwEdittext)
        joinButton=findViewById(R.id.joinButton)


        /*DBManager = DBManager(this, "personal", null, 1)*/

        LoginButton.setOnClickListener {

        }

        joinButton.setOnClickListener{
            // intent로 회원가입 창으로 이동
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}