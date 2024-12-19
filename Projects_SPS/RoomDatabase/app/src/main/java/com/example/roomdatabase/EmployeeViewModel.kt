package com.example.roomdatabase

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EmployeeViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = EmployeeDatabase.getDatabase(application).employeeDao()
    private var _employees = mutableStateListOf<Employee>()
    val employees: List<Employee> get() = _employees

    init {
        fetchEmployees()
    }

    private fun fetchEmployees() {
        viewModelScope.launch(Dispatchers.IO) {
            _employees.clear()
            _employees.addAll(dao.getAllEmployees())
        }
    }

    fun insertEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(employee)
            fetchEmployees()
        }
    }

    fun deleteEmployee(employee: Employee) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.delete(employee)
            fetchEmployees()
        }
    }
}
