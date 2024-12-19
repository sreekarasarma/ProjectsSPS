package com.example.employeelistdemo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EmployeeListScreen(viewModel: EmployeeViewModel) {
    val employees = viewModel.employees

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(employees) { employee ->
            EmployeeCard(employee = employee)
        }
    }
}

@Composable
fun EmployeeCard(employee: Employee) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${employee.name}", style = MaterialTheme.typography.body1)
            Text(text = "Email: ${employee.email}", style = MaterialTheme.typography.body2)
            Text(text = "Phone: ${employee.phone}", style = MaterialTheme.typography.body2)
            Text(text = "Designation: ${employee.designation}", style = MaterialTheme.typography.body2)
        }
    }
}
