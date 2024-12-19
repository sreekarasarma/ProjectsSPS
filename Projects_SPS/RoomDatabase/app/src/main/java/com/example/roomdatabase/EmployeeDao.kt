package com.example.roomdatabase

import androidx.room.*

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Query("SELECT * FROM employee_table")
    fun getAllEmployees(): List<Employee>
}
