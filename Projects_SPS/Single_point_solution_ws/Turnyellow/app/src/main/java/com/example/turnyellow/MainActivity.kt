package com.example.turnyellow

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rootView = findViewById<ConstraintLayout>(R.id.constraintLayout)
        val button = findViewById<Button>(R.id.changeColorButton)


        button.setOnClickListener {

            rootView.setBackgroundColor(Color.YELLOW)
        }
    }
}