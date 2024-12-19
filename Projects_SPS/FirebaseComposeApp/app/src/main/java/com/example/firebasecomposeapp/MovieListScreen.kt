package com.example.firebasecomposeapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun MovieListScreen(movieList: List<MovieDetails>, onAddNew: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn {
            items(movieList.size) { index ->
                val movie = movieList[index]
                val backgroundColor = Color((0xFF000000 + (0x00FFFFFF * Math.random()).toLong()).toInt())
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    backgroundColor = backgroundColor,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {

                        AsyncImage(
                            model = movie.imageUrl,
                            contentDescription = "Movie Image",
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(text = "Name: ${movie.name}", fontSize = 16.sp)
                            Text(text = "Genre: ${movie.genre}", fontSize = 16.sp)
                            Text(text = "Director: ${movie.director}", fontSize = 16.sp)
                        }
                    }
                }
            }
        }
        Button(onClick = onAddNew, modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text("Add New Movie")
        }
    }
}
