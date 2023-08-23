package com.stefanny.pokemon.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.stefanny.pokemon.data.PokemonRepository
import com.stefanny.pokemon.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: PokemonRepository) : ViewModel() {

    private val _groupedPokemon = MutableStateFlow(
        repository.getPokemon()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedPokemon: StateFlow<Map<Char, List<Pokemon>>> get() = _groupedPokemon

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query
    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedPokemon.value = repository.searchPokemon(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }
}