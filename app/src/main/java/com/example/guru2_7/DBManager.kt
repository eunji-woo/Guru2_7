package com.example.guru2_7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBManager(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //유저 정보 저장 테이블 생성
        db!!.execSQL("CREATE TABLE groupTBL (nickname CHAR(20) PRIMARY KEY, email CHAR(30), passwd CHAR(30));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}
