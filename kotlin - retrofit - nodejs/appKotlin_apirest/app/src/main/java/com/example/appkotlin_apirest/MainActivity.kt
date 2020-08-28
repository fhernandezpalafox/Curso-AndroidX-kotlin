package com.example.appkotlin_apirest

import Controladores.ArticulosController
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

     lateinit var articulosController: ArticulosController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ToolbarInicializador()

        ObtenerDatos();

        Onswiperefresh()

    }

    fun Onswiperefresh(){
        swiperefresh.setOnRefreshListener {

            ObtenerDatos();

            Toast.makeText(applicationContext, "Descargando...", Toast.LENGTH_SHORT).show()

            swiperefresh.isRefreshing = false
            progressBarCargando.visibility = View.VISIBLE
        }
    }

    fun ToolbarInicializador(){
        setSupportActionBar(appbar);
        appbar.setTitleTextColor(Color.WHITE)
        supportActionBar!!.title = "Lista"
    }

    fun ObtenerDatos() {

        // usa esta configuración para mejorar el rendimiento si sabes que cambia
        // en el contenido no cambia el tamaño del diseño de RecyclerView
        //reyclerViewArticulo.setHasFixedSize(true);
        val llm = LinearLayoutManager(applicationContext)
        listaArticulos.layoutManager = llm
        listaArticulos.setHasFixedSize(true)

        articulosController = ArticulosController()
        articulosController.cargarArticulos(listaArticulos, applicationContext, "",progressBarCargando)
    }

}