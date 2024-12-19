package com.example.customalertdialog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), CustomDialogFragment.DialogListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Random Image Setup
        val randomImage = findViewById<ImageView>(R.id.randomImage)
        val images = listOf(R.drawable.image1, R.drawable.image2, R.drawable.image3)
        randomImage.setImageResource(images.random())

        // Button to open the dialog
        findViewById<Button>(R.id.loginButton).setOnClickListener {
            val dialog = CustomDialogFragment()
            dialog.show(supportFragmentManager, "CustomDialog")
        }
    }

    // Handle SignIn - Display Toast Message
    override fun onSignIn(username: String, password: String) {
        Toast.makeText(this, "Signed In with Username: $username", Toast.LENGTH_SHORT).show()
    }

    // Handle SignUp - Start the SignUpActivity
    override fun onSignUp() {
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }
}
