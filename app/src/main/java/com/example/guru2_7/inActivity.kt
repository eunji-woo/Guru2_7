package com.example.guru2_7

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class inActivity : AppCompatActivity() {

    lateinit var dbManager: inDBManager
    lateinit var sqlDB: SQLiteDatabase

    lateinit var inCheckBox1: CheckBox
    lateinit var inCheckBox2: CheckBox
    lateinit var inCheckBox3: CheckBox
    lateinit var inCheckBox4: CheckBox
    lateinit var inCheckBox5: CheckBox
    lateinit var inCheckBox6: CheckBox
    lateinit var inCheckBox7: CheckBox
    lateinit var inCheckBox8: CheckBox
    lateinit var inCheckBox9: CheckBox
    lateinit var inCheckBox10: CheckBox

    lateinit var okButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in)

        dbManager = inDBManager(this)
        sqlDB = dbManager.writableDatabase

        inCheckBox1 = findViewById(R.id.acCheckBox1) //4500
        inCheckBox2 = findViewById(R.id.acCheckBox2) //9500
        inCheckBox3 = findViewById(R.id.acCheckBox3) //4000
        inCheckBox4 = findViewById(R.id.acCheckBox4) //9000
        inCheckBox5 = findViewById(R.id.acCheckBox5) //500
        inCheckBox6 = findViewById(R.id.acCheckBox6) //4000
        inCheckBox7 = findViewById(R.id.acCheckBox7) //4000
        inCheckBox8 = findViewById(R.id.acCheckBox8) //2500
        inCheckBox9 = findViewById(R.id.acCheckBox9) //2000
        inCheckBox10 = findViewById(R.id.acCheckBox10) //1500

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
                    R.id.acCheckBox1 ->  menu1 = inCheckBox1.text.toString()
                    R.id.acCheckBox2 ->  menu2 = inCheckBox2.text.toString()
                    R.id.acCheckBox3 ->  menu3 = inCheckBox3.text.toString()
                    R.id.acCheckBox4 ->  menu4 = inCheckBox4.text.toString()
                    R.id.acCheckBox5 ->  menu5 = inCheckBox5.text.toString()
                    R.id.acCheckBox6 ->  menu6 = inCheckBox6.text.toString()
                    R.id.acCheckBox7 ->  menu7 = inCheckBox7.text.toString()
                    R.id.acCheckBox8 ->  menu8 = inCheckBox8.text.toString()
                    R.id.acCheckBox9 ->  menu9 = inCheckBox9.text.toString()
                    R.id.acCheckBox10 ->  menu10 = inCheckBox10.text.toString()
                }
            }
            else { Log.d("test_eunji", "해제")}
        }

        inCheckBox1.setOnCheckedChangeListener(listener)
        inCheckBox2.setOnCheckedChangeListener(listener)
        inCheckBox3.setOnCheckedChangeListener(listener)
        inCheckBox4.setOnCheckedChangeListener(listener)
        inCheckBox5.setOnCheckedChangeListener(listener)
        inCheckBox6.setOnCheckedChangeListener(listener)
        inCheckBox7.setOnCheckedChangeListener(listener)
        inCheckBox8.setOnCheckedChangeListener(listener)
        inCheckBox9.setOnCheckedChangeListener(listener)
        inCheckBox10.setOnCheckedChangeListener(listener)

//        okButton.setOnClickListener {
//            sqlDB = dbManager.writableDatabase
//            sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"','"+menu10 +"');")
//            val intent = Intent(this, Order1_Activity::class.java)
//            startActivity(intent)
//        }

        sqlDB.close()


    }
}