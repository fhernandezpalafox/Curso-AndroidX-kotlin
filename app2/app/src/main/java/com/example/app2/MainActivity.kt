package com.example.app2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        //TODO esto es importante leerlo
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSumar.setOnClickListener {

            val numero1 =  txtNum1.text.toString().toInt()
            val numero2 =  txtNum2.text.toString().toInt()

            val suma  =  numero1 + numero2

            Toast.makeText(this,"La suma es $suma", Toast.LENGTH_LONG).show()

        }





    }
}