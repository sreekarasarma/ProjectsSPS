package com.example.sqllitedatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: EmployeeDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = EmployeeDatabaseHelper(this)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            dbHelper.insertEmployee(Employee(name = etName.text.toString(), email = etEmail.text.toString(), phone = etPhone.text.toString()))
        }
        findViewById<Button>(R.id.btnView).setOnClickListener {
            startActivity(Intent(this, EmployeeDetailsActivity::class.java))
        }
    }
}
