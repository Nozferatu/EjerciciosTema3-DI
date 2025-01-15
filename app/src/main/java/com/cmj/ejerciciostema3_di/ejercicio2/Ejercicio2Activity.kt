package com.cmj.ejerciciostema3_di.ejercicio2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ActivityEjercicio2Binding

class Ejercicio2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding
    private lateinit var piezaAdapter: PiezaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaPiezas = mutableListOf(
            Pieza("Peón", R.drawable.peon),
            Pieza("Caballo", R.drawable.caballo),
            Pieza("Alfil", R.drawable.alfil),
            Pieza("Torre", R.drawable.torre),
            Pieza("Reina", R.drawable.reina),
            Pieza("Rey", R.drawable.rey)
        )

        piezaAdapter = PiezaAdapter(listaPiezas)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio2Activity, LinearLayoutManager.HORIZONTAL, false)
            adapter = piezaAdapter
        }
    }
}