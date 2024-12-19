package com.example.recyclerviewmoviesdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class MovieDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val imageView = findViewById<ImageView>(R.id.imageViewMovieDetail)
        val textView = findViewById<TextView>(R.id.textViewMovieDetail)

        // Receive data from Intent
        val movieName = intent.getStringExtra("movieName")
        val movieImageResId = intent.getIntExtra("movieImageResId", 0)

        textView.text = movieName
        imageView.setImageResource(movieImageResId)
    }
}
