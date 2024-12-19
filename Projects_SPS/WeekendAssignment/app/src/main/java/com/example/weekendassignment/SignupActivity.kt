package com.example.weekendassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {
    private lateinit var nameInput: EditText
    private lateinit var signupEmailInput: EditText
    private lateinit var signupPasswordInput: EditText
    private lateinit var confirmPasswordInput: EditText
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        nameInput = findViewById(R.id.nameInput)
        signupEmailInput = findViewById(R.id.signupEmailInput)
        signupPasswordInput = findViewById(R.id.signupPasswordInput)
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput)
        registerButton = findViewById(R.id.registerButton)

        val database = FirebaseDatabase.getInstance().reference.child("users")

        registerButton.setOnClickListener {
            val name = nameInput.text.toString().trim()
            val email = signupEmailInput.text.toString().trim()
            val password = signupPasswordInput.text.toString().trim()
            val confirmPassword = confirmPasswordInput.text.toString().trim()

            if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                database.child(email.replace(".", ",")).setValue(
                    mapOf(
                        "name" to name,
                        "email" to email,
                        "password" to password
                    )
                ).addOnSuccessListener {
                    Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }.addOnFailureListener {
                    Toast.makeText(this, "Error saving data", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
