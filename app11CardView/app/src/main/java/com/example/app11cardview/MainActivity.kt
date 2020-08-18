package com.example.app11cardview

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private var imgLlamar: ImageView? = null
    private var imgMessage: ImageView? = null
    private val REQUEST_PHONE_CALL = 1

    val isPermissionGranted: Boolean
        get(){
            if (Build.VERSION.SDK_INT >= 23){

                if(checkSelfPermission(android.Manifest.permission.CALL_PHONE) === PackageManager.PERMISSION_GRANTED)
                {
                    Log.v("TAG","Se otorgo el permiso")
                    return true
                }else {
                    Log.v("TAG","No se otorgo el permiso")
                    ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),1)
                    return  false
                }

            }

            return false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgLlamar = findViewById(R.id.imgLlamar)
        imgMessage  =  findViewById(R.id.imgMensaje)


        imgLlamar!!.setOnClickListener {
            if(isPermissionGranted){
                call_function()
            }
        }

        imgMessage!!.setOnClickListener {
            val compartirMensaje = Intent(Intent.ACTION_SEND)
            compartirMensaje.setType("text/plain")
            compartirMensaje.putExtra(Intent.EXTRA_TEXT,"Esto es un mensaje")
            //compartirMensaje.setPackage("com.whatsapp")
            startActivity(compartirMensaje)
        }
    }


    fun call_function(){
        val num = "4771830787"
        val callIntent = Intent(Intent.ACTION_CALL)
        callIntent.data  = Uri.parse("tel:$num")

        if(ActivityCompat.checkSelfPermission(this,android.Manifest.permission.CALL_PHONE) !== PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.CALL_PHONE),REQUEST_PHONE_CALL)
            return
        }

        startActivity(callIntent)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {

        when(requestCode){
            REQUEST_PHONE_CALL-> {
                if((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED))
                {
                    Toast.makeText(applicationContext,"Permission granted", Toast.LENGTH_SHORT).show()
                    call_function()
                }else {
                    Toast.makeText(applicationContext,"Permission denied", Toast.LENGTH_SHORT).show()
                }
            }

        }

    }
}