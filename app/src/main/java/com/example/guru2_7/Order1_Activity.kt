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

    lateinit var textView5 : TextView
    lateinit var textView6 : TextView

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
        scrollLayout = findViewById(R.id.scrollLayout)
        textView5 = findViewById(R.id.textView5)
        textView6 = findViewById(R.id.textView5)

        var shop_name = intent.getStringExtra("shop_name")
        var sqlResult = ""
        var sqlName = ""
        var sqlPlace = ""
        var sqlTime = ""

        if (shop_name == "in") {
            indbManager = inDBManager(this)
            sqlDB = indbManager.writableDatabase
            var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
            var index = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                sqlPlace = " ${cursor.getString(12)}"
                sqlTime = " ${cursor.getString(13)}"

                textView2.text = sqlName.plus(sqlPlace).plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                scrollLayout.addView(textView1, -1)
                scrollLayout.addView(textView2, -1)
                scrollLayout.addView(textView3, -1)
            }
            cursor.close()
            sqlDB.close()

        } else if (shop_name == "wf") {
            wfdbManager = wfDBManager(this)
            sqlDB = wfdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM wfTBL", null)

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                sqlPlace = " ${cursor.getString(12)}"
                sqlTime = " ${cursor.getString(13)}"

                textView2.text = sqlName.plus(sqlPlace).plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                scrollLayout.addView(textView1, -1)
                scrollLayout.addView(textView2, -1)
                scrollLayout.addView(textView3, -1)
            }
            cursor.close()
            sqlDB.close()

        } else if (shop_name == "mong") {
            mongdbManager = mongDBManager(this)
            sqlDB = mongdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM mongTBL", null)

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                sqlPlace = " ${cursor.getString(12)}"
                sqlTime = " ${cursor.getString(13)}"

                textView2.text = sqlName.plus(sqlPlace).plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                scrollLayout.addView(textView1, -1)
                scrollLayout.addView(textView2, -1)
                scrollLayout.addView(textView3, -1)
            }
            cursor.close()
            sqlDB.close()

        } else if (shop_name == "ac") {
            acdbManager = acDBManager(this)
            sqlDB = acdbManager.writableDatabase
            //shop_name="in"

            var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                sqlPlace = " ${cursor.getString(12)}"
                sqlTime = " ${cursor.getString(13)}"

                textView2.text = sqlName.plus(sqlPlace).plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                scrollLayout.addView(textView1, -1)
                scrollLayout.addView(textView2, -1)
                scrollLayout.addView(textView3, -1)
            }
            cursor.close()
            sqlDB.close()

        } else if (shop_name == "kim") {
            kimdbManager = kimDBManager(this)
            sqlDB = kimdbManager.writableDatabase

            var cursor = sqlDB.rawQuery("SELECT * FROM kimTBL", null)

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                sqlPlace = " ${cursor.getString(12)}"
                sqlTime = " ${cursor.getString(13)}"

                textView2.text = sqlName.plus(sqlPlace).plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                scrollLayout.addView(textView1, -1)
                scrollLayout.addView(textView2, -1)
                scrollLayout.addView(textView3, -1)
            }
            cursor.close()
            sqlDB.close()
        }



        OrderOkButton.setOnClickListener {

            //if문으로 주문자랑 참여자 구분해야됨 (아직 그쪽 부분 구현이 안돼서 if문 일단 뺌)
            if (shop_name == "in") {
                indbManager = inDBManager(this)
                sqlDB = indbManager.writableDatabase
                indbManager.onUpgrade(sqlDB, 1, 2)
                Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NaviActivity::class.java)
                startActivity(intent)
                sqlDB.close()
            } else if (shop_name == "wf") {
                wfdbManager = wfDBManager(this)
                sqlDB = wfdbManager.writableDatabase
                wfdbManager.onUpgrade(sqlDB, 1, 2)
                Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NaviActivity::class.java)
                startActivity(intent)
                sqlDB.close()
            } else if (shop_name == "mong") {
                mongdbManager = mongDBManager(this)
                sqlDB = mongdbManager.writableDatabase
                mongdbManager.onUpgrade(sqlDB, 1, 2)
                Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NaviActivity::class.java)
                startActivity(intent)
                sqlDB.close()
            } else if (shop_name == "ac") {
                acdbManager = acDBManager(this)
                sqlDB = acdbManager.writableDatabase
                acdbManager.onUpgrade(sqlDB, 1, 2)
                Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NaviActivity::class.java)
                startActivity(intent)
                sqlDB.close()
            } else if (shop_name == "kim") {
                kimdbManager = kimDBManager(this)
                sqlDB = kimdbManager.writableDatabase
                kimdbManager.onUpgrade(sqlDB, 1, 2)
                Toast.makeText(this, "주문이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NaviActivity::class.java)
                startActivity(intent)
                sqlDB.close()
            }
        }
    }

}