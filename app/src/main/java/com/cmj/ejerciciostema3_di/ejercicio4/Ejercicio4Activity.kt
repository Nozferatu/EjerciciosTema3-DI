package com.cmj.ejerciciostema3_di.ejercicio4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ActivityEjercicio4Binding
import com.cmj.recyclerview.OnClickListener
import com.cmj.recyclerview.Pokemon
import com.cmj.recyclerview.PokemonAdapter

class Ejercicio4Activity : AppCompatActivity(), OnClickListener {
    private val contexto = this
    private lateinit var binding: ActivityEjercicio4Binding
    private lateinit var pokemonAdapter: PokemonAdapter
    private lateinit var capturadosAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        pokemonAdapter = PokemonAdapter(mutableListOf(), this)
        capturadosAdapter = PokemonAdapter(mutableListOf(), this)

        with(binding){
            recyclerViewPokemon.apply {
                layoutManager = LinearLayoutManager(contexto)
                adapter = pokemonAdapter
            }

            recyclerViewPokemonCapturado.apply {
                layoutManager = LinearLayoutManager(contexto)
                adapter = capturadosAdapter
            }

            botonAdd.setOnClickListener {
                if(aniadirPokemonET.text.toString().isNotEmpty()){
                    val pokemon = Pokemon(aniadirPokemonET.text.toString(), 100, "Elétrcico", 1)

                    addPokemon(pokemon)

                    aniadirPokemonET.text?.clear()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){
        val data = mutableListOf(
            Pokemon("Pikachu", 100, "Eléctrico", 1),
            Pokemon("Charmander", 100, "Fuego", 1),
            Pokemon("Squirtle", 100, "Agua", 1),
            Pokemon("Bulbasaur", 100, "Planta", 1, true),
//            Pokemon("Pidgey", 100, "Volador", 1),
//            Pokemon("Rattata", 100, "Normal", 1),
//            Pokemon("Geodude", 100, "Roca", 1),
//            Pokemon("Gastly", 100, "Fantasma", 1),
//            Pokemon("Machop", 100, "Lucha", 1),
//            Pokemon("Abra", 100, "Psíquico", 1),
//            Pokemon("Eeevee", 100, "Normal", 1),
//            Pokemon("Magikarp", 100, "Agua", 1),
//            Pokemon("Snorlax", 100, "Normal", 1),
//            Pokemon("Mew", 100, "Psíquico", 1),
//            Pokemon("Mewtwo", 100, "Psíquico", 1)
        )

        data.forEach { pokemon ->
            addPokemon(pokemon)
        }
    }

    private fun addPokemon(pokemon: Pokemon){
        if(pokemon.atrapado){
            capturadosAdapter.addPokemon(pokemon)
        }else{
            pokemonAdapter.addPokemon(pokemon)
        }
    }

    private fun removePokemon(pokemon: Pokemon){
        val builder = AlertDialog.Builder(this)

        with(builder){
            setTitle("Eliminar Pokemon")
            setMessage("¿Estás seguro de que quieres eliminar a ${pokemon.nombre}?")
            setPositiveButton("Sí") { _, _ ->
                pokemonAdapter.removePokemon(pokemon)
            }
            setNegativeButton("No") {_, _ -> }
        }

        builder.show()
    }

    override fun onLongClick(pokemon: Pokemon) {
        removePokemon(pokemon)
    }

    override fun onPokemonCaptured(pokemon: Pokemon) {
        capturadosAdapter.addPokemon(pokemon)
        pokemonAdapter.removePokemon(pokemon)
    }

    override fun onPokemonReleased(pokemon: Pokemon) {
        pokemonAdapter.addPokemon(pokemon)
        capturadosAdapter.removePokemon(pokemon)
    }
}