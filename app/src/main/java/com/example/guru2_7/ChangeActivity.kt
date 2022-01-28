package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ChangeActivity : AppCompatActivity() {
    lateinit var ChangeOkButton: Button
    //lateinit var name_Edittext: EditText
    lateinit var before_pwEdittext: EditText
    lateinit var after_pwEdittext: EditText
    lateinit var after_pwEdittext2: EditText

    lateinit var dbManager: DBManager
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        //name_Edittext = findViewById(R.id.name_Edittext)
        ChangeOkButton = findViewById(R.id.ChangeOkButton)
        before_pwEdittext = findViewById(R.id.before_pwEdittext)
        after_pwEdittext = findViewById(R.id.after_pwEdittext)
        after_pwEdittext2 = findViewById(R.id.after_pwEdittext2)

        dbManager = DBManager(this)

        ChangeOkButton.setOnClickListener{

            sqlDB = dbManager.writableDatabase

            if(after_pwEdittext.text.isEmpty() || after_pwEdittext2.text.isEmpty() ){ // 정보 입력 제대로 안한 경우 제대로 입력하라는 toast 메시지
                Toast.makeText(applicationContext, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{ // 정보 다 제대로 입력해서 로그인 창으로 intent
                if(after_pwEdittext.text.toString() == after_pwEdittext2.text.toString()){
                    sqlDB.execSQL("UPDATE groupTBL SET passwd = "+after_pwEdittext.text + " WHERE passwd = '" + before_pwEdittext.text.toString()+"';")
                    sqlDB.close()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent) // 비밀번호 변경 성공시 로그인 화면으로 intent
                }
                else{
                    Toast.makeText(applicationContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                }

            }
        }
    }
}