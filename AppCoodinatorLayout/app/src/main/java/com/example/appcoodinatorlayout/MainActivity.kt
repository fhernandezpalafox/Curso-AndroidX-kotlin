package com.example.appcoodinatorlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Operaciones()
    }


    fun Operaciones(){

        btnIr.setOnClickListener{ view->
            val i = Intent(applicationContext, MainActivity2::class.java)
            startActivity(i)
        }

        btnlistaConImagen.setOnClickListener{view->
            val i = Intent(applicationContext, MainActivity3::class.java)
            startActivity(i)
        }
    }
}