package com.example.guru2_7

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class wfActivity : AppCompatActivity() {

    lateinit var dbManager: wfDBManager
    lateinit var sqlDB: SQLiteDatabase

    lateinit var wfCheckBox1: CheckBox
    lateinit var wfCheckBox2: CheckBox
    lateinit var wfCheckBox3: CheckBox
    lateinit var wfCheckBox4: CheckBox
    lateinit var wfCheckBox5: CheckBox
    lateinit var wfCheckBox6: CheckBox
    lateinit var wfCheckBox7: CheckBox
    lateinit var wfCheckBox8: CheckBox
    lateinit var wfCheckBox9: CheckBox
    lateinit var wfCheckBox10: CheckBox

    lateinit var okButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wf)

        dbManager = wfDBManager(this)
        sqlDB = dbManager.writableDatabase

        wfCheckBox1 = findViewById(R.id.wfCheckBox1)
        wfCheckBox2 = findViewById(R.id.wfCheckBox2)
        wfCheckBox3 = findViewById(R.id.wfCheckBox3)
        wfCheckBox4 = findViewById(R.id.wfCheckBox4)
        wfCheckBox5 = findViewById(R.id.wfCheckBox5)
        wfCheckBox6 = findViewById(R.id.wfCheckBox6)
        wfCheckBox7 = findViewById(R.id.wfCheckBox7)
        wfCheckBox8 = findViewById(R.id.wfCheckBox8)
        wfCheckBox9 = findViewById(R.id.wfCheckBox9)
        wfCheckBox10 = findViewById(R.id.wfCheckBox10)

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
        var price:Int = 0


//        sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu2+"','"+menu1+"','"+menu3 +"');")


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.kimCheckBox1 ->  {menu1 = wfCheckBox1.text.toString() //3200
                        price += 3200}
                    R.id.kimCheckBox2 ->  {menu2 = wfCheckBox2.text.toString() //4200
                        price += 4200}
                    R.id.kimCheckBox3 ->  {menu3 = wfCheckBox3.text.toString() //4000
                        price += 4000}
                    R.id.kimCheckBox4 ->  {menu4 = wfCheckBox4.text.toString() //5700
                        price += 5700}
                    R.id.kimCheckBox5 ->  {menu5 = wfCheckBox5.text.toString() //5500
                        price += 5500}
                    R.id.kimCheckBox6 ->  {menu6 = wfCheckBox6.text.toString() //4000
                        price += 4000}
                    R.id.kimCheckBox7 ->  {menu7 = wfCheckBox7.text.toString() //4000
                        price += 4000}
                    R.id.kimCheckBox8 ->  {menu8 = wfCheckBox8.text.toString() //3000
                        price += 3000}
                    R.id.kimCheckBox9 ->  {menu9 = wfCheckBox9.text.toString() //3800
                        price += 3800}
                    R.id.kimCheckBox10 ->  {menu10 = wfCheckBox10.text.toString() //4000
                        price += 4000}
                }
            }
            else { Log.d("test_eunji", "해제")}
        }

        wfCheckBox1.setOnCheckedChangeListener(listener)
        wfCheckBox2.setOnCheckedChangeListener(listener)
        wfCheckBox3.setOnCheckedChangeListener(listener)
        wfCheckBox4.setOnCheckedChangeListener(listener)
        wfCheckBox5.setOnCheckedChangeListener(listener)
        wfCheckBox6.setOnCheckedChangeListener(listener)
        wfCheckBox7.setOnCheckedChangeListener(listener)
        wfCheckBox8.setOnCheckedChangeListener(listener)
        wfCheckBox9.setOnCheckedChangeListener(listener)
        wfCheckBox10.setOnCheckedChangeListener(listener)

//        okButton.setOnClickListener {
//            sqlDB = dbManager.writableDatabase
//            sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"','"+menu10 +"');")
//            val intent = Intent(this, Order1_Activity::class.java)
//            startActivity(intent)
//        }

        sqlDB.close()


    }
}