package com.example.recyclerviewcricketersdemo

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CricketerAdapter(private val cricketers: List<Cricketer>) :
    RecyclerView.Adapter<CricketerAdapter.CricketerViewHolder>() {

    class CricketerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageViewCricketer: ImageView = view.findViewById(R.id.imageViewCricketer)
        val textViewCricketerName: TextView = view.findViewById(R.id.textViewCricketerName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CricketerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return CricketerViewHolder(view)
    }

    override fun onBindViewHolder(holder: CricketerViewHolder, position: Int) {
        val cricketer = cricketers[position]
        holder.textViewCricketerName.text = cricketer.name
        holder.imageViewCricketer.setImageResource(cricketer.imageResId)

        holder.imageViewCricketer.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, CricketerDetailActivity::class.java).apply {
                putExtra("name", cricketer.name)
                putExtra("imageResId", cricketer.imageResId)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = cricketers.size
}
