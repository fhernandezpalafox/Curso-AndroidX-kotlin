package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnAceptar.setOnClickListener{
            lblPresentacion.text  = "Hola ${txtNombre.text}"
        }

        //lblPresentacion.text = "Hola mundo MTWDM"
    }
}