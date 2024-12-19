package com.example.recyclerDemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdemo.R

class VersionAdapter(private val versionsArray: Array<String>) :
    RecyclerView.Adapter<VersionAdapter.VersionViewHolder>() {

    class VersionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewMovieName: TextView = view.findViewById(R.id.textView_movieName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VersionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return VersionViewHolder(view)
    }

    override fun onBindViewHolder(holder: VersionViewHolder, position: Int) {
        holder.textViewMovieName.text = versionsArray[position]
    }

    override fun getItemCount(): Int = versionsArray.size
}
