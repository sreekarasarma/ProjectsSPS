package com.example.pixabaygallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pixabaygallery.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PixabayGalleryApp()
        }
    }
}

@Composable
fun PixabayGalleryApp(viewModel: MainViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController, viewModel)
        }
        composable("details/{imageUrl}/{tags}") { backStackEntry ->
            val imageUrl = backStackEntry.arguments?.getString("imageUrl")
            val tags = backStackEntry.arguments?.getString("tags")
            DetailScreen(imageUrl, tags)
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController, viewModel: MainViewModel) {
    val images by viewModel.images.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchImages("space") // Fetch "space" topic images
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Pixabay Gallery") }) }) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(images.size) { index ->
                val image = images[index]
                Card(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate("details/${image.largeImageURL}/${image.tags}")
                        }
                ) {
                    Column {
                        AsyncImage(
                            model = image.previewURL,
                            contentDescription = image.tags,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = image.tags,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DetailScreen(imageUrl: String?, tags: String?) {
    Scaffold(topBar = { TopAppBar(title = { Text("Details") }) }) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            AsyncImage(
                model = imageUrl,
                contentDescription = tags,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = tags ?: "No description", style = MaterialTheme.typography.h6)
        }
    }
}
