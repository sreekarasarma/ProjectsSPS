package com.example.employeelistdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.employeelistdemo.ui.EmployeeCard
import com.example.employeelistdemo.ui.theme.EmployeeListDemoTheme
import com.example.employeelistdemo.viewmodel.EmployeeViewModel

class MainActivity : ComponentActivity() {
    private val employeeViewModel: EmployeeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmployeeListDemoTheme {
                // Fetch employees when the screen is created
                LaunchedEffect(true) {
                    employeeViewModel.getEmployees()
                }
                Surface(color = MaterialTheme.colorScheme.background) {
                    EmployeeListScreen(employeeViewModel)
                }
            }
        }
    }
}

@Composable
fun EmployeeListScreen(viewModel: EmployeeViewModel) {
    val employeeList = viewModel.employeeList.observeAsState(listOf())

    LazyColumn {
        items(employeeList.value) { employee ->
            EmployeeCard(employee)
        }
    }
}
