package com.example.loginregistrationdemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var editTextUsername: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSignUp: Button
    lateinit var buttonLogin: Button

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        // Initialize views
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSignUp = findViewById(R.id.buttonSignUp)
        buttonLogin = findViewById(R.id.buttonLogin)

        // Button listeners
        buttonSignUp.setOnClickListener {
            // Navigate to Register Activity
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        buttonLogin.setOnClickListener {
            val storedUsername = sharedPreferences.getString("username", "")
            val storedPassword = sharedPreferences.getString("password", "")

            when {
                editTextUsername.text.toString() == storedUsername && editTextPassword.text.toString() == storedPassword -> {
                    // Successful login
                    Toast.makeText(this, "Welcome ${storedUsername}", Toast.LENGTH_SHORT).show()
                    // Navigate to the welcome page or another activity
                    startActivity(Intent(this, WelcomeActivity::class.java))
                }
                else -> {
                    // Invalid login
                    Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
