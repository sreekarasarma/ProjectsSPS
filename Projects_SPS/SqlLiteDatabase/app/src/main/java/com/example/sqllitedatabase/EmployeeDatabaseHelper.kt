package com.example.sqllitedatabase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class EmployeeDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """CREATE TABLE $TABLE_EMPLOYEES (
            $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
            $COLUMN_NAME TEXT,
            $COLUMN_EMAIL TEXT,
            $COLUMN_PHONE TEXT)"""
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_EMPLOYEES")
        onCreate(db)
    }

    fun insertEmployee(employee: Employee): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, employee.name)
            put(COLUMN_EMAIL, employee.email)
            put(COLUMN_PHONE, employee.phone)
        }
        return db.insert(TABLE_EMPLOYEES, null, values)
    }

    fun getAllEmployees(): List<Employee> {
        val employeeList = mutableListOf<Employee>()
        val cursor = readableDatabase.query(TABLE_EMPLOYEES, null, null, null, null, null, null)
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
            val email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))
            val phone = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
            employeeList.add(Employee(id, name, email, phone))
        }
        cursor.close()
        return employeeList
    }

    fun updateEmployee(employee: Employee): Int {
        val values = ContentValues().apply {
            put(COLUMN_NAME, employee.name)
            put(COLUMN_EMAIL, employee.email)
            put(COLUMN_PHONE, employee.phone)
        }
        return writableDatabase.update(TABLE_EMPLOYEES, values, "$COLUMN_ID=?", arrayOf(employee.id.toString()))
    }

    fun deleteEmployee(id: Int): Int = writableDatabase.delete(TABLE_EMPLOYEES, "$COLUMN_ID=?", arrayOf(id.toString()))

    companion object {
        const val DATABASE_NAME = "employees.db"
        const val DATABASE_VERSION = 1
        const val TABLE_EMPLOYEES = "Employees"
        const val COLUMN_ID = "id"
        const val COLUMN_NAME = "name"
        const val COLUMN_EMAIL = "email"
        const val COLUMN_PHONE = "phone"
    }
}
