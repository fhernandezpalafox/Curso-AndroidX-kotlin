package com.example.app3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logica()
    }



    private fun logica(){

         btnAceptar.setOnClickListener {
             var cadenaTexto : String
             var genero: String

             if (validador() ==  false){

                 if (rdbHombre.isChecked){
                     genero = rdbHombre.text.toString()
                 }else {
                     genero = rdbMujer.text.toString()
                 }

                 cadenaTexto = "Tu nombre es ${txtNombre.text.toString()}, "+
                               " apellido es ${txtApellido.text.toString()} y tu genero es $genero"

                 lblInformacion.text = cadenaTexto

             }
         }

        //TODO Quitar este evento para mañana sabado sesion 4
       //  textInputLayoutNombre.setOnClickListener {
        //      textInputLayoutNombre.isErrorEnabled =  false
      //  }


        //TODO Se agrega codigo aportación Jose Ignacio Garcia MTWDM
        txtNombre.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                textInputLayoutNombre.error=null
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })


    }

    private fun validador() : Boolean {

        var validadorEntro  =  false

        if (TextUtils.isEmpty(txtNombre.text.toString())){
            textInputLayoutNombre.error = "Captura tu nombre"
            validadorEntro  =  true
        }

        if (TextUtils.isEmpty(txtApellido.text.toString())){
            textInputLayoutApellido.error = "Captura tu apellido"
            validadorEntro  =  true
        }

        return validadorEntro
    }


}