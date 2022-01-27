package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout

class mongActivity : AppCompatActivity() {

    lateinit var scrollLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mong)

        var dayArray = arrayOf("치킨라이스 5000", "소고기라이스 5500", "치킨감자 5500", "스킨칩스라이스 5500", "소고기감자 6000", "훈제치킨감자 6000",
            "훈제치킨라이스 5500", "소세지감자 5500", "치킨감자 5500", "감자튀김 2500", "새우튀김 3000", "치킨윙 3000", "사이다 1000", "콜라 1000", "델몬트 에이드 1000", "트레비 1500", "코트라베이스커피 2000")

        scrollLayout = findViewById(R.id.scrollLayout)

        for (i in dayArray.indices){
            var checkBox = CheckBox(this)
            checkBox.text = dayArray[i]
            scrollLayout.addView(checkBox)
        }
    }
}