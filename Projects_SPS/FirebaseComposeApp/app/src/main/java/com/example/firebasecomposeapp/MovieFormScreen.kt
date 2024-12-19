package com.example.firebasecomposeapp

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.database.FirebaseDatabase

@Composable
fun MovieFormScreen(onSubmit: (MovieDetails) -> Unit) {
    var name by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf("") }
    var director by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Movie Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = genre,
            onValueChange = { genre = it },
            label = { Text("Genre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = director,
            onValueChange = { director = it },
            label = { Text("Director") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val movie = MovieDetails(name, genre, director, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaFqz0aDkWy3K6C31f5c17NM7WRc3WiLJyMg&s")
            FirebaseDatabase.getInstance().getReference("movies").push().setValue(movie)
            onSubmit(movie)
        }) {
            Text("Submit")
        }
    }
}
