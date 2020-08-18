package com.example.app8notificacionesshourcuts

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private  var NumeroNotificaiones = 5

    private var mManager: NotificationManager? = null

    fun getManager() :NotificationManager{
        if(mManager == null){
            mManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        return mManager as NotificationManager
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val canal1Prueba = NotificationChannel("com.prueba.canalPrueba1","Canal prueba 1",
                                         NotificationManager.IMPORTANCE_HIGH)
            canal1Prueba.enableLights(true)
            canal1Prueba.enableVibration(true)
            canal1Prueba.lightColor = Color.GREEN
            canal1Prueba.lockscreenVisibility = Notification.BADGE_ICON_SMALL
            getManager().createNotificationChannel(canal1Prueba)


            val canal2Prueba = NotificationChannel("com.prueba.canalPrueba2","Canal prueba 2",
                NotificationManager.IMPORTANCE_HIGH)
            canal2Prueba.enableLights(true)
            canal2Prueba.enableVibration(true)
            canal2Prueba.lightColor = Color.GREEN
            canal2Prueba.lockscreenVisibility = Notification.BADGE_ICON_SMALL
            getManager().createNotificationChannel(canal2Prueba)



        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        shortcutDinamico();

        createNotificationChannel();

        btnNotificacion1.setOnClickListener {
            val builder =  NotificationCompat.Builder(applicationContext,"com.prueba.canalPrueba1")
                .setSmallIcon(R.mipmap.ic_user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_user))
                .setContentText("Este es el contenido de mi notificacion")
                .setTicker("ejemplo de notificacion")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                getManager().notify(0,builder.build())
        }


        btnNotificacion2.setOnClickListener {

            val idNotificaion = 234

            val resultIntent = Intent(this@MainActivity,ResultadoActivity::class.java)
            resultIntent.putExtra("parametro","Valor 1")
            resultIntent.putExtra("idNotificacion",idNotificaion)
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            val pendingIntent = PendingIntent.getActivity(this@MainActivity,
                                      1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT)
            val inboxStyle = NotificationCompat.InboxStyle()
            inboxStyle.setBigContentTitle("Notificacion Personalizada")
            inboxStyle.addLine("Esta es la linea numero 1")
            inboxStyle.addLine("Esta es la linea numero 2")
            inboxStyle.addLine("Esta es la linea numero 3")
            inboxStyle.addLine("Esta es la linea numero 4")
            inboxStyle.addLine("Esta es la linea numero 5")
            inboxStyle.addLine("Esta es la linea numero 6")
            NumeroNotificaiones += 1
            inboxStyle.setSummaryText(String.format(" + %d mas",NumeroNotificaiones))



            val builder =  NotificationCompat.Builder(applicationContext,"com.prueba.canalPrueba2")
                .setSmallIcon(R.mipmap.ic_user)

                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_user))
                .setContentTitle("Ejemplo de notificacion")
                .setContentText("Este es el contenido de mi notificacion")
                .setTicker("ejemplo de notificacion")
                .setVibrate(longArrayOf(100,250,100,500))
                .setStyle(inboxStyle)
                .addAction(R.mipmap.ic_user,"ver mensaje", pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            getManager().notify(idNotificaion,builder.build())
        }


        btnNotificacion3.setOnClickListener {

            val textolargo =  NotificationCompat.BigTextStyle()
            textolargo.bigText("Android Studio es el entorno de desarrollo integrado oficial para la plataforma Android. Fue anunciado el 16 de mayo de 2013 en la conferencia Google I/O, y reemplazó a Eclipse como el IDE oficial para el desarrollo de aplicaciones para Android")
            textolargo.setBigContentTitle("Android Studio")
            textolargo.setSummaryText("Hecho por: Android")

            val builder =  NotificationCompat.Builder(applicationContext,"com.prueba.canalPrueba1")
                .setSmallIcon(R.mipmap.ic_user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_user))
                .setContentText("Este es el contenido de mi notificacion")
                .setContentTitle("Ejemplo de notificacion")
                .setTicker("ejemplo de notificacion")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(textolargo)
            getManager().notify(0,builder.build())

        }


        btnNotificacion4.setOnClickListener {

             var idNotificaion = 123
            val resultIntent = Intent(this@MainActivity,ResultadoActivity::class.java)
            resultIntent.putExtra("parametro","Valor 1")
            resultIntent.putExtra("idNotificacion",idNotificaion)
            resultIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            val pendingIntent = PendingIntent.getActivity(this@MainActivity,
                1,resultIntent,PendingIntent.FLAG_UPDATE_CURRENT)

            val bigPictureStyle = NotificationCompat.BigPictureStyle()
            bigPictureStyle.bigPicture(BitmapFactory.decodeResource(resources,R.drawable.android)).build()

            val builder =  NotificationCompat.Builder(applicationContext,"com.prueba.canalPrueba1")
                .setSmallIcon(R.mipmap.ic_user)
                .setLargeIcon(BitmapFactory.decodeResource(resources,R.mipmap.ic_user))
                .setContentText("Este es el contenido de mi notificacion")
                .setContentTitle("Ejemplo de notificacion")
                .setTicker("ejemplo de notificacion")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(bigPictureStyle)
                .addAction(R.mipmap.ic_user,"Compartir",pendingIntent)
                .addAction(R.mipmap.ic_user,"Enviar",pendingIntent)
            getManager().notify(0,builder.build())

        }

    }

    fun shortcutDinamico(){

        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.N_MR1) return
        val idNotificacion = 234
        val shortcutManager = applicationContext.getSystemService(ShortcutManager::class.java)

        val nuevaTareaIntent = Intent(applicationContext,ResultadoActivity::class.java)
        nuevaTareaIntent.action =  Intent.ACTION_VIEW
        nuevaTareaIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        nuevaTareaIntent.putExtra("parametro","Valor 1")
        nuevaTareaIntent.putExtra("idNotificacion",idNotificacion)

        val resultIntent = Intent(this@MainActivity,ResultadoActivity::class.java)
        resultIntent.putExtra("parametro","Valor 1")
        resultIntent.putExtra("idNotificacion",idNotificacion)

        val postShorcut = ShortcutInfo.Builder(applicationContext,"1")
            .setShortLabel("Informacion")
            .setLongLabel("Informacion importante")
            .setIcon(Icon.createWithResource(applicationContext,R.mipmap.ic_user))
            .setIntent(nuevaTareaIntent)
            .build()

        val shourtInfoList =  mutableListOf<ShortcutInfo>()
            shourtInfoList.add(postShorcut)

        shortcutManager.addDynamicShortcuts(shourtInfoList)




    }

}