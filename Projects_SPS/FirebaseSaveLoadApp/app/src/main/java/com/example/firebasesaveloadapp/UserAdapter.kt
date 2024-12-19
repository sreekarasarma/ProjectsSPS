package com.example.firebasesaveloadapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val userList: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.nameTextView.text = user.name
        holder.numberTextView.text = user.number
        holder.emailTextView.text = user.email
        holder.passwordTextView.text = user.password

        // Change card color based on position
        when (position % 4) {
            0 -> holder.cardView.setCardBackgroundColor(holder.itemView.resources.getColor(R.color.red))
            1 -> holder.cardView.setCardBackgroundColor(holder.itemView.resources.getColor(R.color.blue))
            2 -> holder.cardView.setCardBackgroundColor(holder.itemView.resources.getColor(R.color.green))
            3 -> holder.cardView.setCardBackgroundColor(holder.itemView.resources.getColor(R.color.yellow))
        }
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val numberTextView: TextView = itemView.findViewById(R.id.numberTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
        val passwordTextView: TextView = itemView.findViewById(R.id.passwordTextView)
    }
}
