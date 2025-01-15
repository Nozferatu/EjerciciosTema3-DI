package com.cmj.ejerciciostema3_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmj.ejerciciostema3_di.databinding.ActivityMainBinding
import com.cmj.ejerciciostema3_di.ejercicio1.Ejercicio1Activity
import com.cmj.ejerciciostema3_di.ejercicio2.Ejercicio2Activity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        with(binding){
            botonEj1.setOnClickListener {
                iniciarActividad(Ejercicio1Activity::class.java as Class<Any>)
            }

            botonEj2.setOnClickListener {
                iniciarActividad(Ejercicio2Activity::class.java as Class<Any>)
            }
        }
    }

    fun iniciarActividad(cls: Class<Any>){
        val intent = Intent(this@MainActivity, cls)
        startActivity(intent)
    }
}