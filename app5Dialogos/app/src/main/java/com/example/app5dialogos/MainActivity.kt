package com.example.app5dialogos


import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.shreyaspatil.MaterialDialog.AbstractDialog
import com.shreyaspatil.MaterialDialog.MaterialDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Eventos()
    }


    fun Eventos() {

        btnAlerta1.setOnClickListener {

            val builder =  AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Mensaje de prueba")
                    .setTitle("Mensaje")
                    .setPositiveButton("Aceptar"){ dialog, which ->
                        lblInformacion.text  = "Respuesta de nuestra alerta"
                    }
            builder.create().show()
        }


        btnAlerta2.setOnClickListener {

            val builder =  AlertDialog.Builder(this@MainActivity)
            builder.setMessage("Mensaje de prueba")
                .setTitle("Mensaje")
                .setPositiveButton("Aceptar"){ dialog, which ->
                    lblInformacion.text  = "Respuesta de nuestra alerta"
                }
                .setNegativeButton("Cancelar"){ dialog, which ->
                    lblInformacion.text  = "Respuesta de nuestra alerta Negativa"
                    dialog.cancel()
                }
            builder.create().show()
        }


        btnAlerta3.setOnClickListener {


            //TODO Alerta con elementos selecionables
            val datos =  arrayOf("Felipe","Oscar", "Juan")

            val builder =  AlertDialog.Builder(this@MainActivity)

               builder.setTitle("Selecciona un nombre")
                   .setItems(datos){ dialog: DialogInterface?, which: Int ->
                       lblInformacion.text = String.format("Tu nombre es %s",datos[which])
                   }
            builder.create().show()

            //TODO Alerta con radioButons
            val builder2 =  AlertDialog.Builder(this@MainActivity)
               builder2.setTitle("Selecciona")
                      .setSingleChoiceItems(datos,-1){dialog2: DialogInterface?, item: Int ->
                          lblInformacion.text = String.format("Tu nombre es %s",datos[item])
                          dialog2?.cancel()
                      }

               builder2.create().show()

            //TODO Alerta con checkbox
            val builder3 =  AlertDialog.Builder(this@MainActivity)
            builder3.setTitle("Selecciona")
                .setMultiChoiceItems(datos,null)
                {dialog2: DialogInterface?, items: Int, isChecked:Boolean ->

                    if (isChecked){
                        val informacion  = lblInformacion.text.toString()
                        lblInformacion.text = informacion + String.format("%s",datos[items]) + ","

                    }

                }

            builder3.create().show()
        }


        btnAlertaLibreria.setOnClickListener {

            val mDialog = MaterialDialog.Builder(this)
                .setTitle("Delete?")
                .setMessage("Are you sure want to delete this file?")
                .setCancelable(false)
                .setPositiveButton("Delete", android.R.drawable.ic_delete,
                      AbstractDialog.OnClickListener { dialogInterface, which ->

                })
                .setNegativeButton("Cancel", android.R.drawable.ic_dialog_info,
                    AbstractDialog.OnClickListener { dialogInterface, which ->
                      dialogInterface.dismiss()
                })
                .build()
            mDialog.show()

        }

    }
}