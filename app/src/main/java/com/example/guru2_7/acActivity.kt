package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class acActivity : AppCompatActivity() {

    lateinit var dbManager: DBManager2
    lateinit var sqlDB: SQLiteDatabase

    lateinit var acCheckBox1: CheckBox
    lateinit var acCheckBox2: CheckBox
    lateinit var acCheckBox3: CheckBox
    lateinit var acCheckBox4: CheckBox
    lateinit var acCheckBox5: CheckBox
    lateinit var acCheckBox6: CheckBox
    lateinit var acCheckBox7: CheckBox
    lateinit var acCheckBox8: CheckBox
    lateinit var acCheckBox9: CheckBox
    lateinit var acCheckBox10: CheckBox

    lateinit var okButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac)

        dbManager = DBManager2(this)
        sqlDB = dbManager.writableDatabase

        acCheckBox1 = findViewById(R.id.acCheckBox1)
        acCheckBox2 = findViewById(R.id.acCheckBox2)
        acCheckBox3 = findViewById(R.id.acCheckBox3)
        acCheckBox4 = findViewById(R.id.acCheckBox4)
        acCheckBox5 = findViewById(R.id.acCheckBox5)
        acCheckBox6 = findViewById(R.id.acCheckBox6)
        acCheckBox7 = findViewById(R.id.acCheckBox7)
        acCheckBox8 = findViewById(R.id.acCheckBox8)
        acCheckBox9 = findViewById(R.id.acCheckBox9)
        acCheckBox10 = findViewById(R.id.acCheckBox10)

        okButton = findViewById<Button>(R.id.okButton)

        var menu1:String = ""
        var menu2:String = ""
        var menu3:String = ""
        var menu4:String = ""
        var menu5:String = ""
        var menu6:String = ""
        var menu7:String = ""
        var menu8:String = ""
        var menu9:String = ""
        var menu10:String = ""


//        sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu2+"','"+menu1+"','"+menu3 +"');")


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.acCheckBox1 ->  menu1 = "메뉴1"
                    R.id.acCheckBox2 ->  menu2 = "메뉴2"
                    R.id.acCheckBox3 ->  menu3 = "메뉴3"
                    R.id.acCheckBox4 ->  menu4 = "메뉴4"
                    R.id.acCheckBox5 ->  menu5 = "메뉴5"
                    R.id.acCheckBox6 ->  menu6 = "메뉴6"
                    R.id.acCheckBox7 ->  menu7 = "메뉴7"
                    R.id.acCheckBox8 ->  menu8 = "메뉴8"
                    R.id.acCheckBox9 ->  menu9 = "메뉴9"
                    R.id.acCheckBox10 ->  menu10 = "메뉴10"
                }
            }
            else { Log.d("test_eunji", "해제")}
        }

        acCheckBox1.setOnCheckedChangeListener(listener)
        acCheckBox2.setOnCheckedChangeListener(listener)
        acCheckBox3.setOnCheckedChangeListener(listener)
        acCheckBox4.setOnCheckedChangeListener(listener)
        acCheckBox5.setOnCheckedChangeListener(listener)
        acCheckBox6.setOnCheckedChangeListener(listener)
        acCheckBox7.setOnCheckedChangeListener(listener)
        acCheckBox8.setOnCheckedChangeListener(listener)
        acCheckBox9.setOnCheckedChangeListener(listener)
        acCheckBox10.setOnCheckedChangeListener(listener)

        okButton.setOnClickListener {
            sqlDB = dbManager.writableDatabase
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"','"+menu10 +"');")
            val intent = Intent(this, Order1_Activity::class.java)
            startActivity(intent)
        }

        sqlDB.close()


    }
}