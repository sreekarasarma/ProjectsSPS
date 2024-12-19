package com.example.employeelistdemo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.employeelistdemo.api.RetrofitClient
import com.example.employeelistdemo.model.Employee
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class EmployeeViewModel : ViewModel() {

    val employeeList = mutableStateListOf<Employee>()

    fun getEmployees() {
        viewModelScope.launch {
            val response = fetchEmployees()
            if (response.isSuccessful) {
                employeeList.clear()
                employeeList.addAll(response.body() ?: emptyList())
            }
        }
    }

    private suspend fun fetchEmployees(): Response<List<Employee>> {
        return withContext(Dispatchers.IO) {
            RetrofitClient.apiService.getEmployees(10, 1001)
        }
    }
}
