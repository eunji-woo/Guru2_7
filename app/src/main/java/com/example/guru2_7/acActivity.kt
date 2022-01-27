package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout

class acActivity : AppCompatActivity() {

    lateinit var scrollLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac)

        var dayArray = arrayOf("순한알밥 4,600", "약매알밥 5,000", "매콤알밥 5,000", "진매알밥 5,500", "진진매알밥 5,500", "마늘듬뿍매콤제육알밥 6,300", "불고기알밥 6,500",
            "진매불닭 6,000", "그릴드치킨알밥 6,000", "제육소세지세트 10,000", "카레알밥 5,800", "짜장알밥 5,800", "오밥 5,800", "갈릭알밥 5,500", "갈릭오밥 6,000", "갈릭그릴드치킨알밥 6,300",
            "355ml 코카콜라 1,500", "355ml 스프라이트 1,500", "355ml 스파클링청포도 1,500", "355ml 다이아몬드EC생수 1,500")

        scrollLayout = findViewById(R.id.scrollLayout)

        for (i in dayArray.indices){
            var checkBox = CheckBox(this)
            checkBox.text = dayArray[i]
            scrollLayout.addView(checkBox)
        }
    }
}