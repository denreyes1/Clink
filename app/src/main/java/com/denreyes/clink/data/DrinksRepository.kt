package com.denreyes.clink.data

interface DrinksRepository {
    fun getDrinks(): List<Drink>
}