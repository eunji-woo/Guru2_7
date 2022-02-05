package com.example.guru2_7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class inDBManager(context: Context) : SQLiteOpenHelper(context, "inMenuDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        // 이나 메뉴 저장 DB 생성
        db!!.execSQL("CREATE TABLE inTBL (nickname CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30), menu4 CHAR(30), menu5 CHAR(30), menu6 CHAR(30), menu7 CHAR(30), menu8 CHAR(30), menu9 CHAR(30), menu10 CHAR(30), price INT(30), place CHAR(30), time CHAR(10), start CHAR(10));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        // 주문 완료시 테이블 DROP하고 다시 생성
        db!!.execSQL("DROP TABLE IF EXISTS inTBL")
        onCreate(db)
    }

}