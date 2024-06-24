package com.example.personalfinanceassistant.repository

import com.example.personalfinanceassistant.model.RandomNumber
import kotlin.random.Random

class RandomRepository {
    fun getRandomNumber(): RandomNumber {
        return RandomNumber(Random.nextInt(100))
    }

}