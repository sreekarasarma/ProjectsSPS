package com.example.jetpackcomposenavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeNavigationApp()
        }
    }
}

@Composable
fun JetpackComposeNavigationApp() {
    val navController = rememberNavController() // Initialize NavController


    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("detail/{message}") { backStackEntry ->

            DetailScreen(message = backStackEntry.arguments?.getString("message"))
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}
