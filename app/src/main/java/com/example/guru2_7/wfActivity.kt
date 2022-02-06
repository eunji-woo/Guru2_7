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

var wf_count = 0
var place_wf = ""
var time_wf = ""

class wfActivity : AppCompatActivity() {

    lateinit var dbManager: wfDBManager // db 사용을 위한 db 매니저 미리 선언
    lateinit var sqlDB: SQLiteDatabase

    lateinit var wfCheckBox1: CheckBox // xml에 있는 체크박스 연결을 위해 선언
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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wf)

        dbManager = wfDBManager(this)
        sqlDB = dbManager.writableDatabase //db메니저를 통해 db 열기

        val spinner_wfp = findViewById<Spinner>(R.id.spinner_wfp)
        val spinner_wft = findViewById<Spinner>(R.id.spinner_wft)
        var pref = this.getSharedPreferences("user",0) // 로그인할때 입력된 닉네임 공유자원 통해서 받아오기
        var nickname = pref.getString("nickname", "default").toString()

        wfCheckBox1 = findViewById(R.id.wfCheckBox1) // 각 가게별 xml에 있는 체크박스 연결
        wfCheckBox2 = findViewById(R.id.wfCheckBox2)
        wfCheckBox3 = findViewById(R.id.wfCheckBox3)
        wfCheckBox4 = findViewById(R.id.wfCheckBox4)
        wfCheckBox5 = findViewById(R.id.wfCheckBox5)
        wfCheckBox6 = findViewById(R.id.wfCheckBox6)
        wfCheckBox7 = findViewById(R.id.wfCheckBox7)
        wfCheckBox8 = findViewById(R.id.wfCheckBox8)
        wfCheckBox9 = findViewById(R.id.wfCheckBox9)
        wfCheckBox10 = findViewById(R.id.wfCheckBox10)

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


        var cursor = sqlDB.rawQuery("SELECT * FROM wfTBL", null)
        if(cursor.moveToNext()==false){ // 처음 주문자에게만 시간, 장소 선택할 수 있는 스피너 보이도록 설정
            spinner_wft.visibility = View.VISIBLE
            spinner_wfp.visibility = View.VISIBLE
        }
        else{
            spinner_wft.visibility = View.GONE
            spinner_wfp.visibility = View.GONE
        }

        val place = resources.getStringArray(R.array.place_array) // 스피너를 통해 입력받은 정보 저장
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_wfp.adapter = Adapter_place
        spinner_wfp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_wf = place[position] // 스피너를 통해 입력받은 정보 전역변수에 저장

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_wft.adapter = Adapter_time
        spinner_wft.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_wf = time[position] // 스피너를 통해 입력받은 정보 전역변수에 저장
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }




        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){ // 메뉴선택 페이지에서 메뉴 선택되었을때 menu 변수에 메뉴 이름 저장
                    R.id.wfCheckBox1 ->  {menu1 = wfCheckBox1.text.toString() //3200
                        price += 3200}
                    R.id.wfCheckBox2 ->  {menu2 = wfCheckBox2.text.toString() //4200
                        price += 4200}
                    R.id.wfCheckBox3 ->  {menu3 = wfCheckBox3.text.toString() //4000
                        price += 4000}
                    R.id.wfCheckBox4 ->  {menu4 = wfCheckBox4.text.toString() //5700
                        price += 5700}
                    R.id.wfCheckBox5 ->  {menu5 = wfCheckBox5.text.toString() //5500
                        price += 5500}
                    R.id.wfCheckBox6 ->  {menu6 = wfCheckBox6.text.toString() //4000
                        price += 4000}
                    R.id.wfCheckBox7 ->  {menu7 = wfCheckBox7.text.toString() //4000
                        price += 4000}
                    R.id.wfCheckBox8 ->  {menu8 = wfCheckBox8.text.toString() //3000
                        price += 3000}
                    R.id.wfCheckBox9 ->  {menu9 = wfCheckBox9.text.toString() //3800
                        price += 3800}
                    R.id.wfCheckBox10 ->  {menu10 = wfCheckBox10.text.toString() //4000
                        price += 4000}
                }
            }
            else {Toast.makeText(this, "선택 취소.", Toast.LENGTH_SHORT).show()}
        }

        wfCheckBox1.setOnCheckedChangeListener(listener) // 리스너와 체크박스 연결
        wfCheckBox2.setOnCheckedChangeListener(listener)
        wfCheckBox3.setOnCheckedChangeListener(listener)
        wfCheckBox4.setOnCheckedChangeListener(listener)
        wfCheckBox5.setOnCheckedChangeListener(listener)
        wfCheckBox6.setOnCheckedChangeListener(listener)
        wfCheckBox7.setOnCheckedChangeListener(listener)
        wfCheckBox8.setOnCheckedChangeListener(listener)
        wfCheckBox9.setOnCheckedChangeListener(listener)
        wfCheckBox10.setOnCheckedChangeListener(listener)

        okButton.setOnClickListener {
            if (menu1 == "" && menu2 == "" && menu3 == "" && menu4 == "" && menu5 == "" && menu6 == "" && menu7 == "" && menu8 == "" && menu9 == "" && menu10 == ""){
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()
                // 메뉴 한개라도 선택되지 않으면 okbutton 누를 수 없도록 처리
            }
            else { // 메뉴가 한개라도 선택될 경우 db에 선택된 메뉴와 닉네임, 가격, 시간, 장소 저장 후 intent + 주문현황 개수 증가
                wf_count += 1
                sqlDB = dbManager.writableDatabase
                sqlDB.execSQL("INSERT INTO wfTBL VALUES ('" + nickname + "', '" + menu1 + "', '" + menu2 + "', '" + menu3 + "', '" + menu4 + "', '" + menu5 + "', '" + menu6 + "', '" + menu7 + "', '" + menu8 + "', '" + menu9 + "', '" + menu10 + "', '" + price + "', '" + place_wf + "', '" + time_wf + "', '" + start + "');")
                val intent = Intent(this, Order1_Activity::class.java)
                intent.putExtra("shop_name", "wf")
                startActivity(intent)
            }
        }

        sqlDB.close()


    }
}