package com.example.guru2_7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

//class DBManager(context: Context, name:String?, factory: SQLiteDatabase.CursorFactory?,version:Int) : SQLiteOpenHelper(context, "groupDB", null, 1) {
//    override fun onCreate(db: SQLiteDatabase?) {
//        db!!.execSQL("CREATE TABLE groupTBL (nickname CHAR(20), email CHAR(30) PRIMARY KEY, passwd CHAR(30));")
//    }
//
//    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
//        TODO("Not yet implemented")
//    }
//}

class DBManager(context: Context) : SQLiteOpenHelper(context, "groupDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE groupTBL (nickname CHAR(20), email CHAR(30) PRIMARY KEY, passwd CHAR(30));")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}