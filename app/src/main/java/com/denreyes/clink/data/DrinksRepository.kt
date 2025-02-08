package com.denreyes.clink.data

interface DrinksRepository {
    suspend fun getDrinks(): NetworkResult<List<Drink>>
    suspend fun fetchDrinkById(id: String): NetworkResult<Drink>
}