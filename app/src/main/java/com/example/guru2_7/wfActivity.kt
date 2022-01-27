package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class wfActivity : AppCompatActivity() {
    lateinit var scrollLayout:LinearLayout
    val spinner_wfp = findViewById<Spinner>(R.id.spinner_wfp)
    val spinner_wft = findViewById<Spinner>(R.id.spinner_wft)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var dayArray = arrayOf("애플시나몬와플 3,200", "민트초코와플 4,200", "크런치딸기잼와플 4,000","티라미수와플 4,900","오레오누텔라와플 4,000",
            "바나나누텔라와플 4,500","생딸기누텔라와플 4,900","생딸기듬뿍와플 5,400","생딸기케이크와플 5,400","젤라또와플 4,700","크림젤라또와플 5,200","싸만코젤라또와플 5,500","초코범벅젤라또와플 5,200","오레오누텔라젤라또와플 5,500",
            "블루베리젤라또와플 5,500","베리베리젤라또와플 5,700","생딸기누텔라젤라또와플 5,900","치즈케이크누텔라젤라또와플 5,900",
            "생딸기범벅젤라또와플 5,700","블루베리범벅젤라또와플 5,500", "망고범벅젤라또와플 5,500", "치즈범벅젤라또와플 5,700", "크런치딸기잼젤라또와플 5,500", "크림와플 2,500", "생딸기와플 4,400", "메이플시나몬 2,900", "17곡 와플 3,400",
            "스노우와플 3,200", "팥스노우와플 3,900", "허니브레드와플 3,200", "밀크카라멜와플 3,500", "호두고구마와플 3,900",
            "치즈케이크앤크랜베리와플 4,200", "바나나와플 4,000", "블루베리와플 4,000", "베리베리와플 4,200", "젤라또컵 3,800 (10가지 젤라또 중 1 선택)", "오레오젤라또컵 4,000", "블루베리젤라또컵 4,500",
            "베리베리젤라또컵 4,700", "치즈케이크젤라또컵 5,000", "생딸기젤라또컵 5,200", "크런치딸기잼젤라또컵 4,500", "팥젤라또컵 4,500", "아메리카노 3,000", "카페라떼 3,800", "바닐라라떼 4,300",
            "브라운슈가라떼 4,500", "카페모카 4,500", "카라멜마끼야또 4,500", "깔라만시차 3,000", "유자차 4,000", "자몽차 4,000", "허브티 4,000",
            "리얼초코라떼 4,500", "그린티라떼 4,500", "로열밀크티4,500", "고구마라떼4,500", "민트초코라떼 4,300", "민트초코프라페 5,000", "베이비치노 3,000", "아이스티 2,500",
            "체리톡톡 4,000", "자두주스 4,500", "스무디 4,900", "요거치노 4,900", "에이드 4,000")

        scrollLayout = findViewById(R.id.scrollLayout)

        for (i in dayArray.indices){
            var checkBox = CheckBox(this)
            checkBox.text = dayArray[i]
            scrollLayout.addView(checkBox)
        }

        val place = resources.getStringArray(R.array.place_array)
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_wfp.adapter = Adapter_place
        spinner_wfp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_wft.adapter = Adapter_time
        spinner_wft.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }
}