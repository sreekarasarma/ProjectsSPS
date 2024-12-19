package com.example.journeydetailsapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JourneyDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_details)

        val source = intent.getStringExtra("source")
        val destination = intent.getStringExtra("destination")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")

        findViewById<TextView>(R.id.sourceTextView).text = "Source: $source"
        findViewById<TextView>(R.id.destinationTextView).text = "Destination: $destination"
        findViewById<TextView>(R.id.dateTextView).text = "Date: $date"
        findViewById<TextView>(R.id.timeTextView).text = "Time: $time"
    }
}
