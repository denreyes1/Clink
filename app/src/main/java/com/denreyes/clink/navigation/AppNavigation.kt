package com.denreyes.clink.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                onDrinkClicked = { drink ->
                    navController.navigate(
                        "${Screens.DrinkDetailsScreen.route}/${drink.idDrink}"
                    )
                }
            )
        }
        composable(
            route = "${Screens.DrinkDetailsScreen.route}/{drinkId}",
            arguments = listOf(
                navArgument("drinkId") {
                    type = NavType.StringType
                }
            )
        ) {
            DrinkDetailsScreen(
                onBackPressed = {
                    navController.popBackStack()
                },
                drinkId = it.arguments?.getString(
                    "drinkId"
                ) ?: ""
            )
        }
    }
}