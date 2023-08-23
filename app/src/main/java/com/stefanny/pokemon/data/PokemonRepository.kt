package com.stefanny.pokemon.data

import com.stefanny.pokemon.model.Pokemon
import com.stefanny.pokemon.model.PokemonData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PokemonRepository {

    private val pokemon = mutableListOf<Pokemon>()

    init {
        if (pokemon.isEmpty()) {
            PokemonData.pokemon.forEach {
                pokemon.add(Pokemon(it.pokemonId, it.name, it.imageUrl, it.type, it.species, it.height, it.weight, it.ability))
            }
        }
    }

    fun getPokemonById(pokemonId: Long): Pokemon {
        return pokemon.first {
            it.pokemonId == pokemonId
        }
    }

    fun getPokemon(): List<Pokemon> {
        return PokemonData.pokemon
    }

    fun searchPokemon(query: String): List<Pokemon>{
        return PokemonData.pokemon.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: PokemonRepository? = null

        fun getInstance(): PokemonRepository =
            instance ?: synchronized(this) {
                PokemonRepository().apply {
                    instance = this
                }
            }
    }
}