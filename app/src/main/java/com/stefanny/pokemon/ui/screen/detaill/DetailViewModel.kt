package com.stefanny.pokemon.ui.screen.detaill

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stefanny.pokemon.common.UiState
import com.stefanny.pokemon.data.PokemonRepository
import com.stefanny.pokemon.model.Pokemon
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(private val repository: PokemonRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Pokemon>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Pokemon>>
        get() = _uiState

    fun getPokemonById(pokemonId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getPokemonById(pokemonId))
        }
    }
}