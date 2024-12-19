package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    lateinit var editTextName: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSave: Button
    lateinit var buttonLoad: Button


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)


        editTextName = findViewById(R.id.editTextName)
        editTextPassword = findViewById(R.id.editTextPassword)
        buttonSave = findViewById(R.id.buttonSave)
        buttonLoad = findViewById(R.id.buttonLoad)


        buttonSave.setOnClickListener {
            when {
                editTextName.text.isEmpty() -> {
                    Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                }
                editTextPassword.text.isEmpty() -> {
                    Toast.makeText(this, "Please enter a password", Toast.LENGTH_SHORT).show()
                }
                else -> {

                    val editor = sharedPreferences.edit()
                    editor.putString("name", editTextName.text.toString())
                    editor.putString("password", editTextPassword.text.toString())
                    editor.apply()
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonLoad.setOnClickListener {
            when {
                sharedPreferences.contains("name") && sharedPreferences.contains("password") -> {
                    val name = sharedPreferences.getString("name", "")
                    val password = sharedPreferences.getString("password", "")
                    editTextName.setText(name)
                    editTextPassword.setText(password)
                    Toast.makeText(this, "Data Loaded", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
