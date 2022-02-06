package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

//비밀번호 변경 Activity
class ChangeActivity : AppCompatActivity() {

    //button 과 edittext 선언
    lateinit var ChangeOkButton: Button
    lateinit var before_pwEdittext: EditText
    lateinit var after_pwEdittext: EditText
    lateinit var after_pwEdittext2: EditText

    //DB 사용을 위한 선언
    lateinit var dbManager: DBManager
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        ChangeOkButton = findViewById(R.id.ChangeOkButton)
        before_pwEdittext = findViewById(R.id.before_pwEdittext)
        after_pwEdittext = findViewById(R.id.after_pwEdittext)
        after_pwEdittext2 = findViewById(R.id.after_pwEdittext2)

        dbManager = DBManager(this)

        //비밀번호 변경 검증
        ChangeOkButton.setOnClickListener{

            sqlDB = dbManager.writableDatabase


            // 모든 정보를 입력했는지 검증
            if(after_pwEdittext.text.isEmpty() || after_pwEdittext2.text.isEmpty() ){ // 정보 입력 제대로 안한 경우 제대로 입력하라는 toast 메시지
                Toast.makeText(applicationContext, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{ // 모든 정보 입력 완료 시 처리
                if(after_pwEdittext.text.isEmpty() || after_pwEdittext2.text.isEmpty() ){ // 정보 입력 제대로 안한 경우 제대로 입력하라는 toast 메시지
                    Toast.makeText(applicationContext, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
                else{ // 모든 정보 입력 완료 시 처리
                    if(after_pwEdittext.text.toString() == after_pwEdittext2.text.toString()){
                        // 바꾸려는 비밀번호가 형식에 맞는지 검증
                        if(!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", after_pwEdittext.text)){
                            Toast.makeText(applicationContext, "비밀번호 형식을 지켜주세요.", Toast.LENGTH_SHORT).show()
                        }
                        else{
                            sqlDB.execSQL("UPDATE groupTBL SET passwd = '" + after_pwEdittext.text + "' WHERE passwd = '" + before_pwEdittext.text + "';")
                            sqlDB.close()
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent) //비밀번호 변경 성공 후 로그인 화면(첫 화면)으로 intent
                        }
                    }
                    else{ // 비밀번호 확인을 위해 2번 입력한 비밀번호가 서로 다를 때 예외 처리
                        Toast.makeText(applicationContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}