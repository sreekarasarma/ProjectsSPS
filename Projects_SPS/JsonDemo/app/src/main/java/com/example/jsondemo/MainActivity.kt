package com.example.jsondemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import org.json.JSONObject
import java.io.BufferedReader

class MainActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var employeeAdapter: EmployeeAdapter
    private val employeeList = mutableListOf<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = FirebaseDatabase.getInstance().reference

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        employeeAdapter = EmployeeAdapter(employeeList)
        recyclerView.adapter = employeeAdapter

        loadJsonAndSaveToFirebase()
        fetchEmployeesFromFirebase()
    }

    private fun loadJsonAndSaveToFirebase() {
        val jsonString = assets.open("employee.json").bufferedReader().use(BufferedReader::readText)
        val jsonObject = JSONObject(jsonString)
        val employeesArray = jsonObject.getJSONArray("employees")

        for (i in 0 until employeesArray.length()) {
            val employeeJson = employeesArray.getJSONObject(i)
            val employee = Employee(
                employeeJson.getString("name"),
                employeeJson.getString("email"),
                employeeJson.getString("phone"),
                employeeJson.getString("designation")
            )
            // Add employee data to Firebase
            database.child("employees").push().setValue(employee)
        }
        Toast.makeText(this, "Employees added to Firebase", Toast.LENGTH_SHORT).show()
    }

    private fun fetchEmployeesFromFirebase() {
        database.child("employees").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                employeeList.clear()
                for (employeeSnapshot in snapshot.children) {
                    val employee = employeeSnapshot.getValue(Employee::class.java)
                    employee?.let { employeeList.add(it) }
                }
                employeeAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
