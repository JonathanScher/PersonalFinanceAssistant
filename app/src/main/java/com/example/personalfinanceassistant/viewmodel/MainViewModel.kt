package com.example.personalfinanceassistant.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.personalfinanceassistant.model.RandomNumber
import com.example.personalfinanceassistant.repository.RandomRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val dataRepository = RandomRepository(application.applicationContext)

    private val _randomNumber = MutableStateFlow(dataRepository.getRandomNumber().randomNumber)
    val randomNumber: StateFlow<Int> = _randomNumber

    fun generateRandomNumber() {
        viewModelScope.launch {
            val dataModel: RandomNumber = dataRepository.newRandomNumber()
            _randomNumber.value = dataModel.randomNumber
        }
    }
}
