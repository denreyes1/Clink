package com.denreyes.clink.data

interface DrinksRepository {
    suspend fun getDrinksByCategory(category: String): NetworkResult<List<Drink>>
    suspend fun getDrinksByIngredient(ingredient: String): NetworkResult<List<Drink>>
    suspend fun fetchDrinkById(id: String): NetworkResult<Drink>
}