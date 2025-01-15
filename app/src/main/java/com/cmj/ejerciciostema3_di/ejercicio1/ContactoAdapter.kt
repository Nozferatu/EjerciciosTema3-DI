package com.cmj.ejerciciostema3_di.ejercicio1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ItemContactoBinding

class ContactoAdapter(var listaContactos: MutableList<Contacto>) :
    RecyclerView.Adapter<ContactoAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemContactoBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contacto, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = listaContactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = listaContactos[position]

        holder.binding.fotoIV.setImageResource(contacto.foto)
        holder.binding.nombreTV.text = contacto.nombre
        holder.binding.correoTV.text = contacto.correo
        holder.binding.telefonoTV.text = contacto.telefono.toString()
    }
}