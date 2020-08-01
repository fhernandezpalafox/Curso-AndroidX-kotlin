package com.example.app7toastsnackbar

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_toast.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnToast1.setOnClickListener {
            val toast1  =  Toast.makeText(applicationContext,"Este es un Toast",Toast.LENGTH_SHORT)
            toast1.show()
        }

        btnToast2.setOnClickListener {
            val toast2  =  Toast.makeText(applicationContext,"Este es un Toast",Toast.LENGTH_LONG)
            toast2.setGravity(Gravity.LEFT or Gravity.BOTTOM,0,0)
            toast2.show()
        }

        btnToast3.setOnClickListener {

            val toast3 = Toast(applicationContext)
            val inflater = layoutInflater

            val layout = inflater.inflate(R.layout.layout_toast,findViewById(R.id.layoutToast))
            val txtMensaje = layout.Mensaje

            txtMensaje.text = "Este es un mensaje de un toast dinamico"
            toast3.duration = Toast.LENGTH_LONG
            toast3.view = layout
            toast3.show()

        }

        btnsnackbar.setOnClickListener { view ->

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                Snackbar.make(view,"Este es un mensaje de prueba", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(resources.getColor(R.color.colorPrimary,null))
                        .setAction("Aceptar"){
                            val toast1  =  Toast.makeText(applicationContext,"Este es un Toast",Toast.LENGTH_SHORT)
                            toast1.show()
                        }
                        .show()

            }

        }

    }
}