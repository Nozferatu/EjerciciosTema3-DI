package com.cmj.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ItemPokemonBinding

class PokemonAdapter(
    private val listaPokemon: MutableList<Pokemon>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {
    inner class PokemonViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemPokemonBinding.bind(view)

        fun setListener(pokemon: Pokemon){
            binding.root.setOnLongClickListener {
                listener.onLongClick(pokemon)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        return PokemonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemon = listaPokemon[position]

        holder.setListener(pokemon)

        holder.binding.apply {
            nombre.text = pokemon.nombre
            checkbox.isChecked = pokemon.atrapado
            checkbox.setOnCheckedChangeListener{ _, isChecked ->
                if(isChecked){
                    pokemon.atrapado = true
                    listener.onPokemonCaptured(pokemon)
                }else{
                    pokemon.atrapado = false
                    listener.onPokemonReleased(pokemon)
                }
            }
        }
    }

    override fun getItemCount() = listaPokemon.size

    fun addPokemon(pokemon: Pokemon){
        listaPokemon.add(pokemon)
        notifyItemInserted(listaPokemon.size - 1)
    }

    fun removePokemon(pokemon: Pokemon){
        listaPokemon.remove(pokemon)
        notifyItemRemoved(listaPokemon.indexOf(pokemon))
    }
}