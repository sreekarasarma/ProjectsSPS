package com.example.recyclerviewmoviesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieList = listOf(
            Movie("Inception", R.drawable.inception),
            Movie("Interstellar", R.drawable.interstellar),
            Movie("The Dark Knight", R.drawable.dark_knight),
            Movie("Avatar", R.drawable.avatar),
            Movie("The Matrix", R.drawable.matrix),
            Movie("Titanic", R.drawable.titanic),
            Movie("The Avengers", R.drawable.avengers),
            Movie("Joker", R.drawable.joker)
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = MovieAdapter(movieList)
    }
}
