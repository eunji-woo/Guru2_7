package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout

class inActivity : AppCompatActivity() {
    lateinit var scrollLayout:LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var dayArray = arrayOf("바삭 닭껍질튀김(쉑쉑시즈닝)(스위트칠리+양파크리미)포함 - 소 4500", "바삭 닭껍질튀김(쉑쉑시즈닝)(스위트칠리+양파크리미)포함 - 대 9500",
            "바삭 닭껍질튀김(스위트칠리소스포함) - 소 4000", "바삭 닭껍질튀김(스위트칠리소스포함) - 대 9000", "치즈볼 4000", "모듬감자튀김 4000",
            "크런치 양파스틱 2500", "칼릭디핑소스 500", "양파크리미소스 500", "스위트칠리소스 500", "콘샐러드(새콤달콤) 2000",
            "무추가 500", "튀긴마늘 슬라이스 500", "콜라 1500", "사이다 1500")

        scrollLayout = findViewById(R.id.scrollLayout)

        for (i in dayArray.indices){
            var checkBox = CheckBox(this)
            checkBox.text = dayArray[i]
            scrollLayout.addView(checkBox)
        }
    }
}
