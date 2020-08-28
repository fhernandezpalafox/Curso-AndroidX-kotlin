package com.example.appnavview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment2.*
import kotlinx.android.synthetic.main.fragment_fragment2.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment2 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view  =  inflater.inflate(R.layout.fragment_fragment2, container, false)

        view.btnAceptar.setOnClickListener {
            lblInformacion.setText("Hola como estas?")
        }

        return view
    }

}