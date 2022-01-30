package com.example.guru2_7

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class kimActivity : AppCompatActivity() {

    lateinit var dbManager: kimDBManager
    lateinit var sqlDB: SQLiteDatabase

    lateinit var kimCheckBox1: CheckBox
    lateinit var kimCheckBox2: CheckBox
    lateinit var kimCheckBox3: CheckBox
    lateinit var kimCheckBox4: CheckBox
    lateinit var kimCheckBox5: CheckBox
    lateinit var kimCheckBox6: CheckBox
    lateinit var kimCheckBox7: CheckBox
    lateinit var kimCheckBox8: CheckBox
    lateinit var kimCheckBox9: CheckBox
    lateinit var kimCheckBox10: CheckBox

    lateinit var okButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kim)

        dbManager = kimDBManager(this)
        sqlDB = dbManager.writableDatabase

        kimCheckBox1 = findViewById(R.id.kimCheckBox1) //3800
        kimCheckBox2 = findViewById(R.id.kimCheckBox2) //4800
        kimCheckBox3 = findViewById(R.id.kimCheckBox3) //4800
        kimCheckBox4 = findViewById(R.id.kimCheckBox4) //6000
        kimCheckBox5 = findViewById(R.id.kimCheckBox5) //7500
        kimCheckBox6 = findViewById(R.id.kimCheckBox6) //7000
        kimCheckBox7 = findViewById(R.id.kimCheckBox7) //7000
        kimCheckBox8 = findViewById(R.id.kimCheckBox8) //6000
        kimCheckBox9 = findViewById(R.id.kimCheckBox9) //6000
        kimCheckBox10 = findViewById(R.id.kimCheckBox10) //8500

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
                    R.id.kimCheckBox1 ->  menu1 = kimCheckBox1.text.toString()
                    R.id.kimCheckBox2 ->  menu2 = kimCheckBox2.text.toString()
                    R.id.kimCheckBox3 ->  menu3 = kimCheckBox3.text.toString()
                    R.id.kimCheckBox4 ->  menu4 = kimCheckBox4.text.toString()
                    R.id.kimCheckBox5 ->  menu5 = kimCheckBox5.text.toString()
                    R.id.kimCheckBox6 ->  menu6 = kimCheckBox6.text.toString()
                    R.id.kimCheckBox7 ->  menu7 = kimCheckBox7.text.toString()
                    R.id.kimCheckBox8 ->  menu8 = kimCheckBox8.text.toString()
                    R.id.kimCheckBox9 ->  menu9 = kimCheckBox9.text.toString()
                    R.id.kimCheckBox10 ->  menu10 = kimCheckBox10.text.toString()
                }
            }
            else { Log.d("test_eunji", "해제")}
        }

        kimCheckBox1.setOnCheckedChangeListener(listener)
        kimCheckBox2.setOnCheckedChangeListener(listener)
        kimCheckBox3.setOnCheckedChangeListener(listener)
        kimCheckBox4.setOnCheckedChangeListener(listener)
        kimCheckBox5.setOnCheckedChangeListener(listener)
        kimCheckBox6.setOnCheckedChangeListener(listener)
        kimCheckBox7.setOnCheckedChangeListener(listener)
        kimCheckBox8.setOnCheckedChangeListener(listener)
        kimCheckBox9.setOnCheckedChangeListener(listener)
        kimCheckBox10.setOnCheckedChangeListener(listener)

//        okButton.setOnClickListener {
//            sqlDB = dbManager.writableDatabase
//            sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"','"+menu10 +"');")
//            val intent = Intent(this, Order1_Activity::class.java)
//            startActivity(intent)
//        }

        sqlDB.close()


    }
}