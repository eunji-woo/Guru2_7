package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton

class mongActivity : AppCompatActivity() {

    lateinit var dbManager: mongDBManager
    lateinit var sqlDB: SQLiteDatabase

    lateinit var mongCheckBox1: CheckBox
    lateinit var mongCheckBox2: CheckBox
    lateinit var mongCheckBox3: CheckBox
    lateinit var mongCheckBox4: CheckBox
    lateinit var mongCheckBox5: CheckBox
    lateinit var mongCheckBox6: CheckBox
    lateinit var mongCheckBox7: CheckBox
    lateinit var mongCheckBox8: CheckBox
    lateinit var mongCheckBox9: CheckBox
    lateinit var mongCheckBox10: CheckBox

    lateinit var okButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mong)

        dbManager = mongDBManager(this)
        sqlDB = dbManager.writableDatabase

        var pref = this.getSharedPreferences("user",0)
        var nickname = pref.getString("nickname", "default").toString()

        mongCheckBox1 = findViewById(R.id.mongCheckBox1) //5000
        mongCheckBox2 = findViewById(R.id.mongCheckBox2) //5500
        mongCheckBox3 = findViewById(R.id.mongCheckBox3) //6000
        mongCheckBox4 = findViewById(R.id.mongCheckBox4) //5500
        mongCheckBox5 = findViewById(R.id.mongCheckBox5) //5500
        mongCheckBox6 = findViewById(R.id.mongCheckBox6) //6000
        mongCheckBox7 = findViewById(R.id.mongCheckBox7) //3000
        mongCheckBox8 = findViewById(R.id.mongCheckBox8) //1000
        mongCheckBox9 = findViewById(R.id.mongCheckBox9) //1000
        mongCheckBox10 = findViewById(R.id.mongCheckBox10) //2000

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
        var price:Int = 0


//        sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu2+"','"+menu1+"','"+menu3 +"');")


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.mongCheckBox1 ->  {menu1 = mongCheckBox1.text.toString()
                        price += 5000}
                    R.id.mongCheckBox2 ->  {menu2 = mongCheckBox2.text.toString()
                        price += 5500}
                    R.id.mongCheckBox3 ->  {menu3 = mongCheckBox3.text.toString()
                        price += 6000}
                    R.id.mongCheckBox4 ->  {menu4 = mongCheckBox4.text.toString()
                        price += 5500}
                    R.id.mongCheckBox5 ->  {menu5 = mongCheckBox5.text.toString()
                        price += 5500}
                    R.id.mongCheckBox6 ->  {menu6 = mongCheckBox6.text.toString()
                        price += 6000}
                    R.id.mongCheckBox7 ->  {menu7 = mongCheckBox7.text.toString()
                        price += 3000}
                    R.id.mongCheckBox8 ->  {menu8 = mongCheckBox8.text.toString()
                        price += 1000}
                    R.id.mongCheckBox9 ->  {menu9 = mongCheckBox9.text.toString()
                        price += 1000}
                    R.id.mongCheckBox10 ->  {menu10 = mongCheckBox10.text.toString()
                        price += 2200}
                }
            }
            else { Log.d("test_eunji", "해제")}
        }

        mongCheckBox1.setOnCheckedChangeListener(listener)
        mongCheckBox2.setOnCheckedChangeListener(listener)
        mongCheckBox3.setOnCheckedChangeListener(listener)
        mongCheckBox4.setOnCheckedChangeListener(listener)
        mongCheckBox5.setOnCheckedChangeListener(listener)
        mongCheckBox6.setOnCheckedChangeListener(listener)
        mongCheckBox7.setOnCheckedChangeListener(listener)
        mongCheckBox8.setOnCheckedChangeListener(listener)
        mongCheckBox9.setOnCheckedChangeListener(listener)
        mongCheckBox10.setOnCheckedChangeListener(listener)

        okButton.setOnClickListener {
            sqlDB = dbManager.writableDatabase
            sqlDB.execSQL("INSERT INTO mongTBL VALUES ('"+nickname+"', '"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"', '"+menu10 +"', '"+price+"');")
            val intent = Intent(this, Order1_Activity::class.java)
            intent.putExtra("shop_name", "mong")
            startActivity(intent)
        }

        sqlDB.close()


    }
}