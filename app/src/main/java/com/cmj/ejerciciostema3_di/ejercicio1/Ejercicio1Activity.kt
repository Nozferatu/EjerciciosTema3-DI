package com.cmj.ejerciciostema3_di.ejercicio1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmj.ejerciciostema3_di.R
import com.cmj.ejerciciostema3_di.databinding.ActivityEjercicio1Binding

class Ejercicio1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio1Binding
    private lateinit var contactoAdapter: ContactoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityEjercicio1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaContactos = mutableListOf(
            Contacto("Juan", 611222333, "juan@mail.com"),
            Contacto("Pedro", 611222333, "pedro@mail.com"),
            Contacto("Manolo", 611222333, "manolo@mail.com")
        )

        contactoAdapter = ContactoAdapter(listaContactos)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Ejercicio1Activity)
            adapter = contactoAdapter
        }
    }
}