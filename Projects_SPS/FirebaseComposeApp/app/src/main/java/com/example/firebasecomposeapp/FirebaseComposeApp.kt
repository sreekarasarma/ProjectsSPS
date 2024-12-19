package com.example.firebasecomposeapp

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable

@Composable
fun FirebaseComposeApp() {
    var currentScreen by rememberSaveable { mutableStateOf("form") }
    var movieList by rememberSaveable { mutableStateOf(listOf<MovieDetails>()) }

    when (currentScreen) {
        "form" -> MovieFormScreen(onSubmit = { movie ->
            movieList = movieList + movie
            currentScreen = "list"
        })
        "list" -> MovieListScreen(movieList = movieList) {
            currentScreen = "form"
        }
    }
}
