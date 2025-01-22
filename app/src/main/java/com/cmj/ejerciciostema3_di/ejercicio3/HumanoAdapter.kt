package com.cmj.ejerciciostema3_di.ejercicio3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ItemHumanoBinding

class HumanoAdapter(
    private val listaHumanos: MutableList<Humano>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<HumanoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemHumanoBinding.bind(view)

        fun setListener(humano: Humano){
            binding.root.setOnLongClickListener {
                listener.onLongClick(humano)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_humano, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaHumanos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val humano = listaHumanos[position]

        holder.setListener(humano)
        holder.binding.apply {
            nombreTV.text = humano.nombre
            edadTV.text = humano.edad.toString()
        }
    }

    fun addHumano(humano: Humano){
        listaHumanos.add(humano)
        notifyDataSetChanged()
    }

    fun removeHumano(humano: Humano){
        listaHumanos.remove(humano)
        notifyDataSetChanged()
    }
}