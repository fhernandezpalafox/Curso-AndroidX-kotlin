package com.example.appkotlin_apirest

import Controladores.ArticulosController
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.sulek.ssml.SSMLLinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() {

     lateinit var articulosController: ArticulosController

    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ToolbarInicializador()

        ObtenerDatos();

        Onswiperefresh()

        EventoFloactionButton()
    }

    fun EventoFloactionButton(){

        fbAgregar.setOnClickListener {
            val intent = Intent(this, agregarArticulo::class.java).apply {
                putExtra("valor", "nada")
            }
            startActivity(intent)
        }
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

        //val llm = LinearLayoutManager(applicationContext)
        //listaArticulos.layoutManager = llm
        listaArticulos.setHasFixedSize(true)

        layoutManager = SSMLLinearLayoutManager(this)
        listaArticulos.layoutManager = layoutManager

        //TODO instanciando la clase de Articulos Controller
        articulosController = ArticulosController()

       // Log.i("Entro al floactionbutton","Esto es un mensaje de prueba ${listaArticulos}")
        articulosController.cargarArticulos(listaArticulos, applicationContext, "",progressBarCargando)



    }

}