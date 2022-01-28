package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Order1_Activity : AppCompatActivity() {
    lateinit var OrderOkButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order1_)

        OrderOkButton = findViewById(R.id.OrderOkButton)

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