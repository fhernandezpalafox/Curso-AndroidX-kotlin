package com.example.apphuella

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.hardware.fingerprint.FingerprintManagerCompat
import com.easyfingerprint.EasyFingerPrint
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Eventos()

    }

    fun Eventos(){

        btnEntrar.setOnClickListener {

            if (TextUtils.isEmpty(txtUsuario.text.toString()) &&  TextUtils.isEmpty(txtPassword.text.toString())){

            }else {

                if(txtUsuario.text.toString().equals("felipe") && txtPassword.text.toString().equals("fe"))
                {
                    Toast.makeText(this@MainActivity,"entro",Toast.LENGTH_LONG).show()
                }

            }

        }

    }

    fun abrirDialogo(view: View){

        EasyFingerPrint(this)
            .setTittle("Sign in")
            .setSubTittle("account@account.com.br")
            .setDescription("In order to use the Fingerprint sensor we need your authorization first.e")
            .setColorPrimary(R.color.colorPrimary)
            .setIcon(ContextCompat.getDrawable(this,R.mipmap.ic_launcher_round))
            .setListern(object : EasyFingerPrint.ResultFingerPrintListern{
                override fun onError(mensage: String, code: Int) {

                    when(code){
                        EasyFingerPrint.CODE_ERRO_CANCEL -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_GREATER_ANDROID_M -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_HARDWARE_NOT_SUPPORTED -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_NOT_ABLED -> { } // TO DO
                        EasyFingerPrint.CODE_ERRO_NOT_FINGERS -> { } // TO DO
                        EasyFingerPrint.CODE_NOT_PERMISSION_BIOMETRIC -> { } // TO DO
                    }

                    Toast.makeText(this@MainActivity,"Error: $mensage / $code",Toast.LENGTH_SHORT).show()
                }

                override fun onSucess(cryptoObject: FingerprintManagerCompat.CryptoObject?) {
                    Toast.makeText(this@MainActivity,"Entro",Toast.LENGTH_SHORT).show()
                }

            })
            .startScan()
    }

}