package com.denreyes.clink.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.denreyes.clink.data.Drink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinksScreen(onDrinkClicked: (Drink) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Drinks")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.
                    primary,
                )
            )
        },
        content = { paddingValues ->
            DrinkList(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                onDrinkClicked = onDrinkClicked
            )
        }
    )
}