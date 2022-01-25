package com.example.guru2_7

import android.content.Context
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class joinActivity : AppCompatActivity() {

    lateinit var join_idEdittext: EditText
    lateinit var join_emailEdittext: EditText
    lateinit var join_pwEdittext: EditText
    lateinit var join_pwEdittext2: EditText
    lateinit var join_joinButton: Button

    lateinit var myHelper: joinActivity.myDBHelper
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join_idEdittext = findViewById(R.id.join_idEdittext)
        join_emailEdittext = findViewById(R.id.join_emailEdittext)
        join_pwEdittext = findViewById(R.id.join_pwEdittext)
        join_pwEdittext2 = findViewById(R.id.join_pwEdittext2)
        join_joinButton = findViewById(R.id.join_joinButton)

        myHelper = myDBHelper(this)

        join_joinButton.setOnClickListener {
            sqlDB = myHelper.writableDatabase

            if(join_idEdittext.text.isEmpty() || join_emailEdittext.text.isEmpty() || join_pwEdittext.text.isEmpty() || join_pwEdittext2.text.isEmpty()){ // 정보 입력 제대로 안한 경우 제대로 입력하라는 toast 메시지
                Toast.makeText(applicationContext, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{ // 정보 다 제대로 입력해서 로그인 창으로 intent
                if(join_pwEdittext.text.toString() == join_pwEdittext2.text.toString()){
                    sqlDB.execSQL("INSERT INTO groupTBL VALUES ('" + join_idEdittext.text.toString() + "'," + join_emailEdittext.text.toString() +" , "+ join_pwEdittext.text.toString() + ");")
                    sqlDB.close()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent) // 회원가입 성공시 로그인 화면으로 intent
                }
                else{
                    Toast.makeText(applicationContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    inner class myDBHelper(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1){
        override fun onCreate(db: SQLiteDatabase?) {
            db!!.execSQL("CREATE TABLE groupTBL (nickname CHAR(20), email CHAR(30) PRIMARY KEY, passwd CHAR(30));")
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            db!!.execSQL("DROP TABLE IF EXISTS groupTBL")
            onCreate(db)
        }
    }

}