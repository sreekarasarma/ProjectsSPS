package com.example.mypersonalinformation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editName = findViewById<EditText>(R.id.editName)
        val editPhone = findViewById<EditText>(R.id.editPhone)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editDesignation = findViewById<EditText>(R.id.editDesignation)
        val submitButton = findViewById<Button>(R.id.submitButton)

        val displayName = findViewById<TextView>(R.id.displayName)
        val displayPhone = findViewById<TextView>(R.id.displayPhone)
        val displayEmail = findViewById<TextView>(R.id.displayEmail)
        val displayDesignation = findViewById<TextView>(R.id.displayDesignation)


        submitButton.setOnClickListener {

            val name = editName.text.toString().trim()
            val phone = editPhone.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val designation = editDesignation.text.toString().trim()

            displayName.text = "Name: $name"
            displayPhone.text = "Phone: $phone"
            displayEmail.text = "Email: $email"
            displayDesignation.text = "Designation: $designation"

           
        }
    }
}