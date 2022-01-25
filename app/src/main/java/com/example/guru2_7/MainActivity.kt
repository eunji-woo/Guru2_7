package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var LoginButton: Button
    lateinit var idEdittext: EditText
    lateinit var pwEdittext: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginButton=findViewById(R.id.LoginButton)
        idEdittext=findViewById(R.id.idEdittext)
        pwEdittext=findViewById(R.id.pwEdittext)


        /*DBManager = DBManager(this, "personal", null, 1)*/

        LoginButton.setOnClickListener {

        }
    }
}