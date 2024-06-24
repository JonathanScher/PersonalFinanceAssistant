package com.example.personalfinanceassistant.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalfinanceassistant.viewmodel.MainViewModel

@Composable
fun MainView(mainViewModel: MainViewModel = viewModel()) {
    val randomNumber by mainViewModel.randomNumber.collectAsState()

    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hello, number $randomNumber!")
                Button(onClick = { mainViewModel.generateRandomNumber() }) {
                    Text("Refresh")
                }
            }
        }
    }
}
