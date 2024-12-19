package com.example.recyclerviewmoviesdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewMovieName: TextView = view.findViewById(R.id.textViewMovieName)
        val imageViewMoviePoster: ImageView = view.findViewById(R.id.imageViewMoviePoster)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.textViewMovieName.text = movie.name
        holder.imageViewMoviePoster.setImageResource(movie.imageResId)


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movieName", movie.name)
                putExtra("movieImageResId", movie.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = movies.size
}
