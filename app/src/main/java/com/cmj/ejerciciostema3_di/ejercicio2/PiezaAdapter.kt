package com.cmj.ejerciciostema3_di.ejercicio2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ItemPiezaBinding

class PiezaAdapter(var listaPiezas: MutableList<Pieza>) :
    RecyclerView.Adapter<PiezaAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemPiezaBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pieza, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaPiezas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pieza = listaPiezas[position]

        holder.binding.fotoIV.setImageResource(pieza.imagen)
        holder.binding.nombreTV.text = pieza.nombre
    }
}
