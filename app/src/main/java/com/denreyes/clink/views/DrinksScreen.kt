package com.denreyes.clink.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.denreyes.clink.data.Drink
import com.denreyes.clink.viewmodel.DrinksViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinksScreen(
    onDrinkClicked: (Drink) -> Unit
) {
    val drinksViewModel: DrinksViewModel = koinViewModel()
    val drinksUIState by drinksViewModel.drinkUIState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AnimatedVisibility(
            visible = drinksUIState.isLoading
        ) {
            CircularProgressIndicator()
        }
        AnimatedVisibility(
            visible = drinksUIState.drinks.isNotEmpty()
        ) {
            DrinkList(onDrinkClicked = onDrinkClicked, drinks = drinksUIState.drinks, modifier = Modifier)
        }
        AnimatedVisibility(
            visible = drinksUIState.error != null
        ) {
            Text(text = drinksUIState.error ?: "")
        }
    }
}