package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
//회원탈퇴 Activity
class OutActivity : AppCompatActivity() {

    //button 과 edittext, DB 사용을 위한 선언
    lateinit var dbManager: DBManager
    lateinit var sqlDB: SQLiteDatabase
    lateinit var Outpw: TextView
    lateinit var OutButton2: Button
    lateinit var Outid:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out)

        OutButton2=findViewById(R.id.OutButton2)
        Outpw=findViewById(R.id.Outpw)
        Outid=findViewById(R.id.Outid)

        dbManager = DBManager(this)

        //회원탈퇴 검증
        OutButton2.setOnClickListener {

            sqlDB = dbManager.writableDatabase

            //DB에서 계정정보 가져와서 비교
            var cursor = sqlDB.rawQuery("SELECT * FROM groupTBL", null)

            while(cursor.moveToNext()) {
                if (cursor.getString(1) == Outid.text.toString() && cursor.getString(2) == Outpw.text.toString()) {
                    sqlDB.execSQL("DELETE FROM groupTBL WHERE email = '" + Outid.text.toString()+ "';")
                    sqlDB.close()
                    Toast.makeText(this, "탈퇴되었습니다.", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "다시 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}