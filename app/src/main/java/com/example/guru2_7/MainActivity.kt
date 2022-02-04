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

                    var pref = this.getSharedPreferences("user",0)
                    var editor = pref.edit()

                    editor.putString("nickname", cursor.getString(0)).apply()
                    editor.putString("email", cursor.getString(1)).apply()

                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
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