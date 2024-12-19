package com.example.lazystaggeredgridcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MovieListScreen()
            }
        }
    }
}

@Composable
fun MovieListScreen() {
    val movieList = listOf(
        Movie(
            imageResId = R.drawable.movie1,
            name = "Inception",
            genre = "Sci-Fi",
            plot = "A thief who steals corporate secrets through dream-sharing technology."
        ),
        Movie(
            imageResId = R.drawable.movie2,
            name = "The Lion King",
            genre = "Animation",
            plot = "A young lion prince flees his kingdom after the murder of his father."
        ),
        Movie(
            imageResId = R.drawable.movie3,
            name = "Avengers: Endgame",
            genre = "Action",
            plot = "After the devastating events of Avengers: Infinity War, the universe is in ruins."
        ),
        Movie(
            imageResId = R.drawable.movie4,
            name = "Harry Potter",
            genre = "Fantasy",
            plot = "A young wizard's journey begins as he attends Hogwarts School of Witchcraft and Wizardry."
        ),
        Movie(
            imageResId = R.drawable.movie5,
            name = "Toy Story",
            genre = "Animation",
            plot = "A cowboy doll is profoundly threatened and jealous when a new spaceman figure supplants him."
        ),
        Movie(
            imageResId = R.drawable.movie6,
            name = "The Godfather",
            genre = "Crime",
            plot = "The aging patriarch of an organized crime dynasty transfers control to his reluctant son."
        ),
        Movie(
            imageResId = R.drawable.movie7,
            name = "Interstellar",
            genre = "Sci-Fi",
            plot = "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."
        )
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF5F5F5)
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalItemSpacing = 12.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(movieList.size) { index ->
                MovieCard(movieList[index])
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars.add(WindowInsets(top = 8.dp)))
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = movie.imageResId),
                contentDescription = movie.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = movie.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "Genre: ${movie.genre}",
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = movie.plot,
                fontSize = 12.sp,
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieListScreen() {
    MaterialTheme {
        MovieListScreen()
    }
}
