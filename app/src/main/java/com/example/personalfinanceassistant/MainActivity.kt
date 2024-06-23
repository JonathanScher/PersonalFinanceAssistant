package com.example.personalfinanceassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var randomNumber by remember { mutableIntStateOf(Random.nextInt(100)) }

    MaterialTheme {
        Surface {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Hello, number $randomNumber!")
                Button(onClick = {
                    randomNumber = Random.nextInt(100)
                }) {
                    Text(stringResource(R.string.refresh))
                }
            }
        }
    }
}
