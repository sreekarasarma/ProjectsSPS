package com.example.timepickerdialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    private lateinit var timePickerButton: Button
    private lateinit var datePickerButton: Button
    private lateinit var selectedDateTime: TextView

    @SuppressLint("DefaultLocale", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timePickerButton = findViewById(R.id.timePickerButton)
        datePickerButton = findViewById(R.id.datePickerButton)
        selectedDateTime = findViewById(R.id.selectedDateTime)

        timePickerButton.setOnClickListener {
            val timePickerFragment = TimePickerFragment(TimePickerDialog.OnTimeSetListener { _, hour, minute ->
                val time = String.format("%02d:%02d", hour, minute)
                selectedDateTime.text = "Selected Time: $time"
            })
            timePickerFragment.show(supportFragmentManager, "timePicker")
        }

        datePickerButton.setOnClickListener { openDatePicker() }
    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    private fun openDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            val date = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay)
            selectedDateTime.text = "Selected Date: $date"
        }, year, month, day).show()
    }
}
provide step by step