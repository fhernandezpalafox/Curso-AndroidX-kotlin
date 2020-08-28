package com.example.appcoodinatorlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {


    var imagen: Int = 0
    var  nombre:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        //Funcion Toolbar
        setToolbar()

        if(supportActionBar != null){
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        //hacer traslucido la barra
        setStatusBarTranslucent(true)

        if(intent.extras != null){
            nombre = intent.extras!!.getString("nombre")!!
            imagen = intent.extras!!.getInt("imagen")
        }

        app_bar_image.setImageResource(imagen)
        collapsiontoolbar.title  = nombre

        window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,)


    }

    private fun setStatusBarTranslucent(makeTranslucent:Boolean){

        if(makeTranslucent){
            //window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }else {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }

    }

    private fun setToolbar(){
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return  true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id  =  item.itemId
        when(id){
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.btnAcerca -> {
                Snackbar.make(findViewById(R.id.coordinatorlayout),"Desarrollado por Felipe hernandez", Snackbar.LENGTH_LONG)
                    .show()
            }
            else -> return super.onOptionsItemSelected(item)
        }

        return true

    }


}