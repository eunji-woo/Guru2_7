package com.example.guru2_7

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResultActivity : AppCompatActivity() {
    lateinit var Homebutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var shop_name = intent.getStringExtra("shop_name")

        Homebutton=findViewById(R.id.Homebutton)

        Homebutton.setOnClickListener{

            if(shop_name == "ac") { acResult = 0 }
            else if(shop_name == "in") { inResult = 0 }
            else if(shop_name == "kim") { kimResult = 0 }
            else if(shop_name == "mong") { mongResult = 0 }
            else { wfResult = 0 }

            val intent = Intent(this, NaviActivity::class.java)
            startActivity(intent)
        }
    }
}