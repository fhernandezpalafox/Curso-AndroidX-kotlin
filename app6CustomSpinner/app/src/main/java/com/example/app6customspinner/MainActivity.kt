package com.example.app6customspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Inicializar();
        Eventos();

    }
    fun Inicializar(){

        //Llenar Spinner
        val edoCivil = arrayOf("Soltero","Casado","Divorciado")

        val adapter = ArrayAdapter(this, R.layout.ejemplo_spinner,edoCivil) //android.R.layout.simple_spinner_item

        listaEdoCivil.adapter = adapter;
    }

    fun Eventos(){

        btnAceptar.setOnClickListener {

            var informacion : String = String.format("Tu nombre es %s  y tu estado civil es %s",
                txtNombre.text.toString(), listaEdoCivil.selectedItem.toString())
            lblInformacion.text =  informacion

        }

        listaEdoCivil.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                lblInformacion.text = "No selecciono nada el usuario"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?,
                                           position: Int, id: Long) {
                var informacion : String = String.format("Tu nombre es %s  y tu estado civil es %s",
                         txtNombre.text.toString(), parent!!.getItemAtPosition(position))
                lblInformacion.text =  informacion
            }

        }

    }
}