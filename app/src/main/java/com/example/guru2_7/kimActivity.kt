package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*

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

        val spinner_kimp = findViewById<Spinner>(R.id.spinner_kimp)
        val spinner_kimt = findViewById<Spinner>(R.id.spinner_kimt)
        var pref = this.getSharedPreferences("user",0)
        var nickname = pref.getString("nickname", "default").toString()

        kimCheckBox1 = findViewById(R.id.kimCheckBox1)
        kimCheckBox2 = findViewById(R.id.kimCheckBox2)
        kimCheckBox3 = findViewById(R.id.kimCheckBox3)
        kimCheckBox4 = findViewById(R.id.kimCheckBox4)
        kimCheckBox5 = findViewById(R.id.kimCheckBox5)
        kimCheckBox6 = findViewById(R.id.kimCheckBox6)
        kimCheckBox7 = findViewById(R.id.kimCheckBox7)
        kimCheckBox8 = findViewById(R.id.kimCheckBox8)
        kimCheckBox9 = findViewById(R.id.kimCheckBox9)
        kimCheckBox10 = findViewById(R.id.kimCheckBox10)

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

        var place_kim:String = ""
        var time_kim:String = ""
        val place = resources.getStringArray(R.array.place_array)
        val time = resources.getStringArray(R.array.time_array)
        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_kimp.adapter = Adapter_place
        spinner_kimp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_kim = place[position]

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_kimt.adapter = Adapter_time
        spinner_kimt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_kim = time[position]
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


//        sqlDB.execSQL("INSERT INTO acTBL VALUES ('"+menu2+"','"+menu1+"','"+menu3 +"');")


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){
                    R.id.kimCheckBox1 ->  {menu1 = kimCheckBox1.text.toString()
                        price += 3800}
                    R.id.kimCheckBox2 ->  {menu2 = kimCheckBox2.text.toString()
                        price += 4800}
                    R.id.kimCheckBox3 ->  {menu3 = kimCheckBox3.text.toString()
                        price += 4800}
                    R.id.kimCheckBox4 ->  {menu4 = kimCheckBox4.text.toString()
                        price += 6000}
                    R.id.kimCheckBox5 ->  {menu5 = kimCheckBox5.text.toString()
                        price += 7500}
                    R.id.kimCheckBox6 ->  {menu6 = kimCheckBox6.text.toString()
                        price += 7000}
                    R.id.kimCheckBox7 ->  {menu7 = kimCheckBox7.text.toString()
                        price += 7000}
                    R.id.kimCheckBox8 ->  {menu8 = kimCheckBox8.text.toString()
                        price += 6000}
                    R.id.kimCheckBox9 ->  {menu9 = kimCheckBox9.text.toString()
                        price += 6000}
                    R.id.kimCheckBox10 ->  {menu10 = kimCheckBox10.text.toString()
                        price += 8500}
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

        okButton.setOnClickListener {
            sqlDB = dbManager.writableDatabase
            sqlDB.execSQL("INSERT INTO kimTBL VALUES ('"+nickname+"', '"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"', '"+menu10 +"', '"+price+"', '"+place_kim+"', '"+time_kim+"');")
            val intent = Intent(this, Order1_Activity::class.java)
            intent.putExtra("shop_name", "kim")
            startActivity(intent)
        }

        sqlDB.close()


    }
}