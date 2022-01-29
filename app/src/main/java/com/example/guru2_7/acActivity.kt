package com.example.guru2_7

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class acActivity : AppCompatActivity() {

    lateinit var dbManager: acDBManager
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

        dbManager = acDBManager(this)
        sqlDB = dbManager.writableDatabase

        acCheckBox1 = findViewById(R.id.inCheckBox1)
        acCheckBox2 = findViewById(R.id.inCheckBox2)
        acCheckBox3 = findViewById(R.id.inCheckBox3)
        acCheckBox4 = findViewById(R.id.inCheckBox4)
        acCheckBox5 = findViewById(R.id.inCheckBox5)
        acCheckBox6 = findViewById(R.id.inCheckBox6)
        acCheckBox7 = findViewById(R.id.inCheckBox7)
        acCheckBox8 = findViewById(R.id.inCheckBox8)
        acCheckBox9 = findViewById(R.id.inCheckBox9)
        acCheckBox10 = findViewById(R.id.inCheckBox10)

//        okButton = findViewById<Button>(R.id.okButton)

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
                    R.id.inCheckBox1 ->  menu1 = acCheckBox1.text.toString()
                    R.id.inCheckBox2 ->  menu2 = acCheckBox2.text.toString()
                    R.id.inCheckBox3 ->  menu3 = acCheckBox3.text.toString()
                    R.id.inCheckBox4 ->  menu4 = acCheckBox4.text.toString()
                    R.id.inCheckBox5 ->  menu5 = acCheckBox5.text.toString()
                    R.id.inCheckBox6 ->  menu6 = acCheckBox6.text.toString()
                    R.id.inCheckBox7 ->  menu7 = acCheckBox7.text.toString()
                    R.id.inCheckBox8 ->  menu8 = acCheckBox8.text.toString()
                    R.id.inCheckBox9 ->  menu9 = acCheckBox9.text.toString()
                    R.id.inCheckBox10 ->  menu10 = acCheckBox10.text.toString()
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

//        okButton.setOnClickListener {
//            sqlDB = dbManager.writableDatabase
//            sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"','"+menu10 +"');")
//            val intent = Intent(this, Order1_Activity::class.java)
//            startActivity(intent)
//        }

        sqlDB.close()


    }
}