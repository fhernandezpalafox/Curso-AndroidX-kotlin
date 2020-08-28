package com.example.appnavview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_layout.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(appbar)
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_menu)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        navview.setNavigationItemSelectedListener {  menuItem ->

            var fragmentTransition =  false
            var fragment : Fragment? = null

            when(menuItem.itemId){

                R.id.menu_opcion1 -> {
                    fragment = fragment1()
                    fragmentTransition =  true
                }

                R.id.menu_opcion2 -> {
                    fragment = fragment2()
                    fragmentTransition =  true
                }
            }

            if(fragmentTransition){
                supportFragmentManager.beginTransaction()
                    .replace(R.id.content_frame,fragment!!)
                    .commit()

                menuItem.setChecked(true)
                supportActionBar!!.setTitle(menuItem.title)
            }

            drawer_layout.closeDrawers()

            true

        }


    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }



}