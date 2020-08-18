package com.example.app8notificacionesshourcuts

import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val bundle =  intent.extras
        if(bundle!!.getString("parametro")!=null){
            textView2.text = bundle.getString("parametro")

            //Codigo para notificaciones
            val ns =  Context.NOTIFICATION_SERVICE
            val notificationManager =  baseContext.getSystemService(ns) as NotificationManager
            notificationManager.cancel(bundle.getInt("idNotificacion"))
        }
    }
}