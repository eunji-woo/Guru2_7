package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

class MenuActivity : AppCompatActivity() {

    lateinit var scrollLayout: LinearLayout
    lateinit var orderButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var shop_name = intent.getStringExtra("shop_name")
        val spinner_wfp = findViewById<Spinner>(R.id.spinner_wfp)
        val spinner_wft = findViewById<Spinner>(R.id.spinner_wft)
        val orderButton = findViewById<Button>(R.id.orderButton)

        scrollLayout = findViewById(R.id.scrollLayout)

        var in_array = arrayOf("바삭 닭껍질튀김(쉑쉑시즈닝)(스위트칠리+양파크리미)포함 - 소 4500", "바삭 닭껍질튀김(쉑쉑시즈닝)(스위트칠리+양파크리미)포함 - 대 9500",
            "바삭 닭껍질튀김(스위트칠리소스포함) - 소 4000", "바삭 닭껍질튀김(스위트칠리소스포함) - 대 9000", "치즈볼 4000", "모듬감자튀김 4000",
            "크런치 양파스틱 2500", "칼릭디핑소스 500", "양파크리미소스 500", "스위트칠리소스 500", "콘샐러드(새콤달콤) 2000",
            "무추가 500", "튀긴마늘 슬라이스 500", "콜라 1500", "사이다 1500")

        var wf_array = arrayOf("애플시나몬와플 3,200", "민트초코와플 4,200", "크런치딸기잼와플 4,000","티라미수와플 4,900","오레오누텔라와플 4,000",
            "바나나누텔라와플 4,500","생딸기누텔라와플 4,900","생딸기듬뿍와플 5,400","생딸기케이크와플 5,400","젤라또와플 4,700","크림젤라또와플 5,200","싸만코젤라또와플 5,500","초코범벅젤라또와플 5,200","오레오누텔라젤라또와플 5,500",
            "블루베리젤라또와플 5,500","베리베리젤라또와플 5,700","생딸기누텔라젤라또와플 5,900","치즈케이크누텔라젤라또와플 5,900",
            "생딸기범벅젤라또와플 5,700","블루베리범벅젤라또와플 5,500", "망고범벅젤라또와플 5,500", "치즈범벅젤라또와플 5,700", "크런치딸기잼젤라또와플 5,500", "크림와플 2,500", "생딸기와플 4,400", "메이플시나몬 2,900", "17곡 와플 3,400",
            "스노우와플 3,200", "팥스노우와플 3,900", "허니브레드와플 3,200", "밀크카라멜와플 3,500", "호두고구마와플 3,900",
            "치즈케이크앤크랜베리와플 4,200", "바나나와플 4,000", "블루베리와플 4,000", "베리베리와플 4,200", "젤라또컵 3,800 (10가지 젤라또 중 1 선택)", "오레오젤라또컵 4,000", "블루베리젤라또컵 4,500",
            "베리베리젤라또컵 4,700", "치즈케이크젤라또컵 5,000", "생딸기젤라또컵 5,200", "크런치딸기잼젤라또컵 4,500", "팥젤라또컵 4,500", "아메리카노 3,000", "카페라떼 3,800", "바닐라라떼 4,300",
            "브라운슈가라떼 4,500", "카페모카 4,500", "카라멜마끼야또 4,500", "깔라만시차 3,000", "유자차 4,000", "자몽차 4,000", "허브티 4,000",
            "리얼초코라떼 4,500", "그린티라떼 4,500", "로열밀크티4,500", "고구마라떼4,500", "민트초코라떼 4,300", "민트초코프라페 5,000", "베이비치노 3,000", "아이스티 2,500",
            "체리톡톡 4,000", "자두주스 4,500", "스무디 4,900", "요거치노 4,900", "에이드 4,000")

        var mong_array = arrayOf("치킨라이스 5000", "소고기라이스 5500", "치킨감자 5500", "스킨칩스라이스 5500", "소고기감자 6000", "훈제치킨감자 6000",
            "훈제치킨라이스 5500", "소세지감자 5500", "치킨감자 5500", "감자튀김 2500", "새우튀김 3000", "치킨윙 3000", "사이다 1000", "콜라 1000", "델몬트 에이드 1000", "트레비 1500", "코트라베이스커피 2000")

        var ac_array = arrayOf("순한알밥 4,600", "약매알밥 5,000", "매콤알밥 5,000", "진매알밥 5,500", "진진매알밥 5,500", "마늘듬뿍매콤제육알밥 6,300", "불고기알밥 6,500",
            "진매불닭 6,000", "그릴드치킨알밥 6,000", "제육소세지세트 10,000", "카레알밥 5,800", "짜장알밥 5,800", "오밥 5,800", "갈릭알밥 5,500", "갈릭오밥 6,000", "갈릭그릴드치킨알밥 6,300",
            "355ml 코카콜라 1,500", "355ml 스프라이트 1,500", "355ml 스파클링청포도 1,500", "355ml 다이아몬드EC생수 1,500")

        var kim_array = arrayOf("김가네 김밥 3800", "참치마요김밥 4800", "소고기김밥 4800", "멸추김밥 4800", "체다치즈김밥 4300", "스팸김밥 4800", "불오뎅 김밥 4500",
            "바싹돈까스롤김밥 5000", "통새우롤김밥 5000", "모듬김밥 5800", "새우보리면김밥 5500", "킹크래미와사비김밥 5300", "치킨체다치즈김밥 5000", "유부우동 6000", "야채튀김우동 7000",
            "왕새우튀김우동 7500", "볶음우동 7500", "물냉면 7000", "비빔냉면 7000", "비빔보리국수 7000", "김치말이보리국소 7000", "떡만두국 7000", "바지락칼국수 7500", "육개장칼국수 7500",
            "라면 4000", "라볶이 6000", "쫄면 6500", "차닭물쫄면 7000", "얼큰해물우동 7500", "얼음보리소바 7000", "떡라면 4500", "치즈라멘 4500", "치즈불닭쫄면 8000", "스팸옛날도시락 6500",
            "철판새웋함박 8500", "철판피즈김치볶음밥 8000", "스팸김치볶음밥 7000", "오믈렛라이스 7000", "빠에야새우볶음밥 7000", "해산볶음밥 7000", "오불덮밥 8000", "낚지덮밥 8000", "소불고기덮밥 7500",
            "돈커리덮밥 7500", "제육덮밥 8000", "알촉촉밥 7500", "비빔밥 6500", "뚝배기불고기 7500", "묵은지김치찌개 7000", "순두부찌개 7000", "1인부대찌개 8000", "차돌된장찌개 7000", "소고기육개장 7500",
            "등심돈까스 8000", "치즈돈까스 8500", "김치가츠동 7500", "간장돈불고기덮밥 7000", "치킨마요덮밥 6000", "1인치즈닭갈비 8000", "건강하닭죽 6800", "갈비만두 5000", "김치만두 5000", "쌀떡볶이 5000",
            "치즈떡볶이 6000", "왕새우튀김 1700", "야채튀김 2500", "the 맛있는오뎅 6000", "공기밥 1000", "홍콩식군만두 5500", "스페셜 모듬튀김 5500", "사이다 1500", "콜라 1500", "환타 1500")

        if(shop_name == "in"){
            for (i in in_array.indices){
                val checkBox = CheckBox(this)
                checkBox.text = in_array[i]
                scrollLayout.addView(checkBox, 0)
            }
        }
        else if (shop_name == "wf"){
            for (i in wf_array.indices){
                val checkBox = CheckBox(this)
                checkBox.text = wf_array[i]
                scrollLayout.addView(checkBox, 0)
            }
        }
        else if (shop_name == "mong"){
            for (i in mong_array.indices){
                val checkBox = CheckBox(this)
                checkBox.text = mong_array[i]
                scrollLayout.addView(checkBox,0)
            }
        }
        else if (shop_name == "ac"){
            for (i in ac_array.indices){
                val checkBox = CheckBox(this)
                checkBox.text = ac_array[i]
                scrollLayout.addView(checkBox, 0)
            }
        }
        else if (shop_name == "kim") {
            for (i in kim_array.indices) {
                val checkBox = CheckBox(this)
                checkBox.text = kim_array[i]
                scrollLayout.addView(checkBox, 0)
            }
        }

        val place = resources.getStringArray(R.array.place_array)
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_wfp.adapter = Adapter_place
        spinner_wfp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        Log.d("MyTag", "0번 선택") //test 용, 나중에 db 구현하면 item 선택될때 각각 어떻게 될지 구현하면됨
                    }
                    1 -> {
                        Log.d("MyTag", "1번 선택")
                    }
                    else -> {
                        Log.d("MyTag", "0,1말고 다른거 선택")
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d("MyTag", "아무것도 선택안됨")
            }
        }

        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_wft.adapter = Adapter_time
        spinner_wft.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        Log.d("MyTag", "0번 선택") //test 용, 나중에 db 구현하면 item 선택될때 각각 어떻게 될지 구현하면됨
                    }
                    1 -> {
                        Log.d("MyTag", "1번 선택")
                    }
                    else -> {
                        Log.d("MyTag", "0,1말고 다른거 선택")
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Log.d("MyTag", "아무것도 선택안됨")
            }
        }

        orderButton.setOnClickListener {
            // 주문현황으로 이동
            val intent = Intent(this, Order1_Activity::class.java)
            startActivity(intent)
        }
    }
}