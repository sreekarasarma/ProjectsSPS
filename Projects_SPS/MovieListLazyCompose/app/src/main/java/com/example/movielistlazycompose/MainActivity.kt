package com.example.movielistlazycompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movielistlazycompose.ui.theme.MovieListLazyComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieListLazyComposeTheme {
                val navController = rememberNavController()
                val movieList = remember { mutableStateListOf<Movie>() }
                NavHost(
                    navController = navController,
                    startDestination = "input_screen"
                ) {
                    composable("input_screen") {
                        InputScreen(navController, movieList)
                    }
                    composable("movie_list_screen") {
                        MovieListScreen(movieList)
                    }
                }
            }
        }
    }
}
