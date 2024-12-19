package com.example.openwebsites

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnHimalayan: Button
    private lateinit var btnZara: Button
    private lateinit var btnRedJeep: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnHimalayan = findViewById(R.id.btnHimalayan)
        btnZara = findViewById(R.id.btnZara)
        btnRedJeep = findViewById(R.id.btnRedJeep)


        btnHimalayan.setOnClickListener { openWebsite("https://www.royalenfield.com/in/en/motorcycles/himalayan/") }
        btnZara.setOnClickListener { openWebsite("https://www.zara.com/") }
        btnRedJeep.setOnClickListener { openWebsite("https://www.jeep.com/wrangler.html") }
    }


    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}