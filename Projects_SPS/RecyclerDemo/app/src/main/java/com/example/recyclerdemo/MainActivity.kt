package com.example.recyclerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerDemo.VersionAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    val movieList = arrayOf(
        "Inception", "The Matrix", "The Shawshank Redemption",
        "Interstellar", "Parasite", "The Dark Knight",
        "Fight Club", "Forrest Gump", "Pulp Fiction",
        "The Godfather", "Gladiator", "Avatar",
        "Titanic", "The Avengers", "Joker",
        "Coco", "Toy Story", "Star Wars",
        "Harry Potter", "The Lord of the Rings", "Inception", "The Matrix", "The Shawshank Redemption",
        "Interstellar", "Parasite", "The Dark Knight",
        "Fight Club", "Forrest Gump", "Pulp Fiction",
        "The Godfather", "Gladiator", "Avatar",
        "Titanic", "The Avengers", "Joker",
        "Coco", "Toy Story", "Star Wars",
        "Harry Potter", "The Lord of the Rings"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = VersionAdapter(movieList)
    }
}