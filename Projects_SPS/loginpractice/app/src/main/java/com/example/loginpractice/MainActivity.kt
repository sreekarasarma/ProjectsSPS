package com.example.loginpractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var usernameField: EditText
    private lateinit var passwordField: EditText
    private lateinit var signInButton: Button
    private lateinit var signUpButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usernameField = findViewById(R.id.usernameField)
        passwordField = findViewById(R.id.passwordField)
        signInButton = findViewById(R.id.signInButton)
        signUpButton = findViewById(R.id.signUpButton)


        signInButton.setOnClickListener { handleSignIn() }
        signUpButton.setOnClickListener { goToSignUp() }
    }

    private fun handleSignIn() {
        val username = usernameField.text.toString()
        val password = passwordField.text.toString()


        if (username == "testuser" && password == "password123") {
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        } else {
            Toast.makeText(this, "User does not exist. Please sign up.", Toast.LENGTH_SHORT).show()
            goToSignUp()
        }
    }

    private fun goToSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
