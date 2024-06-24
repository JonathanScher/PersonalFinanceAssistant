package com.example.personalfinanceassistant.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalfinanceassistant.model.RandomNumber
import com.example.personalfinanceassistant.repository.RandomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val dataRepository = RandomRepository()

    private val _randomNumber = MutableStateFlow(0)
    val randomNumber: StateFlow<Int> = _randomNumber

    fun generateRandomNumber() {
        viewModelScope.launch {
            val dataModel: RandomNumber = dataRepository.getRandomNumber()
            _randomNumber.value = dataModel.randomNumber
        }
    }
}
