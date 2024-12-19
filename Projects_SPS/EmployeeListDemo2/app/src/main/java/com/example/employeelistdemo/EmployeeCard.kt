package com.example.employeelistdemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.employeelistdemo.R
import com.example.employeelistdemo.model.Employee

@Composable
fun EmployeeCard(employee: Employee) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.elevatedCardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${employee.name}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Email: ${employee.email}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Phone: ${employee.phone}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Designation: ${employee.designation}", style = MaterialTheme.typography.bodyMedium)

            Image(
                painter = painterResource(id = R.drawable.placeholder),
                contentDescription = "Employee Image",
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}
