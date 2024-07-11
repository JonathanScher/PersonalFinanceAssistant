package com.example.personalfinanceassistant.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.personalfinanceassistant.ui.theme.PersonalFinanceAssistantTheme
import com.example.personalfinanceassistant.viewmodel.MainViewModel
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

@Composable
fun MainView(
    signInClient: GoogleSignInClient,
    onSignInResult: (Task<GoogleSignInAccount>) -> Unit
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "initialScreen") {
        composable("initialScreen") { InitialScreen(navController, signInClient, onSignInResult) }
        composable("a1Screen") { A1Screen() }
    }
}

@Composable
fun A1Screen(mainViewModel: MainViewModel = viewModel()) {
    val cellValue by mainViewModel.cellValue.observeAsState("Loading...")

    PersonalFinanceAssistantTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Cell A1: $cellValue")
                Button(onClick = { mainViewModel.fetchCellValue() }) {
                    Text("Refresh")
                }
            }
        }
    }
}
