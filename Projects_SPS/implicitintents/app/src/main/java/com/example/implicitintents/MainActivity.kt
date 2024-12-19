package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var callDriverButton: Button
    private lateinit var dialDriverButton: Button
    private lateinit var browseDriverButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadViews()
        setListeners()
    }

    private fun loadViews() {
        callDriverButton = findViewById(R.id.callDriverButton)
        dialDriverButton = findViewById(R.id.dialDriverButton)
        browseDriverButton = findViewById(R.id.browseDriverButton)
    }

    private fun setListeners() {
        callDriverButton.setOnClickListener { handleButtonClick("call") }
        dialDriverButton.setOnClickListener { handleButtonClick("dial") }
        browseDriverButton.setOnClickListener { handleButtonClick("browse") }
    }

    private fun handleButtonClick(action: String) {
        val driverNumber = "9182461554"
        when (action) {
            "call" -> {
                val callIntent = Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$driverNumber")
                }
                startIntent(callIntent)
            }
            "dial" -> {
                val dialIntent = Intent(Intent.ACTION_DIAL).apply {
                    data = Uri.parse("tel:$driverNumber")
                }
                startIntent(dialIntent)
            }
            "browse" -> {
                val browseIntent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://www.google.com")
                }
                startIntent(browseIntent)
            }
        }
    }

    private fun startIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}