package com.example.journeydetailsapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var sourceEditText: EditText
    private lateinit var destinationEditText: EditText
    private lateinit var datePickerButton: Button
    private lateinit var timePickerButton: Button
    private lateinit var submitButton: Button

    private var selectedDate = ""
    private var selectedTime = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sourceEditText = findViewById(R.id.sourceEditText)
        destinationEditText = findViewById(R.id.destinationEditText)
        datePickerButton = findViewById(R.id.datePickerButton)
        timePickerButton = findViewById(R.id.timePickerButton)
        submitButton = findViewById(R.id.submitButton)

        datePickerButton.setOnClickListener { showDatePicker() }
        timePickerButton.setOnClickListener { showTimePicker() }
        submitButton.setOnClickListener { submitJourneyDetails() }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(this, { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
            datePickerButton.text = selectedDate
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        TimePickerDialog(this, { _, hour, minute ->
            selectedTime = String.format("%02d:%02d", hour, minute)
            timePickerButton.text = selectedTime
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show()
    }

    private fun submitJourneyDetails() {
        val intent = Intent(this, JourneyDetailsActivity::class.java)
        intent.putExtra("source", sourceEditText.text.toString())
        intent.putExtra("destination", destinationEditText.text.toString())
        intent.putExtra("date", selectedDate)
        intent.putExtra("time", selectedTime)
        startActivity(intent)
    }
}
//explain and give step by step. Name the project CustomAlertDialog android studio kotlin program for
