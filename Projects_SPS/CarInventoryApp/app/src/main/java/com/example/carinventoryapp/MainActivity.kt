package com.example.carinventoryapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var etCarName: EditText
    private lateinit var etCarTrackNo: EditText
    private lateinit var etCarType: EditText
    private lateinit var etCarModel: EditText
    private lateinit var btnSave: Button
    private lateinit var btnLoad: Button
    private lateinit var tvCarName: TextView
    private lateinit var tvCarTrackNo: TextView
    private lateinit var tvCarType: TextView
    private lateinit var tvCarModel: TextView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etCarName = findViewById(R.id.etCarName)
        etCarTrackNo = findViewById(R.id.etCarTrackNo)
        etCarType = findViewById(R.id.etCarType)
        etCarModel = findViewById(R.id.etCarModel)
        btnSave = findViewById(R.id.btnSave)
        btnLoad = findViewById(R.id.btnLoad)
        tvCarName = findViewById(R.id.tvCarName)
        tvCarTrackNo = findViewById(R.id.tvCarTrackNo)
        tvCarType = findViewById(R.id.tvCarType)
        tvCarModel = findViewById(R.id.tvCarModel)


        database = FirebaseDatabase.getInstance().reference

        btnSave.setOnClickListener {
            saveDataToFirebase()
        }

        btnLoad.setOnClickListener {
            loadDataFromFirebase()
        }
    }

    private fun saveDataToFirebase() {
        val carName = etCarName.text.toString()
        val carTrackNo = etCarTrackNo.text.toString()
        val carType = etCarType.text.toString()
        val carModel = etCarModel.text.toString()


        if (carName.isEmpty() || carTrackNo.isEmpty() || carType.isEmpty() || carModel.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }


        val carData = CarData(carName, carTrackNo, carType, carModel)


        database.child("cars").push().setValue(carData)
            .addOnSuccessListener {
                Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to save data: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun loadDataFromFirebase() {
        database.child("cars").get().addOnSuccessListener {
            val data = it.children.firstOrNull()
            if (data != null) {
                val carData = data.getValue(CarData::class.java)
                carData?.let {
                    tvCarName.text = "Car Name: ${it.name}"
                    tvCarTrackNo.text = "Track Number: ${it.trackNumber}"
                    tvCarType.text = "Car Type: ${it.type}"
                    tvCarModel.text = "Car Model: ${it.model}"


                    findViewById<CardView>(R.id.cardView1).visibility = View.VISIBLE
                    findViewById<CardView>(R.id.cardView2).visibility = View.VISIBLE
                    findViewById<CardView>(R.id.cardView3).visibility = View.VISIBLE
                    findViewById<CardView>(R.id.cardView4).visibility = View.VISIBLE
                }
            } else {
                Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to load data: ${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    data class CarData(
        val name: String = "",
        val trackNumber: String = "",
        val type: String = "",
        val model: String = ""
    ) {
        constructor() : this("", "", "", "")
    }
}
