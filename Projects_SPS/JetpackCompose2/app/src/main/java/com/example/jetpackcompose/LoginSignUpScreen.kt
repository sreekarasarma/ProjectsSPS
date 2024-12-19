package com.example.jetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginSignUpScreen() {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }


    val correctName = "testuser"
    val correctPassword = "23456"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login / Sign Up",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true,
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    if (name.text == correctName && password.text == correctPassword) {
                        message = "Login Successful!"
                    } else {
                        message = "Invalid Name or Password!"
                    }
                }
            ) {
                Text("Login")
            }

            Button(
                onClick = {
                    if (name.text.isNotBlank() && password.text.isNotBlank()) {
                        message = "Sign Up Successful for ${name.text}!"
                    } else {
                        message = "Please enter valid Name and Password for Sign Up!"
                    }
                }
            ) {
                Text("Sign Up")
            }
        }

        if (message.isNotEmpty()) {
            Text(
                text = message,
                fontSize = 16.sp,
                color = if (message.contains("Successful")) MaterialTheme.colors.primary else MaterialTheme.colors.error,
                modifier = Modifier.padding(top = 16.dp),
            )
        }
    }
}
