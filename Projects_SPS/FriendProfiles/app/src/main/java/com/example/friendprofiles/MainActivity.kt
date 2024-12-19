package com.example.friendprofiles

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val profileNames = arrayOf("Karthik", "Anirudh", "Shashank", "Alekya", "Aadilakshmi")
        val profileImages = arrayOf(
            R.drawable.profile1,
            R.drawable.profile2,
            R.drawable.profile3,
            R.drawable.profile4,
            R.drawable.profile5
        )


        for (i in profileNames.indices) {
            val nameTextView = findViewById<TextView>(resources.getIdentifier("friend_name${i + 1}", "id", packageName))
            val imageView = findViewById<ImageView>(resources.getIdentifier("profile_image${i + 1}", "id", packageName))

            nameTextView.text = profileNames[i]
            imageView.setImageResource(profileImages[i])
        }
    }
}
