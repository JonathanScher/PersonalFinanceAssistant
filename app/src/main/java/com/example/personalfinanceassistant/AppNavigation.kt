package com.example.personalfinanceassistant

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personalfinanceassistant.ui.HelloWorldScreen
import com.example.personalfinanceassistant.ui.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("hello") { HelloWorldScreen() }
    }
}
