package com.example.customalertdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Set the background color to black
        window.decorView.setBackgroundColor(android.graphics.Color.BLACK)
    }
}
