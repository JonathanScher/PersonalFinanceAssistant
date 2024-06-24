package com.example.personalfinanceassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.personalfinanceassistant.ui.MainView
import com.example.personalfinanceassistant.ui.theme.PersonalFinanceAssistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalFinanceAssistantTheme {
                MainView()
            }
        }
    }
}
