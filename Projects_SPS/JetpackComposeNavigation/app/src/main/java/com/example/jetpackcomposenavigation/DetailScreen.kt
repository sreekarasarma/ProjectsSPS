package com.example.jetpackcomposenavigation

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(message: String?) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Detail Screen") })
        },
        content = {
            Text("Received message: $message")
        }
    )
}
