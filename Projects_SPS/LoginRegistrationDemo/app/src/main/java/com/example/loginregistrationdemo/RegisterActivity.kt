package com.example.loginregistrationdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var editTextFullName: EditText
    lateinit var editTextEmail: EditText
    lateinit var editTextUsername: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonRegister: Button
    lateinit var buttonHome: Button
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        editTextFullName = findViewById(R.id.editTextFullName)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextUsername = findViewById(R.id.editTextUsername)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonRegister = findViewById(R.id.buttonRegister)
        buttonHome = findViewById(R.id.buttonHome)

        sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)


        buttonRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val fullName = editTextFullName.text.toString()
            val email = editTextEmail.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && fullName.isNotEmpty() && email.isNotEmpty()) {
                val editor = sharedPreferences.edit()
                editor.putString("username", username)
                editor.putString("password", password)
                editor.putString("fullName", fullName)
                editor.putString("email", email)
                editor.apply()

                Toast.makeText(this, "Registration Successful!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }


        buttonHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
