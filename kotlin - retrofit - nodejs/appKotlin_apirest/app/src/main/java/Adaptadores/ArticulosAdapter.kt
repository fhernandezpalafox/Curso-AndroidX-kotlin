package Adaptadores

import Entidades.Articulo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin_apirest.R
import io.sulek.ssml.OnSwipeListener
import io.sulek.ssml.SimpleSwipeMenuLayout


class ArticulosAdapter(private val articuloModel: List<Articulo>) :
    RecyclerView.Adapter<ArticulosAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lista, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val nombre = articuloModel[position].nombre
        val descripcion = articuloModel[position].descripcion

        holder.titulo.text = nombre
        holder.descripcion.text = descripcion
        holder.contenedor.setOnSwipeListener(object : OnSwipeListener {
            override fun onSwipe(isExpanded: Boolean) {
                articuloModel[position].isExpanded = isExpanded
            }
        })
        holder.contenedor.apply(articuloModel[position].isExpanded)

        //holder.btnEditar.setOnClickListener()
        //holder.btnEliminar.setOnClickListener()

    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int {
        return articuloModel.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val contenedor  =  v.findViewById<View>(R.id.swipeContainer) as SimpleSwipeMenuLayout

        val titulo: TextView = v.findViewById<View>(R.id.lblTitulo) as TextView
        val descripcion: TextView = v.findViewById<View>(R.id.lblDescripcion) as TextView

        val btnEditar =  v.findViewById<View>(R.id.btnEditar) as FrameLayout
        val btnEliminar =  v.findViewById<View>(R.id.btnEliminar) as FrameLayout


    }
}
