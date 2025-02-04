package com.denreyes.clink.viewmodel

import androidx.lifecycle.ViewModel
import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.DrinksRepositoryImpl

class DrinksViewModel(
    private val drinksRepository: DrinksRepository
): ViewModel() {

    fun getDrinks() = drinksRepository.getDrinks()
}