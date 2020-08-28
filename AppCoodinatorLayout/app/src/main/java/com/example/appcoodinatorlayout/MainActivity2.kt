package com.example.appcoodinatorlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {

    private val nombres = arrayOf("Jorge", "Pablo", "Luis", "Monica", "Pedro")
    private val conocimientos = arrayOf("Java", "C#", "SQL Server", "Oracle", "Android")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        Inicializar()
        Eventos()
    }

    fun Inicializar() {

        //adaptador para nuestra ListView
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres)
        lista.adapter = adapter


        //animaciones
        floatingAction.scaleX = 0F
        floatingAction.scaleY = 0F

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val interpolador = AnimationUtils.loadInterpolator(
                baseContext,
                android.R.interpolator.fast_out_slow_in
            )

            floatingAction.animate()
                .scaleX(1F)
                .scaleY(1F)
                .setInterpolator(interpolador)
                .setDuration(600).startDelay = 1000


        }


    }


    fun Eventos() {

        lista.setOnItemClickListener { parent, view, position, id ->
            textSeleccionado.setText("El conocimiento que tiene " + lista.getItemAtPosition(position) + " es " + conocimientos[position])
        }

        floatingAction.setOnClickListener{view->
            Snackbar.make(view, "Se presiono el boton", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

    }
}