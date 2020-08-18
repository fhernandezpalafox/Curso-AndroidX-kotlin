package com.example.appsqlite.Modelo

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import java.lang.Exception

class EventosDataSource(context: Context) {

    private val openHelper:DbOpenHelper = DbOpenHelper(context)
    private val database:SQLiteDatabase

    object ColumnEventos {
        var ID_EVENTO = BaseColumns._ID
        var DESCRIPCION_EVENTO = "descripcion"
        var DIA_EVENTO = "dia"
    }

    companion object{
        val EVENTOS_TABLE_NAME = "Eventos"
        val STRING_TYPE = "text"
        val INT_TYPE = "Integer"

        val CREATE_EVENTOS_SCRIPT = (
                """
                    create table $EVENTOS_TABLE_NAME (
                      ${ColumnEventos.ID_EVENTO} $INT_TYPE primary key autoincrement,
                      ${ColumnEventos.DESCRIPCION_EVENTO} $STRING_TYPE not null,
                      ${ColumnEventos.DIA_EVENTO} $STRING_TYPE not null)
                """.trimIndent()
                )

         val INSERT_EVENTOS_SCRIPT = ("""
                                     insert into $EVENTOS_TABLE_NAME values
                                     (null,'Ignaguracion del festival del globo','Viernes 13'),
                                     (null,'Presentacion de grupos musicales','Sabado 14'),
                                     (null,'Viajes en globo','Domingo 15')
                                     """.trimIndent()

                 )
    }

    init {
        database  = openHelper.writableDatabase
    }

    fun consultarEventos():Cursor{
        return database.rawQuery("select _id,descripcion,dia from $EVENTOS_TABLE_NAME ",null)
    }

    fun consultarEventos(idEvento:Int):Cursor{
        return database.rawQuery("select _id,descripcion,dia from $EVENTOS_TABLE_NAME where _id = $idEvento ",null)
    }

    fun guardarEvento(descripcion:String, dia:String){
        val values  = ContentValues()
        values.put(ColumnEventos.DESCRIPCION_EVENTO,descripcion)
        values.put(ColumnEventos.DIA_EVENTO,dia)

         database.insert(EVENTOS_TABLE_NAME,null,values)
    }

    fun modificarEvento(descripcion:String, dia:String, IdEvento: Int){
        val values  = ContentValues()
        values.put(ColumnEventos.DESCRIPCION_EVENTO,descripcion)
        values.put(ColumnEventos.DIA_EVENTO,dia)
        val a = arrayOf(""+IdEvento)


        database.update(EVENTOS_TABLE_NAME,values,"_id=?",a)
    }

    fun eliminarEventos(idEvento: Int):Boolean{

        val whereArgs  = arrayOf(""+idEvento)

        try {
            database.delete(EVENTOS_TABLE_NAME,"_id=?",whereArgs)
            return  true
        }catch (ex:Exception){
            return false
        }finally {
            database.close()
        }

    }
}