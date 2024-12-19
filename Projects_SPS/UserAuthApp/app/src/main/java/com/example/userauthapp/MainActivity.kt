package com.example.userauthapp

import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: UserDatabaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    private lateinit var cursor: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = UserDatabaseHelper(this)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val etUsername = findViewById<EditText>(R.id.et_login_username)
        val etPassword = findViewById<EditText>(R.id.et_login_password)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnSignup = findViewById<Button>(R.id.btn_signup)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnUpdate = findViewById<Button>(R.id.btn_update)
        val btnDelete = findViewById<Button>(R.id.btn_delete)
        val btnLoad = findViewById<Button>(R.id.btn_load)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            cursor = dbHelper.getAllUsers()
            var isValid = false
            while (cursor.moveToNext()) {
                if (cursor.getString(1) == username && cursor.getString(2) == password) {
                    isValid = true
                    break
                }
            }
            if (isValid) Toast.makeText(this, "Welcome to the app, $username!", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "Invalid credentials!", Toast.LENGTH_SHORT).show()
        }

        btnSignup.setOnClickListener {
            Toast.makeText(this, "Redirect to Signup!", Toast.LENGTH_SHORT).show()
        }

        btnSave.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()
            val email = "dummy@example.com"
            dbHelper.addUser(username, password, email)
            Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
        }

        btnUpdate.setOnClickListener {
            dbHelper.updateUser(1, "newUser", "newPass", "newEmail@example.com")
            Toast.makeText(this, "User updated!", Toast.LENGTH_SHORT).show()
        }

        btnDelete.setOnClickListener {
            dbHelper.deleteUser(1)
            Toast.makeText(this, "User deleted!", Toast.LENGTH_SHORT).show()
        }

        btnLoad.setOnClickListener {
            loadUsers()
        }
    }

    private fun loadUsers() {
        cursor = dbHelper.getAllUsers()
        adapter = UserAdapter(cursor)
        recyclerView.adapter = adapter
    }
}
