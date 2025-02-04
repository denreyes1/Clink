package com.denreyes.clink.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.denreyes.clink.data.Drink

@Composable
fun DrinkList(
    onDrinkClicked: (Drink) -> Unit,
    drinks: List<Drink>,
    modifier: Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(drinks) { drink ->
            DrinkListItem(
                drink = drink,
                onDrinkClicked = onDrinkClicked
            )
        }
    }
}

@Composable
fun DrinkListItem(
    drink: Drink,
    onDrinkClicked: (Drink) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clickable {
                onDrinkClicked(drink)
            }
    ) {
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