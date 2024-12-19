package com.example.firebaseauthenticationdemo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class WelcomeActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        val welcomeTextView = findViewById<TextView>(R.id.tvWelcome)

        if (user != null) {
            welcomeTextView.text = "Welcome, ${user.email}"
        }
    }
}
