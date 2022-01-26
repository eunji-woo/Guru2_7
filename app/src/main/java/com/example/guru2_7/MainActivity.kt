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

            var cursor = sqlDB.rawQuery("SELECT nickname FROM groupTBL WHERE id = '" + idEdittext + "'", null)

            if(cursor.getCount() != 1){
                //아이디가 틀렸습니다.
                Toast.makeText(this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT).show()
            }

            /*var sql = "SELECT pw FROM " + dbManager.tableName + " WHERE id = '" + id + "'";
            cursor = database.rawQuery(sql, null);
            if(cursor.moveToNext()){
                if(!pw.equals(cursor.getString(0))){
                    //비밀번호가 틀렸습니다.
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

                }else{
                    //로그인성공
                    Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                }
            }*/

        }

        joinButton.setOnClickListener{
            // intent로 회원가입 창으로 이동
            val intent = Intent(this, joinActivity::class.java)
            startActivity(intent)
        }
    }
}