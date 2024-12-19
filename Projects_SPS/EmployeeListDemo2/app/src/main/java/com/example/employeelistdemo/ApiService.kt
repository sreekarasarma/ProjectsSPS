package com.example.employeelistdemo.api

import com.example.employeelistdemo.model.Employee
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("employee")
    suspend fun getEmployees(
        @Query("noofRecords") numberOfRecords: Int,
        @Query("idStarts") idStarts: Int
    ): Response<List<Employee>>
}
