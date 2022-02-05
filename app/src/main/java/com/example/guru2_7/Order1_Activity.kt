package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// 배달중 아이콘 관련 변수 ( 0일 때: GONE, 1일 때: VISIBLE )
var acResult = 0
var inResult = 0
var kimResult = 0
var mongResult = 0
var wfResult = 0

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
        var sqlTime = ""



        if (shop_name == "in") {
            indbManager = inDBManager(this)
            sqlDB = indbManager.writableDatabase
            var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
            var priceAll = 0

            while (cursor.moveToNext()) {
                val textView1 = TextView(this) // 공백
                val textView2 = TextView(this) // 닉네임, 시간
                val textView3 = TextView(this) // 메뉴

                // 주문자의 닉네임과 주문한 시간
                sqlName = " ${cursor.getString(0)}"
                sqlTime = " ${cursor.getString(14)}"

                // 선택한 메뉴 + 메뉴 개수에 따른 쉼표 처리
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")

                // 가격 합산 (주문들의 총 금액)
                priceAll = priceAll + cursor.getString(11).toInt()

                // 최초 주문자가 선택한 장소 및 시간, 총 금액 표시
                placeTextview.text = "$place_in"
                timeTextview.text = "$time_in"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName.plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                // textView 추가 (밑으로 추가됨)
                scrollLayout.addView(textView1, -1) // 공백
                scrollLayout.addView(textView2, -1) // 닉네임, 시간
                scrollLayout.addView(textView3, -1) // 메뉴
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
                val textView2 = TextView(this) // 닉네임, 시간
                val textView3 = TextView(this) // 메뉴

                // 주문자의 닉네임과 주문한 시간
                sqlName = " ${cursor.getString(0)}"
                sqlTime = " ${cursor.getString(14)}"

                // 선택한 메뉴 + 메뉴 개수에 따른 쉼표 처리
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")

                // 가격 합산 (주문들의 총 금액)
                priceAll = priceAll + cursor.getString(11).toInt()

                // 최초 주문자가 선택한 장소 및 시간, 총 금액 표시
                placeTextview.text = "$place_wf"
                timeTextview.text = "$time_wf"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName.plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                // textView 추가 (밑으로 추가됨)
                scrollLayout.addView(textView1, -1) // 공백
                scrollLayout.addView(textView2, -1) // 닉네임, 시간
                scrollLayout.addView(textView3, -1) // 메뉴
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
                val textView2 = TextView(this) // 닉네임, 시간
                val textView3 = TextView(this) // 메뉴

                // 주문자의 닉네임과 주문한 시간
                sqlName = " ${cursor.getString(0)}"
                sqlTime = " ${cursor.getString(14)}"

                // 선택한 메뉴 + 메뉴 개수에 따른 쉼표 처리
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")

                // 가격 합산 (주문들의 총 금액)
                priceAll = priceAll + cursor.getString(11).toInt()

                // 최초 주문자가 선택한 장소 및 시간, 총 금액 표시
                placeTextview.text = "$place_mong"
                timeTextview.text = "$time_mong"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName.plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                // textView 추가 (밑으로 추가됨)
                scrollLayout.addView(textView1, -1) // 공백
                scrollLayout.addView(textView2, -1) // 닉네임, 시간
                scrollLayout.addView(textView3, -1) // 메뉴
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
                val textView2 = TextView(this) // 닉네임, 시간
                val textView3 = TextView(this) // 메뉴

                // 주문자의 닉네임과 주문한 시간
                sqlName = " ${cursor.getString(0)}"
                sqlTime = " ${cursor.getString(14)}"

                // 선택한 메뉴 + 메뉴 개수에 따른 쉼표 처리
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")

                // 가격 합산 (주문들의 총 금액)
                priceAll = priceAll + cursor.getString(11).toInt()

                // 최초 주문자가 선택한 장소 및 시간, 총 금액 표시
                placeTextview.text = "$place_ac"
                timeTextview.text = "$time_ac"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName.plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                // textView 추가 (밑으로 추가됨)
                scrollLayout.addView(textView1, -1) // 공백
                scrollLayout.addView(textView2, -1) // 닉네임, 시간
                scrollLayout.addView(textView3, -1) // 메뉴
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
                val textView2 = TextView(this) // 닉네임, 시간
                val textView3 = TextView(this) // 메뉴

                // 주문자의 닉네임과 주문한 시간
                sqlName = " ${cursor.getString(0)}"
                sqlTime = " ${cursor.getString(14)}"

                // 선택한 메뉴 + 메뉴 개수에 따른 쉼표 처리
                sqlResult = cursor.getString(1).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ").plus(", " + cursor.getString(2).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(3).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(4).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(5).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(6).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(7).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(8).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(9).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " ")).plus(", " + cursor.getString(10).replace("\\r\\n|\\r|\\n|\\n\\r".toRegex(), " "))
                sqlResult = sqlResult.replace(", , , , , , , , , ", "").replace(", , , , , , , , ", "").replace(", , , , , , , ", "").replace(", , , , , , ", "").replace(", , , , , ", "").replace(", , , , ", "").replace(", , , ", "").replace(", , ", " ").replace(",  ", " ")

                // 가격 합산 (주문들의 총 금액)
                priceAll = priceAll + cursor.getString(11).toInt()

                // 최초 주문자가 선택한 장소 및 시간, 총 금액 표시
                placeTextview.text = "$place_kim"
                timeTextview.text = "$time_kim"
                priceTextview.text = priceAll.toString()

                textView2.text = sqlName.plus(sqlTime)
                textView3.background = ContextCompat.getDrawable(this, R.color.purple)
                textView3.text = sqlResult

                // textView 추가 (밑으로 추가됨)
                scrollLayout.addView(textView1, -1) // 공백
                scrollLayout.addView(textView2, -1) // 닉네임, 시간
                scrollLayout.addView(textView3, -1) // 메뉴
            }
            cursor.close()
            sqlDB.close()
        }


        OrderOkButton.setOnClickListener {
            var pref = this.getSharedPreferences("user",0)
            var nickname = pref.getString("nickname", "default").toString()

            if (shop_name == "in") {
                indbManager = inDBManager(this)
                sqlDB = indbManager.writableDatabase

                try {
                    var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
                    cursor.moveToNext()
                    // 최초 주문자가 주문완료 버튼을 눌렀을 때만 동작
                    if(cursor.getString(0).toString() == nickname.toString()){
                        indbManager.onUpgrade(sqlDB, 1, 2) // 테이블 초기화
                        in_count = 0 // 주문현황 개수 초기화
                        inResult = 1 // 배달중 아이콘 표시 (VISIBLE)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("shop_name", "in")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                    sqlDB.close()


                } catch (e:Exception){
                    Toast.makeText(applicationContext, "현재 진행중인 주문이 없습니다.", Toast.LENGTH_SHORT).show()

                }

            } else if (shop_name == "wf") {
                wfdbManager = wfDBManager(this)
                sqlDB = wfdbManager.writableDatabase

                try {
                    var cursor = sqlDB.rawQuery("SELECT * FROM wfTBL", null)
                    cursor.moveToNext()
                    // 최초 주문자가 주문완료 버튼을 눌렀을 때만 동작
                    if(cursor.getString(0).toString() == nickname.toString()){
                        wfdbManager.onUpgrade(sqlDB, 1, 2) // 테이블 초기화
                        in_count = 0 // 주문현황 개수 초기화
                        inResult = 1 // 배달중 아이콘 표시 (VISIBLE)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("shop_name", "wf")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                    sqlDB.close()


                } catch (e:Exception){
                    Toast.makeText(applicationContext, "현재 진행중인 주문이 없습니다.", Toast.LENGTH_SHORT).show()

                }


            } else if (shop_name == "mong") {
                mongdbManager = mongDBManager(this)
                sqlDB = mongdbManager.writableDatabase

                try {
                    var cursor = sqlDB.rawQuery("SELECT * FROM mongTBL", null)
                    cursor.moveToNext()
                    // 최초 주문자가 주문완료 버튼을 눌렀을 때만 동작
                    if(cursor.getString(0).toString() == nickname.toString()){
                        mongdbManager.onUpgrade(sqlDB, 1, 2) // 테이블 초기화
                        in_count = 0 // 주문현황 개수 초기화
                        inResult = 1 // 배달중 아이콘 표시 (VISIBLE)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("shop_name", "mong")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                    sqlDB.close()


                } catch (e:Exception){
                    Toast.makeText(applicationContext, "현재 진행중인 주문이 없습니다.", Toast.LENGTH_SHORT).show()

                }

            } else if (shop_name == "ac") {
                acdbManager = acDBManager(this)
                sqlDB = acdbManager.writableDatabase

                try {
                    var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)
                    cursor.moveToNext()
                    // 최초 주문자가 주문완료 버튼을 눌렀을 때만 동작
                    if(cursor.getString(0).toString() == nickname.toString()){
                        acdbManager.onUpgrade(sqlDB, 1, 2) // 테이블 초기화
                        in_count = 0 // 주문현황 개수 초기화
                        inResult = 1 // 배달중 아이콘 표시 (VISIBLE)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("shop_name", "ac")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                    sqlDB.close()


                } catch (e:Exception){
                    Toast.makeText(applicationContext, "현재 진행중인 주문이 없습니다.", Toast.LENGTH_SHORT).show()

                }


            } else if (shop_name == "kim") {
                kimdbManager = kimDBManager(this)
                sqlDB = kimdbManager.writableDatabase

                try {
                    var cursor = sqlDB.rawQuery("SELECT * FROM kimTBL", null)
                    cursor.moveToNext()
                    // 최초 주문자가 주문완료 버튼을 눌렀을 때만 동작
                    if(cursor.getString(0).toString() == nickname.toString()){
                        kimdbManager.onUpgrade(sqlDB, 1, 2) // 테이블 초기화
                        in_count = 0 // 주문현황 개수 초기화
                        inResult = 1 // 배달중 아이콘 표시 (VISIBLE)
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra("shop_name", "kim")
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "주문자만 완료할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                    sqlDB.close()


                } catch (e:Exception){
                    Toast.makeText(applicationContext, "현재 진행중인 주문이 없습니다.", Toast.LENGTH_SHORT).show()

                }

            }
        }
    }
}