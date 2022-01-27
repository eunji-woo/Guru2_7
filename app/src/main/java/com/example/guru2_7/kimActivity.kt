package com.example.guru2_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout

class kimActivity : AppCompatActivity() {
    lateinit var scrollLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kim)

        var dayArray = arrayOf("김가네 김밥 3800", "참치마요김밥 4800", "소고기김밥 4800", "멸추김밥 4800", "체다치즈김밥 4300", "스팸김밥 4800", "불오뎅 김밥 4500",
            "바싹돈까스롤김밥 5000", "통새우롤김밥 5000", "모듬김밥 5800", "새우보리면김밥 5500", "킹크래미와사비김밥 5300", "치킨체다치즈김밥 5000", "유부우동 6000", "야채튀김우동 7000",
            "왕새우튀김우동 7500", "볶음우동 7500", "물냉면 7000", "비빔냉면 7000", "비빔보리국수 7000", "김치말이보리국소 7000", "떡만두국 7000", "바지락칼국수 7500", "육개장칼국수 7500",
            "라면 4000", "라볶이 6000", "쫄면 6500", "차닭물쫄면 7000", "얼큰해물우동 7500", "얼음보리소바 7000", "떡라면 4500", "치즈라멘 4500", "치즈불닭쫄면 8000", "스팸옛날도시락 6500",
            "철판새웋함박 8500", "철판피즈김치볶음밥 8000", "스팸김치볶음밥 7000", "오믈렛라이스 7000", "빠에야새우볶음밥 7000", "해산볶음밥 7000", "오불덮밥 8000", "낚지덮밥 8000", "소불고기덮밥 7500",
            "돈커리덮밥 7500", "제육덮밥 8000", "알촉촉밥 7500", "비빔밥 6500", "뚝배기불고기 7500", "묵은지김치찌개 7000", "순두부찌개 7000", "1인부대찌개 8000", "차돌된장찌개 7000", "소고기육개장 7500",
            "등심돈까스 8000", "치즈돈까스 8500", "김치가츠동 7500", "간장돈불고기덮밥 7000", "치킨마요덮밥 6000", "1인치즈닭갈비 8000", "건강하닭죽 6800", "갈비만두 5000", "김치만두 5000", "쌀떡볶이 5000",
            "치즈떡볶이 6000", "왕새우튀김 1700", "야채튀김 2500", "the 맛있는오뎅 6000", "공기밥 1000", "홍콩식군만두 5500", "스페셜 모듬튀김 5500", "사이다 1500", "콜라 1500", "환타 1500")

        scrollLayout = findViewById(R.id.scrollLayout)

        for (i in dayArray.indices){
            var checkBox = CheckBox(this)
            checkBox.text = dayArray[i]
            scrollLayout.addView(checkBox)
        }
    }
}