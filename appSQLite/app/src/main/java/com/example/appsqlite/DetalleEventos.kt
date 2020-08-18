package com.example.appsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.appsqlite.Modelo.EventosDataSource
import kotlinx.android.synthetic.main.content_detalle_eventos.*

class DetalleEventos : AppCompatActivity() {

    private lateinit var datasource:EventosDataSource

    private var id = 0
    private var dia = ""
    private var desripcion = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_eventos)

        datasource = EventosDataSource(this)

        val b = this.intent.extras
        if(b != null){

            id = b.getInt("id")
            dia = b.getString("dia").toString()
            desripcion = b.getString("descripcion").toString()

            txtdia.setText(dia)
            txtDescripcion.setText(desripcion)

        }


    }

    fun Eliminar(view: View){

        if (datasource.eliminarEventos(id)){

            val toast  =  Toast.makeText(applicationContext, "Se realizo correctamente", Toast.LENGTH_SHORT)
                toast.show()

            txtdia.setText("")
            txtDescripcion.setText("")
            id  = 0
        }

    }

    fun GuardarEvento(view: View){

        if(id != 0){

            //editar
            datasource.modificarEvento(txtDescripcion.text.toString(),txtdia.text.toString(),id)
            val toast = Toast.makeText(applicationContext, "Se editó correctamente", Toast.LENGTH_SHORT)
                 toast.show()
        }else {

            datasource.guardarEvento(txtDescripcion.text.toString(),txtdia.toString())
            val toast = Toast.makeText(applicationContext, "Se guardo correctamente", Toast.LENGTH_SHORT)
            toast.show()
        }

    }

}