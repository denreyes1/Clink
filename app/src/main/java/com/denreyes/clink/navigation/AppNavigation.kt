package com.denreyes.clink.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.denreyes.clink.views.DrinkDetailsScreen
import com.denreyes.clink.views.DrinksScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.DrinksScreen.route
    ){
        composable(Screens.DrinksScreen.route){
            DrinksScreen(
                onDrinkClicked =
                {
                    navController.navigate(Screens.DrinkDetailsScreen.route)
                }
            )
        }
        composable(Screens.DrinkDetailsScreen.route) {
            DrinkDetailsScreen(
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
    }
}