package com.example.app4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //TODO Logica de Spinner
        val listaElementos = arrayOf("Sumar", "Restar")

        val adaptador = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            listaElementos
        )

        spinnerOperaciones.adapter = adaptador

        //TODO logica del boton de aceptar
        btnAceptar.setOnClickListener {

            var elementoSelecionado = spinnerOperaciones.selectedItem.toString()

            var resultado: Int

            if (elementoSelecionado.equals("Sumar")) {
                resultado = 9 + txtNumero.text.toString().toInt()
            } else {
                resultado = 9 - txtNumero.text.toString().toInt()
            }

            var operacionesExtras = ""

            if (chkMultiplicar.isChecked) {
                operacionesExtras += "\nEl resultado de la operacion Multiplicar es ${9 * txtNumero.text.toString().toInt()} "
            }

            if (chkdivision.isChecked) {
                operacionesExtras += "\nEl resultado de la operacion Division es ${9 / txtNumero.text.toString().toInt()}"

            }

            lblResultado.text =
                "El resultado de la operacion ${elementoSelecionado} ${resultado}  ${operacionesExtras}"


        }
    }
}