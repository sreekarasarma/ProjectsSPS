package com.example.favmoviesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.viewMovies)
        button.setOnClickListener {

            Toast.makeText(this, "Click on 'My Fav Movies' from the menu!", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.fav_movies -> {

                showMoviesList()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showMoviesList() {
        val movies = listOf("Inception", "The Dark Knight", "Interstellar", "Avatar", "Titanic")
        val moviesList = movies.joinToString(", ")
        Toast.makeText(this, "Top 5 Movies: $moviesList", Toast.LENGTH_LONG).show()
    }
}
