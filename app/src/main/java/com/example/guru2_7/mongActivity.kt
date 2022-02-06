package com.example.guru2_7

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

var mong_count = 0
var place_mong = ""
var time_mong = ""

class mongActivity : AppCompatActivity() {

    lateinit var dbManager: mongDBManager // db 사용을 위한 db 매니저 미리 선언
    lateinit var sqlDB: SQLiteDatabase

    lateinit var mongCheckBox1: CheckBox // xml에 있는 체크박스 연결을 위해 선언
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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mong)

        dbManager = mongDBManager(this)
        sqlDB = dbManager.writableDatabase //db메니저를 통해 db 열기

        val spinner_mongp = findViewById<Spinner>(R.id.spinner_mongp)
        val spinner_mongt = findViewById<Spinner>(R.id.spinner_mongt)
        var pref = this.getSharedPreferences("user",0) // 로그인할때 입력된 닉네임 공유자원 통해서 받아오기
        var nickname = pref.getString("nickname", "default").toString()

        mongCheckBox1 = findViewById(R.id.mongCheckBox1) // 각 가게별 xml에 있는 체크박스 연결
        mongCheckBox2 = findViewById(R.id.mongCheckBox2)
        mongCheckBox3 = findViewById(R.id.mongCheckBox3)
        mongCheckBox4 = findViewById(R.id.mongCheckBox4)
        mongCheckBox5 = findViewById(R.id.mongCheckBox5)
        mongCheckBox6 = findViewById(R.id.mongCheckBox6)
        mongCheckBox7 = findViewById(R.id.mongCheckBox7)
        mongCheckBox8 = findViewById(R.id.mongCheckBox8)
        mongCheckBox9 = findViewById(R.id.mongCheckBox9)
        mongCheckBox10 = findViewById(R.id.mongCheckBox10)

        okButton = findViewById<Button>(R.id.okButton)

        var menu1:String = "" // 각 메뉴 선택되었을 시 메뉴 이름 저장하기 위한 변수
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

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        val start = current.format(formatter) // 메뉴 주문할때의 시간 저장

        var cursor = sqlDB.rawQuery("SELECT * FROM mongTBL", null)
        if(cursor.moveToNext()==false){ // 처음 주문자에게만 시간, 장소 선택할 수 있는 스피너 보이도록 설정
            spinner_mongt.visibility = View.VISIBLE
            spinner_mongp.visibility = View.VISIBLE
        }
        else{
            spinner_mongt.visibility = View.GONE
            spinner_mongp.visibility = View.GONE
        }


        val place = resources.getStringArray(R.array.place_array) // 스피너를 통해 입력받은 정보 저장
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_mongp.adapter = Adapter_place
        spinner_mongp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_mong = place[position] // 스피너를 통해 입력받은 정보 전역변수에 저장

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_mongt.adapter = Adapter_time
        spinner_mongt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_mong = time[position] // 스피너를 통해 입력받은 정보 전역변수에 저장
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){ // 메뉴선택 페이지에서 메뉴 선택되었을때 menu 변수에 메뉴 이름 저장
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
            else {Toast.makeText(this, "선택 취소.", Toast.LENGTH_SHORT).show()}
        }

        mongCheckBox1.setOnCheckedChangeListener(listener) // 리스너와 체크박스 연결
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

            if (menu1 == "" && menu2 == "" && menu3 == "" && menu4 == "" && menu5 == "" && menu6 == "" && menu7 == "" && menu8 == "" && menu9 == "" && menu10 == ""){
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()
                // 메뉴 한개라도 선택되지 않으면 okbutton 누를 수 없도록 처리
            }
            else { // 메뉴가 한개라도 선택될 경우 db에 선택된 메뉴와 닉네임, 가격, 시간, 장소 저장 후 intent + 주문현황 개수 증가
                mong_count += 1
                sqlDB = dbManager.writableDatabase
                sqlDB.execSQL("INSERT INTO mongTBL VALUES ('" + nickname + "', '" + menu1 + "', '" + menu2 + "', '" + menu3 + "', '" + menu4 + "', '" + menu5 + "', '" + menu6 + "', '" + menu7 + "', '" + menu8 + "', '" + menu9 + "', '" + menu10 + "', '" + price + "', '" + place_mong + "', '" + time_mong + "', '" + start + "');")
                val intent = Intent(this, Order1_Activity::class.java)
                intent.putExtra("shop_name", "mong")
                startActivity(intent)
            }
        }

        sqlDB.close()


    }
}