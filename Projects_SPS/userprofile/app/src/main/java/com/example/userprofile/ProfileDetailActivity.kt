package com.example.userprofile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail)


        val textName = findViewById<TextView>(R.id.textName)
        val textEmail = findViewById<TextView>(R.id.textEmail)
        val textPhone = findViewById<TextView>(R.id.textPhone)
        val textDesignation = findViewById<TextView>(R.id.textDesignation)
        val buttonHome = findViewById<Button>(R.id.buttonHome)


        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val designation = intent.getStringExtra("designation")

        textName.text = "Name: $name"
        textEmail.text = "Email: $email"
        textPhone.text = "Phone: $phone"
        textDesignation.text = "Designation: $designation"


        buttonHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}