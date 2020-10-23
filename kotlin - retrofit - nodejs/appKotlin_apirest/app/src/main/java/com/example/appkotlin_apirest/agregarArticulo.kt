package com.example.appkotlin_apirest

import Controladores.ArticulosController
import Entidades.Articulo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tfb.fbtoast.FBToast
import kotlinx.android.synthetic.main.activity_agregar_articulo.*
import kotlinx.android.synthetic.main.toolbar.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class agregarArticulo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_articulo)

        Eventos()

        ToolbarInicializador()
    }

    fun Eventos(){
        var articulosController = ArticulosController()

        btnAceptar.setOnClickListener {
            var objArticulo = Articulo()
            objArticulo.nombre = txtNombre.text.toString()
            objArticulo.descripcion =  txtDescripcion.text.toString()
            objArticulo.cantidad =  txtCantidad.text.toString().toInt()
            var call =  articulosController.insertarArticulos(objArticulo,this)

            call.enqueue(object : Callback<Articulo> {
                override fun onResponse(call: Call<Articulo>, response: Response<Articulo>) {
                    when (response.code()) {
                        200 -> {
                            var articulo  = response.body()
                            //TODO Mensaje al usuario
                            FBToast.infoToast(applicationContext,"Se insertó correctamente", FBToast.LENGTH_SHORT);
                            txtNombre.setText("")
                            txtCantidad.setText("")
                            txtDescripcion.setText("")

                        }
                        401 -> {
                        }
                        else -> {
                        }
                    }
                }

                override fun onFailure(call: Call<Articulo>, t: Throwable) {
                    print(t)
                }

            })
        }

        btnAtras.setOnClickListener {
            finish()
        }

    }

    fun ToolbarInicializador(){
        setSupportActionBar(appbar);
        appbar.setTitleTextColor(Color.WHITE)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Agregar  Articulo"
    }
}