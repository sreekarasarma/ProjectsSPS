package com.example.animalinfoapp

import Animal
import AnimalAdapter
import DatabaseHelper
import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etAnimal: EditText
    private lateinit var etScientificName: EditText
    private lateinit var etFamily: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAnimal = findViewById(R.id.etAnimal)
        etScientificName = findViewById(R.id.etScientificName)
        etFamily = findViewById(R.id.etFamily)
        recyclerView = findViewById(R.id.recyclerView)

        dbHelper = DatabaseHelper(this)
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.btnSave).setOnClickListener { saveAnimal() }
        findViewById<Button>(R.id.btnUpdate).setOnClickListener { updateAnimal() }
        findViewById<Button>(R.id.btnDelete).setOnClickListener { deleteAnimal() }
        findViewById<Button>(R.id.btnLoad).setOnClickListener { loadAnimals() }
    }

    private fun saveAnimal() {
        val name = etAnimal.text.toString().trim()
        val scientificName = etScientificName.text.toString().trim()
        val family = etFamily.text.toString().trim()

        if (name.isEmpty() || scientificName.isEmpty() || family.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val values = ContentValues().apply {
            put("name", name)
            put("scientificName", scientificName)
            put("family", family)
        }

        val db = dbHelper.writableDatabase
        db.insert("Animals", null, values)
        Toast.makeText(this, "Animal saved", Toast.LENGTH_SHORT).show()
        clearFields()
    }

    private fun updateAnimal() {
        val name = etAnimal.text.toString().trim()
        val scientificName = etScientificName.text.toString().trim()
        val family = etFamily.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter an animal name to update", Toast.LENGTH_SHORT).show()
            return
        }

        val values = ContentValues().apply {
            put("scientificName", scientificName)
            put("family", family)
        }

        val db = dbHelper.writableDatabase
        val updatedRows = db.update("Animals", values, "name=?", arrayOf(name))
        if (updatedRows > 0) {
            Toast.makeText(this, "Animal updated", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Animal not found", Toast.LENGTH_SHORT).show()
        }
        clearFields()
    }

    private fun deleteAnimal() {
        val name = etAnimal.text.toString().trim()

        if (name.isEmpty()) {
            Toast.makeText(this, "Please enter an animal name to delete", Toast.LENGTH_SHORT).show()
            return
        }

        val db = dbHelper.writableDatabase
        val deletedRows = db.delete("Animals", "name=?", arrayOf(name))
        if (deletedRows > 0) {
            Toast.makeText(this, "Animal deleted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Animal not found", Toast.LENGTH_SHORT).show()
        }
        clearFields()
    }

    private fun loadAnimals() {
        val db = dbHelper.readableDatabase
        val cursor: Cursor = db.rawQuery("SELECT * FROM Animals", null)
        val animals = mutableListOf<Animal>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val scientificName = cursor.getString(2)
                val family = cursor.getString(3)
                animals.add(Animal(id, name, scientificName, family))
            } while (cursor.moveToNext())
        }
        cursor.close()

        recyclerView.adapter = AnimalAdapter(animals)
        Toast.makeText(this, "Loaded ${animals.size} animals", Toast.LENGTH_SHORT).show()
    }

    private fun clearFields() {
        etAnimal.text.clear()
        etScientificName.text.clear()
        etFamily.text.clear()
    }
}
