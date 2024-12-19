package com.example.statemanagementexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleStateManagementApp()
        }
    }
}

@Composable
fun SimpleStateManagementApp() {

    val count = remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Count: ${count.value}", style = MaterialTheme.typography.h4)


        Button(onClick = { count.value += 1 }) {
            Text("Increase Count")
        }
        Button(
            onClick = { count.value -= 1 },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Decrease Count")
        }
    }
}
