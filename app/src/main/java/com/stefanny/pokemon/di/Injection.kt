package com.stefanny.pokemon.di

import com.stefanny.pokemon.data.PokemonRepository

object Injection {
    fun provideRepository(): PokemonRepository {
        return PokemonRepository.getInstance()
    }
}