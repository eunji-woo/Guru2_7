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

            var cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null)

            while(cursor.moveToNext()) {
                if (cursor.getString(1) == idEdittext.text.toString() && cursor.getString(2) == pwEdittext.text.toString()) {
                    Toast.makeText(this, "환영합니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }

//            var cursor_id = sqlDB.rawQuery("SELECT nickname FROM groupTBL", null)
//            var cursor_pw = sqlDB.rawQuery("SELECT passwd FROM groupTBL", null)
//
//            while(cursor_id.moveToNext()){
//                if(cursor_id.getString(0) == idEdittext.text.toString()) {
//                    while (cursor_pw.moveToNext()) {
//                        if (cursor_pw.getString(0) == pwEdittext.text.toString()) {
//                            Toast.makeText(this, "환영합니다.", Toast.LENGTH_SHORT).show()
//                            val intent = Intent(this, NaviActivity::class.java)
//                            startActivity(intent)
//                        }
//                        else{
//                            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
//                        }
//                    }
//                }
//                else{
//                    Toast.makeText(this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show()
//                }
//            }

        }

        joinButton.setOnClickListener{
            // intent로 회원가입 창으로 이동
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}