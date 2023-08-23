package com.stefanny.pokemon.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object Detail : Screen("home/{pokemonId}") {
        fun createRoute(pokemonId: Long) = "home/$pokemonId"
    }
}
