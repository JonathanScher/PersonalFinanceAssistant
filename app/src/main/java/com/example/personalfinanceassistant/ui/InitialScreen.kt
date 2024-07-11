package com.example.personalfinanceassistant.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.example.personalfinanceassistant.MainActivity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InitialScreen(
    navController: NavController,
    signInClient: GoogleSignInClient,
    onSignInResult: (Task<GoogleSignInAccount>) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Personal Finance Assistant") }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = {
                    val signInIntent = signInClient.signInIntent
 //                   (navController.context as MainActivity).startActivityForResult(signInIntent, MainActivity.RC_SIGN_IN)
                }) {
                    Text("Log in with Google")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick = { navController.navigate("a1Screen") }) {
                    Text("Go to A1")
                }
            }
        }
    }
}
