package com.example.recyclerviewcricketersdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cricketerList = listOf(
            Cricketer("Virat Kohli", R.drawable.virat_kohli),
            Cricketer("MS Dhoni", R.drawable.ms_dhoni),
            Cricketer("Rohit Sharma", R.drawable.rohit_sharma),
            Cricketer("Steve Smith", R.drawable.steve_smith),
            Cricketer("Kane Williamson", R.drawable.kane_williamson)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CricketerAdapter(cricketerList)
    }
}
