package com.cmj.ejerciciostema3_di.ejercicio1

import com.cmj.ejerciciostema3_di.R

data class Contacto(
    val nombre: String = "",
    val telefono: Int = 0,
    val correo: String = "",
    val foto: Int = R.drawable.persona_default
)