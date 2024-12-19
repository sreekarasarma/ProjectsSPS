package com.example.roomdatabase.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roomdatabase.Employee
import com.example.roomdatabase.EmployeeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EmployeeScreen(viewModel: EmployeeViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }
    var salary by remember { mutableStateOf("") }
    val employees = viewModel.employees

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = designation,
            onValueChange = { designation = it },
            label = { Text("Designation") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = salary,
            onValueChange = { salary = it },
            label = { Text("Salary") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (name.isNotEmpty() && designation.isNotEmpty() && salary.isNotEmpty()) {
                    viewModel.insertEmployee(
                        Employee(name = name, designation = designation, salary = salary)
                    )
                    name = ""
                    designation = ""
                    salary = ""
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add Employee")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(employees.size) { index ->
                EmployeeItem(employee = employees[index], onDelete = { viewModel.deleteEmployee(it) })
            }
        }
    }
}

@Composable
fun EmployeeItem(employee: Employee, onDelete: (Employee) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "Name: ${employee.name}")
                Text(text = "Designation: ${employee.designation}")
                Text(text = "Salary: ${employee.salary}")
            }
            Button(onClick = { onDelete(employee) }) {
                Text("Delete")
            }
        }
    }
}
