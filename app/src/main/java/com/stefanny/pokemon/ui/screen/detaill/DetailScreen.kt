package com.stefanny.pokemon.ui.screen.detaill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.stefanny.pokemon.common.UiState
import com.stefanny.pokemon.components.PokemonItem
import com.stefanny.pokemon.di.Injection
import com.stefanny.pokemon.ui.ViewModelFactory
import com.stefanny.pokemon.ui.theme.PokemonTheme

@Composable
fun DetailScreen(
    pokemonId: Long,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepository())),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getPokemonById(pokemonId)
            }
            is UiState.Success -> {
                val data = uiState.data
                DetailContent(data.imageUrl,
                    data.name,
                    data.type,
                    data.species,
                    data.height,
                    data.weight,
                    data.ability
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun DetailContent(
    imageUrl: String,
    name: String,
    type: String,
    species: String,
    height: String,
    weight: String,
    ability: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(350.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp))
                )
            }
            Column {
                Text(
                    text = "Name",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray))
            Column {
                Text(
                    text = "Type",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = type,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray))
            Column {
                Text(
                    text = "Species",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = species,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray))
            Column {
                Text(
                    text = "Height",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = height,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray))
            Column {
                Text(
                    text = "Weight",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = weight,
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .background(Color.LightGray))
            Column {
                Text(
                    text = "Ability",
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }
            Column {
                Text(
                    text = ability,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonListItemPreview() {
    PokemonTheme {
        PokemonItem("Pikachu",
            "Eletric", "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png")
    }
}