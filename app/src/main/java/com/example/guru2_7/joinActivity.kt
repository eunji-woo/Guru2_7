package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception
import java.util.regex.Pattern
//회원가입 Activity
class joinActivity : AppCompatActivity() {

    //button 과 edittext 선언
    lateinit var join_nameEdittext: EditText
    lateinit var join_emailEdittext: EditText
    lateinit var join_pwEdittext: EditText
    lateinit var join_pwEdittext2: EditText
    lateinit var join_joinButton: Button

    //DB 사용을 위한 선언
    lateinit var dbManager: DBManager
    lateinit var sqlDB: SQLiteDatabase

    var swumail = "@swu.ac.kr"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        join_nameEdittext = findViewById(R.id.join_nameEdittext)
        join_emailEdittext = findViewById(R.id.join_emailEdittext)
        join_pwEdittext = findViewById(R.id.join_pwEdittext)
        join_pwEdittext2 = findViewById(R.id.join_pwEdittext2)
        join_joinButton = findViewById(R.id.join_joinButton)

        dbManager = DBManager(this)

        //회원가입 검증
        join_joinButton.setOnClickListener {
            sqlDB = dbManager.writableDatabase

            //정보를 모두 입력하지 않았을 때, 서울여대 이메일이 아닐 때, 비밀번호 형식이 지켜지지 않았을 때를 차례로 if문으로 검증
            if(join_nameEdittext.text.isEmpty() || join_emailEdittext.text.isEmpty() || join_pwEdittext.text.isEmpty() || join_pwEdittext2.text.isEmpty()){ // 정보 입력 제대로 안한 경우 제대로 입력하라는 toast 메시지
                Toast.makeText(applicationContext, "정보를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else if(join_emailEdittext.text.contains(swumail)==false){
                Toast.makeText(applicationContext, "서울여대 이메일만 사용할 수 있습니다.", Toast.LENGTH_SHORT).show()
            }

            else if (!Pattern.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-zA-Z]).{8,20}$", join_pwEdittext.text)) {
                Toast.makeText(this, "비밀번호 형식을 지켜주세요.", Toast.LENGTH_SHORT).show()
            }
            else{ // 정보 다 제대로 입력해서 로그인 창으로 intent
                if(join_pwEdittext.text.toString() == join_pwEdittext2.text.toString()){
                    try{
                        sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"+join_nameEdittext.text.toString()+"','"+join_emailEdittext.text.toString()+"','"+join_pwEdittext.text.toString() +"');")
                        sqlDB.close()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent) // 회원가입 성공시 로그인 화면으로 intent
                    }
                    catch(e:Exception){
                        Toast.makeText(applicationContext, "이미 있는 닉네임입니다.", Toast.LENGTH_SHORT).show()
                    } //닉네임이 중복인 경우 예외 처리
                }
                else{
                    Toast.makeText(applicationContext, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}