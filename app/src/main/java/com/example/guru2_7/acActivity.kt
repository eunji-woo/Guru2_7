package com.example.guru2_7

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox

class acActivity : AppCompatActivity() {

    lateinit var dbManager: DBManager2
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ac)

        dbManager = DBManager2(this)
        sqlDB = dbManager.writableDatabase

        acCheckBox1 = findViewById(R.id.acCheckBox1)
        acCheckBox2 = findViewById(R.id.acCheckBox2)
        acCheckBox3 = findViewById(R.id.acCheckBox3)
        acCheckBox4 = findViewById(R.id.acCheckBox4)
        acCheckBox5 = findViewById(R.id.acCheckBox5)
        acCheckBox6 = findViewById(R.id.acCheckBox6)
        acCheckBox7 = findViewById(R.id.acCheckBox7)
        acCheckBox8 = findViewById(R.id.acCheckBox8)
        acCheckBox9 = findViewById(R.id.acCheckBox9)
        acCheckBox10 = findViewById(R.id.acCheckBox10)


        if (acCheckBox1.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL menu1 ('" + acCheckBox1.text.toString() + "');")
        if (acCheckBox2.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL memu2 ('" + acCheckBox2.text.toString() + "');")
        if (acCheckBox3.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL memu3 ('" + acCheckBox3.text.toString() + "');")
        if (acCheckBox4.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox4.text.toString() + "');")
        if (acCheckBox5.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox5.text.toString() + "');")
        if (acCheckBox6.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox6.text.toString() + "');")
        if (acCheckBox7.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox7.text.toString() + "');")
        if (acCheckBox8.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox8.text.toString() + "');")
        if (acCheckBox9.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox9.text.toString() + "');")
        if (acCheckBox10.isChecked)
            sqlDB.execSQL("INSERT INTO acTBL VALUES ('" + acCheckBox10.text.toString() + "');")

        sqlDB.close()


    }
}