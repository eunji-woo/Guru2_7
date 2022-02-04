package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import android.os.Build.VERSION_CODES
import android.os.Build.VERSION_CODES.*
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

var ac_count = 0
var place_ac = ""
var time_ac = ""

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


    @RequiresApi(O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac)

        dbManager = acDBManager(this)
        sqlDB = dbManager.writableDatabase

        val spinner_acp = findViewById<Spinner>(R.id.spinner_acp)
        val spinner_act = findViewById<Spinner>(R.id.spinner_act)

        var pref = this.getSharedPreferences("user",0)
        var nickname = pref.getString("nickname", "default").toString()

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
        var price: Int = 0

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        val start = current.format(formatter)



        var cursor = sqlDB.rawQuery("SELECT * FROM acTBL", null)
        if(cursor.moveToNext()==false){
            spinner_act.visibility = View.VISIBLE
            spinner_acp.visibility = View.VISIBLE
        }
        else{
            spinner_act.visibility = View.GONE
            spinner_acp.visibility = View.GONE
        }


        val place = resources.getStringArray(R.array.place_array)
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_acp.adapter = Adapter_place
        spinner_acp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_ac = place[position]
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
        spinner_act.adapter = Adapter_time
        spinner_act.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_ac = time[position]
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


//        sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu2+"','"+menu1+"','"+menu3 +"');")


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.inCheckBox1 ->  {menu1 = acCheckBox1.text.toString()
                        price += 4600}
                    R.id.inCheckBox2 ->  {menu2 = acCheckBox2.text.toString()
                        price += 5200}
                    R.id.inCheckBox3 ->  {menu3 = acCheckBox3.text.toString()
                        price += 5500}
                    R.id.inCheckBox4 ->  {menu4 = acCheckBox4.text.toString()
                        price += 6300}
                    R.id.inCheckBox5 ->  {menu5 = acCheckBox5.text.toString()
                        price += 6500}
                    R.id.inCheckBox6 ->  {menu6 = acCheckBox6.text.toString()
                        price += 6000}
                    R.id.inCheckBox7 ->  {menu7 = acCheckBox7.text.toString()
                        price += 5800}
                    R.id.inCheckBox8 ->  {menu8 = acCheckBox8.text.toString()
                        price += 6000}
                    R.id.inCheckBox9 ->  {menu9 = acCheckBox9.text.toString()
                        price += 1500}
                    R.id.inCheckBox10 ->  {menu10 = acCheckBox10.text.toString()
                        price += 1500}
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

            if (menu1 == "" && menu2 == "" && menu3 == "" && menu4 == "" && menu5 == "" && menu6 == "" && menu7 == "" && menu8 == "" && menu9 == "" && menu10 == ""){
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()

            }
            else {
                ac_count += 1
                sqlDB = dbManager.writableDatabase
                sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+nickname+"', '"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"', '"+menu10 +"', '"+price+"', '"+place_ac+"', '"+time_ac+"', '"+start+"');")
                val intent = Intent(this, Order1_Activity::class.java)
                intent.putExtra("shop_name", "ac")
                intent.putExtra("navi", "1")
                startActivity(intent)
            }
        }

        sqlDB.close()

    }
}