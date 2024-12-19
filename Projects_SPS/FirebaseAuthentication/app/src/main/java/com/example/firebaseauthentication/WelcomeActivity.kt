package com.example.firebaseauthentication
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseauthentication.R

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val welcomeTextView = findViewById<TextView>(R.id.tvWelcome)
        welcomeTextView.text = "Welcome to the app, User!"
    }
}
