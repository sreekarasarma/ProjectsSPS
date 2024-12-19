package com.example.userauthapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignupActivity : AppCompatActivity() {

    private lateinit var dbHelper: UserDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        dbHelper = UserDatabaseHelper(this)

        val etUsername = findViewById<EditText>(R.id.et_signup_username)
        val etPassword = findViewById<EditText>(R.id.et_signup_password)
        val etConfirmPassword = findViewById<EditText>(R.id.et_signup_confirm_password)
        val etEmail = findViewById<EditText>(R.id.et_signup_email)

        val btnSignup = findViewById<Button>(R.id.btn_signup)
        val btnBackToLogin = findViewById<Button>(R.id.btn_back_to_login)

        btnSignup.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()
            val email = etEmail.text.toString()

            // Validate inputs
            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Check if password and confirm password match
            if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save the user to the database
            val isInserted = dbHelper.addUser(username, password, email)
            if (isInserted) {
                Toast.makeText(this, "Registration successful!", Toast.LENGTH_SHORT).show()
                // Navigate back to login
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Registration failed, try again.", Toast.LENGTH_SHORT).show()
            }
        }

        btnBackToLogin.setOnClickListener {
            // Navigate back to the login screen
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
