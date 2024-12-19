package com.example.userauthapp

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class UserDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserDB"
        private const val DATABASE_VERSION = 1

        private const val TABLE_USERS = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_PASSWORD = "password"
        private const val COLUMN_EMAIL = "email"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_USERS (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_USERNAME TEXT, " +
                "$COLUMN_PASSWORD TEXT, " +
                "$COLUMN_EMAIL TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_USERS")
        onCreate(db)
    }

    // Insert user
    fun insertUser(username: String, password: String, email: String): Long {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_USERNAME, username)
        contentValues.put(COLUMN_PASSWORD, password)
        contentValues.put(COLUMN_EMAIL, email)
        return db.insert(TABLE_USERS, null, contentValues)
    }

    // Get all users
    fun getAllUsers(): List<User> {
        val users = mutableListOf<User>()
        val db = readableDatabase
        val cursor = db.query(TABLE_USERS, null, null, null, null, null, null)

        if (cursor != null) {
            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                val username = cursor.getString(cursor.getColumnIndex(COLUMN_USERNAME))
                val password = cursor.getString(cursor.getColumnIndex(COLUMN_PASSWORD))
                val email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL))

                val user = User(id, username, password, email)
                users.add(user)
            }
            cursor.close()
        }
        return users
    }

    // Update user
    fun updateUser(id: Long, username: String, password: String, email: String): Boolean {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_USERNAME, username)
        contentValues.put(COLUMN_PASSWORD, password)
        contentValues.put(COLUMN_EMAIL, email)

        val result = db.update(TABLE_USERS, contentValues, "$COLUMN_ID = ?", arrayOf(id.toString()))
        return result > 0
    }

    // Delete user
    fun deleteUser(id: Long): Boolean {
        val db = writableDatabase
        val result = db.delete(TABLE_USERS, "$COLUMN_ID = ?", arrayOf(id.toString()))
        return result > 0
    }
}
