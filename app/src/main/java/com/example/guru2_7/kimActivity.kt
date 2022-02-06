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

var kim_count = 0
var place_kim = ""
var time_kim = ""

class kimActivity : AppCompatActivity() {

    lateinit var dbManager: kimDBManager // db 사용을 위한 db 매니저 미리 선언
    lateinit var sqlDB: SQLiteDatabase

    lateinit var kimCheckBox1: CheckBox // xml에 있는 체크박스 연결을 위해 선언
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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kim)

        dbManager = kimDBManager(this)
        sqlDB = dbManager.writableDatabase //db메니저를 통해 db 열기

        val spinner_kimp = findViewById<Spinner>(R.id.spinner_kimp)
        val spinner_kimt = findViewById<Spinner>(R.id.spinner_kimt)
        var pref = this.getSharedPreferences("user",0) // 로그인할때 입력된 닉네임 공유자원 통해서 받아오기
        var nickname = pref.getString("nickname", "default").toString()

        kimCheckBox1 = findViewById(R.id.kimCheckBox1) // 각 가게별 xml에 있는 체크박스 연결
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
        var price: Int = 0

        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("h:mm a")
        val start = current.format(formatter) // 메뉴 주문할때의 시간 저장

        var cursor = sqlDB.rawQuery("SELECT * FROM kimTBL", null)
        if(cursor.moveToNext()==false){ // 처음 주문자에게만 시간, 장소 선택할 수 있는 스피너 보이도록 설정
            spinner_kimt.visibility = View.VISIBLE
            spinner_kimp.visibility = View.VISIBLE
        }
        else{
            spinner_kimt.visibility = View.GONE
            spinner_kimp.visibility = View.GONE
        }


        val place = resources.getStringArray(R.array.place_array) // 스피너를 통해 입력받은 정보 저장
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_kimp.adapter = Adapter_place
        spinner_kimp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_kim = place[position] // 스피너를 통해 입력받은 정보 전역변수에 저장

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_kimt.adapter = Adapter_time
        spinner_kimt.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_kim = time[position] // 스피너를 통해 입력받은 정보 전역변수에 저장
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){ // 메뉴선택 페이지에서 메뉴 선택되었을때 menu 변수에 메뉴 이름 저장
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
            else {Toast.makeText(this, "선택 취소.", Toast.LENGTH_SHORT).show()}
        }

        kimCheckBox1.setOnCheckedChangeListener(listener) // 리스너와 체크박스 연결
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
            if (menu1 == "" && menu2 == "" && menu3 == "" && menu4 == "" && menu5 == "" && menu6 == "" && menu7 == "" && menu8 == "" && menu9 == "" && menu10 == ""){
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()
                // 메뉴 한개라도 선택되지 않으면 okbutton 누를 수 없도록 처리
            }
            else { // 메뉴가 한개라도 선택될 경우 db에 선택된 메뉴와 닉네임, 가격, 시간, 장소 저장 후 intent + 주문현황 개수 증가
                kim_count += 1
                sqlDB = dbManager.writableDatabase
                sqlDB.execSQL("INSERT INTO kimTBL VALUES ('" + nickname + "', '" + menu1 + "', '" + menu2 + "', '" + menu3 + "', '" + menu4 + "', '" + menu5 + "', '" + menu6 + "', '" + menu7 + "', '" + menu8 + "', '" + menu9 + "', '" + menu10 + "', '" + price + "', '" + place_kim + "', '" + time_kim + "', '" + start + "');")
                val intent = Intent(this, Order1_Activity::class.java)
                intent.putExtra("shop_name", "kim")
                startActivity(intent)
            }
        }

        sqlDB.close()
    }
}