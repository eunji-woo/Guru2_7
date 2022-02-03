package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import android.widget.TextView

var acResult=0
var inResult=0
var kimResult=0
var mongResult=0
var wfResult=0

class Order1_Activity : AppCompatActivity() {
    lateinit var OrderOkButton : Button
    lateinit var scrollLayout: LinearLayout

    lateinit var placeTextview : TextView
    lateinit var timeTextview : TextView
    lateinit var priceTextview : TextView

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
        placeTextview = findViewById(R.id.placeTextview)
        timeTextview = findViewById(R.id.timeTextview)
        priceTextview = findViewById(R.id.priceTextview)

        var shop_name = intent.getStringExtra("shop_name")
        var sqlResult = ""
        var sqlName = ""

        if (shop_name == "in") {
            indbManager = inDBManager(this)
            sqlDB = indbManager.writableDatabase
            var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                priceAll = priceAll + cursor.getString(11).toInt()

                placeTextview.text = "$place_in"
                timeTextview.text = "$time_in"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName
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
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                priceAll = priceAll + cursor.getString(11).toInt()

                placeTextview.text = "$place_wf"
                timeTextview.text = "$time_wf"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName
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
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                priceAll = priceAll + cursor.getString(11).toInt()

                placeTextview.text = "$place_mong"
                timeTextview.text = "$time_mong"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName
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
            var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                priceAll = priceAll + cursor.getString(11).toInt()

                placeTextview.text = "$place_ac"
                timeTextview.text = "$time_ac"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName
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
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임
                val textView3 = TextView(this) // 메뉴

                sqlName = " ${cursor.getString(0)}"
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")
                priceAll = priceAll + cursor.getString(11).toInt()

                placeTextview.text = "$place_kim"
                timeTextview.text = "$time_kim"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName
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


            var pref = this.getSharedPreferences("user",0)
            var nickname = pref.getString("nickname", "default").toString()

            //if문으로 주문자랑 참여자 구분해야됨 (아직 그쪽 부분 구현이 안돼서 if문 일단 뺌)
            if (shop_name == "in") {
                indbManager = inDBManager(this)
                sqlDB = indbManager.writableDatabase

                var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
                cursor.moveToNext()

                if(cursor.getString(0).toString() == nickname.toString()){
                    indbManager.onUpgrade(sqlDB, 1, 2)
                    in_count = 0
                    inResult = 1
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("shop_name", "in")
                    startActivity(intent)
                }

                else{
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }

                sqlDB.close()
            } else if (shop_name == "wf") {
                wfdbManager = wfDBManager(this)
                sqlDB = wfdbManager.writableDatabase

                var cursor = sqlDB.rawQuery("SELECT * FROM wfTBL", null)
                cursor.moveToNext()

                if(cursor.getString(0).toString() == nickname.toString()){
                    wfdbManager.onUpgrade(sqlDB, 1, 2)
                    wf_count = 0
                    wfResult = 1
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("shop_name", "wf")
                    startActivity(intent)
                }

                else{
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }

                sqlDB.close()
            } else if (shop_name == "mong") {
                mongdbManager = mongDBManager(this)
                sqlDB = mongdbManager.writableDatabase

                var cursor = sqlDB.rawQuery("SELECT * FROM mongTBL", null)
                cursor.moveToNext()

                if(cursor.getString(0).toString() == nickname.toString()) {
                    mongdbManager.onUpgrade(sqlDB, 1, 2)
                    mong_count = 0
                    mongResult = 1
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("shop_name", "mong")
                    startActivity(intent)
                }

                else{
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }

                sqlDB.close()
            } else if (shop_name == "ac") {
                acdbManager = acDBManager(this)
                sqlDB = acdbManager.writableDatabase

                var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)
                cursor.moveToNext()

                if(cursor.getString(0).toString() == nickname.toString()) {
                    acdbManager.onUpgrade(sqlDB, 1, 2)
                    ac_count = 0
                    acResult = 1
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("shop_name", "ac")
                    startActivity(intent)
                }

                else{
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }

                sqlDB.close()
            } else if (shop_name == "kim") {
                kimdbManager = kimDBManager(this)
                sqlDB = kimdbManager.writableDatabase

                var cursor = sqlDB.rawQuery("SELECT * FROM kimTBL", null)
                cursor.moveToNext()

                if(cursor.getString(0).toString() == nickname.toString()) {
                    kimdbManager.onUpgrade(sqlDB, 1, 2)
                    kim_count = 0
                    kimResult = 1
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("shop_name", "kim")
                    startActivity(intent)
                }

                else{
                    val intent = Intent(this, NaviActivity::class.java)
                    startActivity(intent)
                }

                sqlDB.close()
            }
        }
    }

}