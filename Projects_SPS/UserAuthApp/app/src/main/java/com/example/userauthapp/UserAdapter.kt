package com.example.userauthapp

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val cursor: Cursor) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (!cursor.moveToPosition(position)) return
        holder.username.text = cursor.getString(cursor.getColumnIndexOrThrow("username"))
        holder.email.text = cursor.getString(cursor.getColumnIndexOrThrow("email"))
    }

    override fun getItemCount(): Int = cursor.count

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username: TextView = view.findViewById(R.id.tvUsername)
        val email: TextView = view.findViewById(R.id.tvEmail)
    }
}
