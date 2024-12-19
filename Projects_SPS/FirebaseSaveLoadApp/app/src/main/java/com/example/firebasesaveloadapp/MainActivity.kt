package com.example.firebasesaveloadapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance().reference
    private val userList = mutableListOf<User>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views
        val etName = findViewById<EditText>(R.id.etName)
        val etNumber = findViewById<EditText>(R.id.etNumber)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnLoad = findViewById<Button>(R.id.btnLoad)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Setup RecyclerView
        adapter = UserAdapter(userList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnSave.setOnClickListener {
            saveDataToFirebase(
                etName.text.toString(),
                etNumber.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString()
            )
        }

        btnLoad.setOnClickListener {
            loadDataFromFirebase()
        }
    }

    private fun saveDataToFirebase(name: String, number: String, email: String, password: String) {
        if (name.isNotEmpty() && number.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
            val user = User(name, number, email, password)
            database.child("users").push().setValue(user)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, "Failed to Save", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun loadDataFromFirebase() {
        database.child("users").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for (userSnapshot in snapshot.children) {
                    val user = userSnapshot.getValue(User::class.java)
                    if (user != null) {
                        userList.add(user)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to Load Data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
