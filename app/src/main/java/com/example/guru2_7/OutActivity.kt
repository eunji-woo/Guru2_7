package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class OutActivity : AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlDB1: SQLiteDatabase
    lateinit var sqlDB2: SQLiteDatabase
    lateinit var Outpw: TextView
    lateinit var OutButton2: Button
    lateinit var Outname:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out)

        OutButton2=findViewById(R.id.OutButton2)
        Outpw=findViewById(R.id.Outpw)
        Outname=findViewById(R.id.Outname)

        OutButton2.setOnClickListener {

            sqlDB1 = dbManager.readableDatabase
            sqlDB2 = dbManager.writableDatabase

            var cursor = sqlDB1.rawQuery("SELECT * FROM groupTBL", null)

            while(cursor.moveToNext()) {
                if (cursor.getString(0) == Outname.text.toString() && cursor.getString(2) == Outpw.text.toString()) {
                    sqlDB2.execSQL("DELETE FROM groupTBL WHERE nickname = '" + Outname.text.toString()+ "';")
                    sqlDB2.close()
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