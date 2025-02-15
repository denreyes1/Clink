package com.denreyes.clink.views

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.denreyes.clink.R
import com.denreyes.clink.ui.theme.avenirFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinksScreen(
    onDrinkClicked: (Drink) -> Unit
) {
    val drinksViewModel: DrinksViewModel = koinViewModel()
    val drinksUIState by drinksViewModel.drinkUIState.collectAsStateWithLifecycle()

    val categories = listOf("Gin", "Vodka", "Tequila", "Rum", "Whiskey")
    var selectedCategory by remember { mutableStateOf("Gin") } // Default selection

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text(
                            text = stringResource(id = R.string.app_name).uppercase().replace("I", "🥂"),
                            fontFamily = avenirFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            letterSpacing = 12.sp
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black),
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Handle Menu Click */ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Handle Search Click */ }) {
                        Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.White)
                    }
                }
            )
        },
        containerColor = Color.Black
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(paddingValues)
        ) {
            // Categories Row
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 16.dp)
            ) {
                items(categories) { category ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .clickable { selectedCategory = category }
                    ) {
                        Text(
                            text = category,
                            fontWeight = FontWeight.Bold,
                            color = if (category == selectedCategory) Color(0xFFFFC56B) else Color.Gray,
                            fontFamily = avenirFontFamily,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        if (category == selectedCategory) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(5.dp)
                                    .background(Color(0xFFFFC56B), shape = CircleShape)
                            )
                        }
                    }
                }
            }

            // Drinks List
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
    }
}
