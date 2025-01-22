package com.cmj.ejerciciostema3_di.ejercicio3

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ActivityEjercicio3Binding

class Ejercicio3Activity : AppCompatActivity(), OnClickListener {
    private val contexto = this
    private lateinit var binding: ActivityEjercicio3Binding
    private lateinit var humanoAdapter: HumanoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        humanoAdapter = HumanoAdapter(mutableListOf(), this)

        with(binding){
            botonAgregarHumano.setOnClickListener {
                val nombre = nombreET.text.toString()
                val edad = edadET.text.toString()

                if(nombre.isNotEmpty()){
                    if(edad.isNotEmpty()){
                        val humano = Humano(nombre, edad.toInt())
                        addHumano(humano)
                        hacerTostada(contexto, "Humano agregado")
                    }else hacerTostada(contexto, "Falta ponerle una edad")
                }else hacerTostada(contexto, "Falta ponerle un nombre")
            }

            recyclerView.apply {
                layoutManager = LinearLayoutManager(contexto)
                adapter = humanoAdapter
            }
        }
    }

    override fun onStart() {
        super.onStart()
        getData()
    }

    private fun getData(){
        Log.d("Ejercicio3", "Añadiendo humanos onStart")
        val data = mutableListOf(
            Humano("Pablo", 10),
            Humano("Federico", 25),
            Humano("Reynaldo", 33)
        )

        data.forEach { humano ->
            addHumano(humano)
        }
    }

    private fun addHumano(humano: Humano){
        Log.d("Ejercicio3", "Añadiendo humano $humano")
        humanoAdapter.addHumano(humano)
    }

    private fun removeHumano(humano: Humano){
        val builder = AlertDialog.Builder(this)

        with(builder){
            setTitle("Eliminar humano")
            setMessage("¿Estás seguro de que quieres eliminar a ${humano.nombre}?")
            setPositiveButton("Sí") { _, _ ->
                humanoAdapter.removeHumano(humano)
                hacerTostada(contexto, "Humano eliminado")
            }
            setNegativeButton("No") {_, _ -> }
        }

        builder.show()
    }

    override fun onLongClick(humano: Humano) {
        removeHumano(humano)
    }

    private fun hacerTostada(contexto: Context, mensaje: String, duracion: Int = Toast.LENGTH_SHORT){
        Toast.makeText(
            contexto,
            mensaje,
            duracion
        ).show()
    }
}