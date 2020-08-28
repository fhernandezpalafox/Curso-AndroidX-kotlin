package Controladores

//import Adaptadores.ArticulosAdapter

import Adaptadores.ArticulosAdapter
import Entidades.Articulo
import Interfaces.RestClient
import android.content.Context
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ArticulosController {

    lateinit var listaArticulos: List<Articulo>
    lateinit var mAdapter: RecyclerView.Adapter<*>
    lateinit var recyclerViewArticulos2: RecyclerView
    lateinit var progressbar: ProgressBar
    lateinit var context: Context
    private val queryBusqueda = ""
    lateinit var listaArticulosBusqueda: List<Articulo>



    fun cargarArticulos(recyclerViewArticulos: RecyclerView, context: Context, queryBusqueda: String, progressdialog: ProgressBar) {

        this.context = context

        progressbar = progressdialog
        progressbar.visibility = View.VISIBLE

        recyclerViewArticulos2 = recyclerViewArticulos
        listaArticulosBusqueda = ArrayList()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.200.216:3001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val restClient: RestClient = retrofit.create(RestClient::class.java)

        val call: Call<List<Articulo>> = restClient.cargarArticulos()


        call.enqueue(object : Callback<List<Articulo>> {
            override fun onResponse(call: Call<List<Articulo>>, response: Response<List<Articulo>>) {
                when (response.code()) {
                    200 -> {
                        listaArticulos =  emptyList()
                        listaArticulos = response.body()!!

                        mAdapter = ArticulosAdapter(listaArticulos)
                        recyclerViewArticulos.adapter = mAdapter
                        mAdapter!!.notifyDataSetChanged()
                        progressbar.visibility = View.GONE
                    }
                    401 -> {
                    }
                    else -> {
                    }
                }
            }

            override fun onFailure(call: Call<List<Articulo>>, t: Throwable) {
                System.out.println(t)
                progressbar.visibility = View.GONE
            }
        })
    }

}