package com.example.personalfinanceassistant.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalfinanceassistant.ui.theme.PersonalFinanceAssistantTheme
import com.example.personalfinanceassistant.viewmodel.MainViewModel

@Composable
fun MainView(mainViewModel: MainViewModel = viewModel()) {
    val cellValue by mainViewModel.cellValue.observeAsState("Loading...")

    MainView(
        cellValue,
        mainViewModel::fetchCellValue
    )
}

@Composable
fun MainView(cellValue: String, callback: () -> Unit) {
    PersonalFinanceAssistantTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Cell A1: $cellValue")
                Button(onClick = callback) {
                    Text("Refresh")
                }
            }
        }
    }
}

@Preview
@Composable
fun MainViewPreview() {
    MainView("Sample data") { }
}
