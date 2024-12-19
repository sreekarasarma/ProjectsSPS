package com.example.morningeveningnight

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var rootLayout: ConstraintLayout
    private lateinit var messageTextView: TextView
    private lateinit var displayImageView: ImageView
    private lateinit var morningButton: Button
    private lateinit var eveningButton: Button
    private lateinit var nightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rootLayout = findViewById(R.id.rootLayout)
        messageTextView = findViewById(R.id.messageTextView)
        displayImageView = findViewById(R.id.displayImageView)
        morningButton = findViewById(R.id.morningButton)
        eveningButton = findViewById(R.id.eveningButton)
        nightButton = findViewById(R.id.nightButton)

        morningButton.setOnClickListener(this)
        eveningButton.setOnClickListener(this)
        nightButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.morningButton -> {
                messageTextView.text = "Good Morning!"
                displayImageView.setImageResource(R.drawable.good_morning)
                rootLayout.setBackgroundColor(Color.parseColor("#FFF8E1"))
            }
            R.id.eveningButton -> {
                messageTextView.text = "Good Evening!"
                displayImageView.setImageResource(R.drawable.good_evening)
                rootLayout.setBackgroundColor(Color.parseColor("#FFE0B2"))
                showContent()
            }
            R.id.nightButton -> {
                messageTextView.text = "Good Night!"
                displayImageView.setImageResource(R.drawable.good_night)
                rootLayout.setBackgroundColor(Color.parseColor("#C5CAE9"))
                showContent()
            }
        }
    }

    private fun showContent() {
        messageTextView.visibility = View.VISIBLE
        displayImageView.visibility = View.VISIBLE
    }
}