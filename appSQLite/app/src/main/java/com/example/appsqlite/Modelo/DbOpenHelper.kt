package com.example.appsqlite.Modelo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "Eventos.db"
val DATABASE_VERSION = 1

class DbOpenHelper(context: Context):
    SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(EventosDataSource.CREATE_EVENTOS_SCRIPT)
        db!!.execSQL(EventosDataSource.INSERT_EVENTOS_SCRIPT)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }


}