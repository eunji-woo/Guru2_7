package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat

class Order1_Activity : AppCompatActivity() {
    lateinit var OrderOkButton : Button
    lateinit var scrollLayout: LinearLayout

    lateinit var acdbManager: acDBManager
    lateinit var kimdbManager: kimDBManager
    lateinit var mongdbManager: mongDBManager
    lateinit var indbManager: inDBManager
    lateinit var wfdbManager: wfDBManager
    lateinit var sqlDB: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order1_)

        OrderOkButton = findViewById(R.id.OrderOkButton)
        scrollLayout =findViewById(R.id.scrollLayout)

        var shop_name = intent.getStringExtra("shop_name")
        var sqlResult = ""

        if(shop_name == "in"){
            indbManager = inDBManager(this)
            sqlDB = indbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)

            while(cursor.moveToNext()) {
                val textView = TextView(this)
                val textView2 = TextView(this)
                sqlResult = cursor.getString(0).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ").plus(", "+cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," "))
                sqlResult = sqlResult.replace(", , , , , , , , , ","").replace(", , , , , , , , ","").replace(", , , , , , , ","").replace(", , , , , , ","").replace(", , , , , ","").replace(", , , , ","").replace(", , , ","").replace(", , "," ").replace(",  "," ")
                textView.background = ContextCompat.getDrawable(this, R.color.purple)
                textView.text = sqlResult
                scrollLayout.addView(textView, 0)
                scrollLayout.addView(textView2, 0)
            }

        }
        else if (shop_name == "wf"){
            wfdbManager = wfDBManager(this)
            sqlDB = wfdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM wfTBL", null)

            while(cursor.moveToNext()) {
                val textView = TextView(this)
                val textView2 = TextView(this)
                sqlResult = cursor.getString(0).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ").plus(", "+cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," "))
                sqlResult = sqlResult.replace(", , , , , , , , , ","").replace(", , , , , , , , ","").replace(", , , , , , , ","").replace(", , , , , , ","").replace(", , , , , ","").replace(", , , , ","").replace(", , , ","").replace(", , "," ").replace(",  "," ")
                textView.background = ContextCompat.getDrawable(this, R.color.purple)
                textView.text = sqlResult
                scrollLayout.addView(textView, 0)
                scrollLayout.addView(textView2, 0)
            }
        }
        else if (shop_name == "mong"){
            mongdbManager = mongDBManager(this)
            sqlDB = mongdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM mongTBL", null)

            while(cursor.moveToNext()) {
                val textView = TextView(this)
                val textView2 = TextView(this)
                sqlResult = cursor.getString(0).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ").plus(", "+cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," "))
                sqlResult = sqlResult.replace(", , , , , , , , , ","").replace(", , , , , , , , ","").replace(", , , , , , , ","").replace(", , , , , , ","").replace(", , , , , ","").replace(", , , , ","").replace(", , , ","").replace(", , "," ").replace(",  "," ")
                textView.background = ContextCompat.getDrawable(this, R.color.purple)
                textView.text = sqlResult
                scrollLayout.addView(textView, 0)
                scrollLayout.addView(textView2, 0)
            }
        }
        else if (shop_name == "ac"){
            acdbManager = acDBManager(this)
            sqlDB = acdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)

            while(cursor.moveToNext()) {
                val textView = TextView(this)
                val textView2 = TextView(this)
                sqlResult = cursor.getString(0).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ").plus(", "+cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," "))
                sqlResult = sqlResult.replace(", , , , , , , , , ","").replace(", , , , , , , , ","").replace(", , , , , , , ","").replace(", , , , , , ","").replace(", , , , , ","").replace(", , , , ","").replace(", , , ","").replace(", , "," ").replace(",  "," ")
                textView.background = ContextCompat.getDrawable(this, R.color.purple)
                textView.text = sqlResult
                scrollLayout.addView(textView, 0)
                scrollLayout.addView(textView2, 0)
            }
        }
        else if (shop_name == "kim") {
            kimdbManager = kimDBManager(this)
            sqlDB = kimdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM kimTBL", null)

            while(cursor.moveToNext()) {
                val textView = TextView(this)
                val textView2 = TextView(this)
                sqlResult = cursor.getString(0).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ").plus(", "+cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " +cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex()," "))
                sqlResult = sqlResult.replace(", , , , , , , , , ","").replace(", , , , , , , , ","").replace(", , , , , , , ","").replace(", , , , , , ","").replace(", , , , , ","").replace(", , , , ","").replace(", , , ","").replace(", , "," ").replace(",  "," ")
                textView.background = ContextCompat.getDrawable(this, R.color.purple)
                textView.text = sqlResult
                scrollLayout.addView(textView, 0)
                scrollLayout.addView(textView2, 0)
            }
        }




        OrderOkButton.setOnClickListener {
            if (false){
                // 주문자가 완료버튼을 누르면 게시글 삭제 + 식당선택으로 돌아가기
            }
            else{
                // 주문자가 아닌 사람이 완료버튼을 누를 경우
                Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
