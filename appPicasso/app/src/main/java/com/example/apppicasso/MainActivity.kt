package com.example.apppicasso

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.with(this).load("https://androidzone.org/wp-content/uploads/2013/02/android-musical2.jpg").into(imgPicasso)
        //Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(imageView);
    }
}