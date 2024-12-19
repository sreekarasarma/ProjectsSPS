package com.example.recyclerviewcricketersdemo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CricketerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cricketer_detail)

        val imageView = findViewById<ImageView>(R.id.imageViewCricketerDetail)
        val textView = findViewById<TextView>(R.id.textViewCricketerDetail)

        val cricketerName = intent.getStringExtra("name")
        val cricketerImageResId = intent.getIntExtra("imageResId", 0)

        textView.text = cricketerName
        imageView.setImageResource(cricketerImageResId)
    }
}
