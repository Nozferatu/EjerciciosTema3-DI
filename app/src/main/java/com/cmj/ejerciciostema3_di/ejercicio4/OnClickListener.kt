package com.cmj.recyclerview

interface OnClickListener {
    fun onLongClick(pokemon: Pokemon)

    fun onPokemonCaptured(pokemon: Pokemon)
    fun onPokemonReleased(pokemon: Pokemon)
}