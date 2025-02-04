package com.denreyes.clink.navigation

sealed class Screens(val route: String) {
    object DrinksScreen : Screens("drinks")
    object DrinkDetailsScreen : Screens("drinkDetails")
}