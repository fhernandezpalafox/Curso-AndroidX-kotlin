package com.example.app9internacionalizacion

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import java.util.*

class MainActivity : AppCompatActivity() {

    private var uiSwitch:Switch? = null
    private var prefe:SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefe  =  getSharedPreferences("datos",Context.MODE_PRIVATE)

        uiSwitch = findViewById(R.id.switch1)


        val idioma = prefe!!.getString("idioma","")
        if (idioma!!.isNotEmpty()){

            uiSwitch!!.isChecked = idioma !=  "es"


        }


        uiSwitch!!.setOnCheckedChangeListener { compoundButton, b ->

            var locale: Locale?
            val config = Configuration()

            val editor =  prefe!!.edit()

            if (uiSwitch!!.isChecked){

                locale = Locale("en")
                Locale.setDefault(locale)
                config.setLocale(locale)

                editor.putString("idioma","en")
                editor.commit()


            }else {

                locale = Locale("es")
                Locale.setDefault(locale)
                config.setLocale(locale)

                editor.putString("idioma","es")
                editor.commit()

            }

            resources.updateConfiguration(config,resources.displayMetrics)



            val refresh  =  Intent(this@MainActivity, MainActivity::class.java)
            startActivity(refresh)

            finish()

        }

    }

}