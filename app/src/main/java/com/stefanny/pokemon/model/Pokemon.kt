package com.stefanny.pokemon.model

data class Pokemon(
    val pokemonId: Long,
    val name: String,
    val imageUrl: String,
    val type: String,
    val species: String,
    val height: String,
    val weight: String,
    val ability: String,
)