package Adaptadores

import Entidades.Articulo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appkotlin_apirest.R


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
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
    }

    override fun getItemCount(): Int {
        return articuloModel.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val titulo: TextView = v.findViewById<View>(R.id.lblTitulo) as TextView
        val descripcion: TextView = v.findViewById<View>(R.id.lblDescripcion) as TextView

    }
}
