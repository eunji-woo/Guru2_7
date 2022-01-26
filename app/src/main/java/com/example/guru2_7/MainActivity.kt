package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var LoginButton: Button
    lateinit var joinButton: Button
    lateinit var idEdittext: EditText
    lateinit var pwEdittext: EditText

    lateinit var dbManager: DBManager
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoginButton=findViewById(R.id.LoginButton)
        idEdittext=findViewById(R.id.idEdittext)
        pwEdittext=findViewById(R.id.pwEdittext)
        joinButton=findViewById(R.id.joinButton)

        dbManager = DBManager(this)

        LoginButton.setOnClickListener {
            sqlDB = dbManager.readableDatabase

            var cursor_id = sqlDB.rawQuery("SELECT nickname FROM groupTBL", null)
            var cursor_pw = sqlDB.rawQuery("SELECT passwd FROM groupTBL", null)

            while(cursor_id.moveToNext()){
                if(cursor_id.getString(0) == idEdittext.text.toString()) {
                    Toast.makeText(this, "아이디 성공", Toast.LENGTH_SHORT).show()

                    while (cursor_pw.moveToNext()) {
                        if (cursor_pw.getString(0) == pwEdittext.text.toString()) {
                            Toast.makeText(this, "비번 성공", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, NaviActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }

        }

        joinButton.setOnClickListener{
            // intent로 회원가입 창으로 이동
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}