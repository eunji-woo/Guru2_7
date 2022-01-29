package com.example.guru2_7

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBManager2(context: Context) : SQLiteOpenHelper(context, "MenuDB", null, 1) {
        override fun onCreate(db: SQLiteDatabase?) {

            db!!.execSQL("CREATE TABLE acTBL (nickname CHAR(20) PRIMARY KEY, shop CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30));")
            /*db!!.execSQL("CREATE TABLE kimTBL (nickname CHAR(20) PRIMARY KEY, shop CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30), price CHAR(30), time CHAR(30), place CHAR(30));")
            db!!.execSQL("CREATE TABLE mongTBL (nickname CHAR(20) PRIMARY KEY, shop CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30), price CHAR(30), time CHAR(30), place CHAR(30));")
            db!!.execSQL("CREATE TABLE wfTBL (nickname CHAR(20) PRIMARY KEY, shop CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30), price CHAR(30), time CHAR(30), place CHAR(30));")
            db!!.execSQL("CREATE TABLE inTBL (nickname CHAR(20) PRIMARY KEY, shop CHAR(30), menu1 CHAR(30), menu2 CHAR(30), menu3 CHAR(30), price CHAR(30), time CHAR(30), place CHAR(30));")*/
        }

        override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("Not yet implemented")
        }

}