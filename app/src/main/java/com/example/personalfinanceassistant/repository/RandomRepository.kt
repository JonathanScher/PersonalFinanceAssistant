package com.example.personalfinanceassistant.repository

import com.example.personalfinanceassistant.model.RandomNumber
import kotlin.random.Random
import android.content.Context

class RandomRepository (context: Context) {
    fun getRandomNumber(): RandomNumber {
        val number = retrieveRandomNumber()
        if (number.randomNumber == -1) {
            return newRandomNumber()
        }
        return number
    }

    fun newRandomNumber(): RandomNumber {
        val number = RandomNumber(Random.nextInt(100))
        saveRandomNumber(number.randomNumber)
        return number
    }

    private val sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    private fun saveRandomNumber(number: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_RANDOM_NUMBER, number)
        editor.apply()
    }

    private fun retrieveRandomNumber(): RandomNumber {
        val number = sharedPreferences.getInt(KEY_RANDOM_NUMBER, -1)
        return RandomNumber(number)
    }

    companion object {
        private const val PREFS_NAME = "random_number_prefs"
        private const val KEY_RANDOM_NUMBER = "key_random_number"
    }

}