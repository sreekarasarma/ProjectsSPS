package com.example.loginpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var welcomeMessage: TextView
    private lateinit var welcomeImage: ImageView
    private lateinit var homeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        welcomeMessage = findViewById(R.id.welcomeMessage)
        welcomeImage = findViewById(R.id.welcomeImage)
        homeButton = findViewById(R.id.homeButton)


        val username = intent.getStringExtra("username") ?: "User"
        welcomeMessage.text = "Welcome, $username!"


        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}