package com.example.sqlitedemo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sqllitedatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: EmployeeDatabaseHelper
    private lateinit var employeeAdapter: EmployeeAdapter
    private var currentEmployeeId: Long = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)

        dbHelper = EmployeeDatabaseHelper(this)

        // Save Button
        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                val employee = Employee(name = name, email = email, phone = phone)
                val id = dbHelper.insertEmployee(employee)
                if (id > 0) {
                    Toast.makeText(this, "Employee Saved", Toast.LENGTH_SHORT).show()
                    clearFields()
                } else {
                    Toast.makeText(this, "Error saving employee", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // Update Button
        findViewById<Button>(R.id.btnUpdate).setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            val phone = etPhone.text.toString()

            if (currentEmployeeId != -1 && name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                val employee = Employee(id = currentEmployeeId, name = name, email = email, phone = phone)
                val rowsUpdated = dbHelper.updateEmployee(employee)
                if (rowsUpdated > 0) {
                    Toast.makeText(this, "Employee Updated", Toast.LENGTH_SHORT).show()
                    clearFields()
                } else {
                    Toast.makeText(this, "Error updating employee", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please select an employee to update", Toast.LENGTH_SHORT).show()
            }
        }

        // Load Button
        findViewById<Button>(R.id.btnLoad).setOnClickListener {
            val employees = dbHelper.getAllEmployees()
            if (employees.isNotEmpty()) {
                employeeAdapter = EmployeeAdapter(employees)
                val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(this)
                recyclerView.adapter = employeeAdapter
            } else {
                Toast.makeText(this, "No employees found", Toast.LENGTH_SHORT).show()
            }
        }

        // Delete Button
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val name = etName.text.toString()

            if (name.isNotEmpty()) {
                val rowsDeleted = dbHelper.deleteEmployee(name)
                if (rowsDeleted > 0) {
                    Toast.makeText(this, "Employee Deleted", Toast.LENGTH_SHORT).show()
                    clearFields()
                } else {
                    Toast.makeText(this, "Error deleting employee", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter name to delete", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearFields() {
        findViewById<EditText>(R.id.etName).text.clear()
        findViewById<EditText>(R.id.etEmail).text.clear()
        findViewById<EditText>(R.id.etPhone).text.clear()
        currentEmployeeId = -1
    }
}
