package com.denreyes.clink.viewmodel

import androidx.lifecycle.ViewModel
import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.DrinksRepositoryImpl

class DrinksViewModel: ViewModel() {
    private val drinksRepository: DrinksRepository = DrinksRepositoryImpl()
    fun getDrinks() = drinksRepository.getDrinks()
}