package com.denreyes.clink.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items //Important to read items instead of int
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.denreyes.clink.viewmodel.DrinksViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun DrinkList(modifier: Modifier) {
    val drinksViewModel: DrinksViewModel = viewModel()
    LazyColumn(
        modifier = modifier
    ) {
        items(drinksViewModel.getDrinks()) { drink ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(text = "Name: ${drink.strDrink}")
                    Text(text = "Category: ${drink.strCategory}")
                    Text(text = "Instructions: ${drink.strInstructions}")
                }
            }
        }
    }
}