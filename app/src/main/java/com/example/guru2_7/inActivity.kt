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

var in_count = 0
var place_in = ""
var time_in = ""

class inActivity : AppCompatActivity() {

    lateinit var dbManager: inDBManager // db 사용을 위한 db 매니저 미리 선언
    lateinit var sqlDB: SQLiteDatabase

    lateinit var inCheckBox1: CheckBox // xml에 있는 체크박스 연결을 위해 선언
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


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in)

        dbManager = inDBManager(this)
        sqlDB = dbManager.writableDatabase //db메니저를 통해 db 열기

        val spinner_inp = findViewById<Spinner>(R.id.spinner_inp)
        val spinner_int = findViewById<Spinner>(R.id.spinner_int)
        var pref = this.getSharedPreferences("user",0) // 로그인할때 입력된 닉네임 공유자원 통해서 받아오기
        var nickname = pref.getString("nickname", "default").toString()

        inCheckBox1 = findViewById(R.id.inCheckBox1) // 각 가게별 xml에 있는 체크박스 연결
        inCheckBox2 = findViewById(R.id.inCheckBox2)
        inCheckBox3 = findViewById(R.id.inCheckBox3)
        inCheckBox4 = findViewById(R.id.inCheckBox4)
        inCheckBox5 = findViewById(R.id.inCheckBox5)
        inCheckBox6 = findViewById(R.id.inCheckBox6)
        inCheckBox7 = findViewById(R.id.inCheckBox7)
        inCheckBox8 = findViewById(R.id.inCheckBox8)
        inCheckBox9 = findViewById(R.id.inCheckBox9)
        inCheckBox10 = findViewById(R.id.inCheckBox10)

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


        var cursor = sqlDB.rawQuery("SELECT * FROM inTBL", null)
        if(cursor.moveToNext()==false){ // 처음 주문자에게만 시간, 장소 선택할 수 있는 스피너 보이도록 설정
            spinner_int.visibility = View.VISIBLE
            spinner_inp.visibility = View.VISIBLE
        }
        else{
            spinner_int.visibility = View.GONE
            spinner_inp.visibility = View.GONE
        }


        val place = resources.getStringArray(R.array.place_array) // 스피너를 통해 입력받은 정보 저장
        val time = resources.getStringArray(R.array.time_array)

        val Adapter_place = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,place)
        spinner_inp.adapter = Adapter_place
        spinner_inp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                place_in = place[position] // 스피너를 통해 입력받은 정보 전역변수에 저장

            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        val Adapter_time = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,time)
        spinner_int.adapter = Adapter_time
        spinner_int.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                time_in = time[position] // 스피너를 통해 입력받은 정보 전역변수에 저장
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


        var listener = CompoundButton.OnCheckedChangeListener{buttonView, isChecked ->
            if(isChecked){
                when(buttonView.id){ // 메뉴선택 페이지에서 메뉴 선택되었을때 menu 변수에 메뉴 이름 저장
                    R.id.inCheckBox1 ->  {menu1 = inCheckBox1.text.toString()
                        price += 4500}
                    R.id.inCheckBox2 ->  {menu2 = inCheckBox2.text.toString()
                        price += 9500}
                    R.id.inCheckBox3 ->  {menu3 = inCheckBox3.text.toString()
                        price +=4000}
                    R.id.inCheckBox4 ->  {menu4 = inCheckBox4.text.toString()
                        price += 9000}
                    R.id.inCheckBox5 ->  {menu5 = inCheckBox5.text.toString()
                        price += 500}
                    R.id.inCheckBox6 ->  {menu6 = inCheckBox6.text.toString()
                        price += 4000}
                    R.id.inCheckBox7 ->  {menu7 = inCheckBox7.text.toString()
                        price += 4000}
                    R.id.inCheckBox8 ->  {menu8 = inCheckBox8.text.toString()
                        price += 2500}
                    R.id.inCheckBox9 ->  {menu9 = inCheckBox9.text.toString()
                        price +=2000}
                    R.id.inCheckBox10 ->  {menu10 = inCheckBox10.text.toString()
                        price += 1500}
                }
            }
            else {Toast.makeText(this, "선택 취소.", Toast.LENGTH_SHORT).show()}
        }

        inCheckBox1.setOnCheckedChangeListener(listener) // 리스너와 체크박스 연결
        inCheckBox2.setOnCheckedChangeListener(listener)
        inCheckBox3.setOnCheckedChangeListener(listener)
        inCheckBox4.setOnCheckedChangeListener(listener)
        inCheckBox5.setOnCheckedChangeListener(listener)
        inCheckBox6.setOnCheckedChangeListener(listener)
        inCheckBox7.setOnCheckedChangeListener(listener)
        inCheckBox8.setOnCheckedChangeListener(listener)
        inCheckBox9.setOnCheckedChangeListener(listener)
        inCheckBox10.setOnCheckedChangeListener(listener)

        okButton.setOnClickListener {

            if (menu1 == "" && menu2 == "" && menu3 == "" && menu4 == "" && menu5 == "" && menu6 == "" && menu7 == "" && menu8 == "" && menu9 == "" && menu10 == ""){
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()
                // 메뉴 한개라도 선택되지 않으면 okbutton 누를 수 없도록 처리
            }
            else { // 메뉴가 한개라도 선택될 경우 db에 선택된 메뉴와 닉네임, 가격, 시간, 장소 저장 후 intent + 주문현황 개수 증가
                in_count += 1
                sqlDB = dbManager.writableDatabase
                sqlDB.execSQL("INSERT INTO inTBL VALUES ('"+nickname+"','"+menu1+"', '"+menu2+"', '"+menu3+"', '"+menu4+"', '"+menu5+"', '"+menu6+"', '"+menu7+"', '"+menu8+"', '"+menu9+"', '"+menu10 +"', '"+price+"', '"+place_in+"', '"+time_in+"', '"+start+"');")
                val intent = Intent(this, Order1_Activity::class.java)
                intent.putExtra("shop_name", "in")
                startActivity(intent)
            }
        }

        sqlDB.close()


    }
}