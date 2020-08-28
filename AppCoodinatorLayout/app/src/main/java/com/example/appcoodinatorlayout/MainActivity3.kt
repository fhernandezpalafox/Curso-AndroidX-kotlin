package com.example.appcoodinatorlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.layout_persona.view.*
import java.util.ArrayList

class MainActivity3 : AppCompatActivity() {

    lateinit var listaPersonas: ArrayList<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        Incializar()
        Eventos()

    }

    fun Incializar(){

        listaPersonas  =  ArrayList()

        listaPersonas.add(Persona("Bill Gates","Microsoft",R.drawable.c_bill_gates,R.drawable.g_bill_gates))
        listaPersonas.add(Persona("Larry Page","Google",R.drawable.c_larry_page,R.drawable.g_larry_page))
        listaPersonas.add(Persona("Sergey Brin","Google",R.drawable.c_sergey_brin,R.drawable.g_sergey_brin))


        val adaptadorPersonas =  AdaptadorPersonas(this)

        lista.adapter  =  adaptadorPersonas

    }

    fun  Eventos(){

        lista.setOnItemClickListener { adapterView, view, position, id ->

            val i = Intent(applicationContext,MainActivity4::class.java)
            i.putExtra("nombre",listaPersonas[position].nombre)
            i.putExtra("imagen", listaPersonas[position].imagenGrande)
            startActivity(i)


        }

    }

     internal inner class  AdaptadorPersonas(context:AppCompatActivity)
         :ArrayAdapter<Persona>(context,0,listaPersonas){

         override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

             val inflater = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_persona,parent,false)

             val  currentPersona =   getItem(position) //List<T>  = List<Persona> // listapersonas[position] [0][1]

             inflater.lblNombrePersona.text  = currentPersona!!.nombre
             inflater.lblEmpresaPersona.text  = currentPersona!!.empresa
             inflater.imgPersona.setImageResource(currentPersona.imagen)

             return inflater
         }
     }

}