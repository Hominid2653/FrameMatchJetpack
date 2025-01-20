@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun RegisterScreen(
    onRegister: (String, String, String) -> Unit, // Function to handle registration logic
    onNavigateToLogin: () -> Unit // Navigation to login if user already has an account
) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var accountType by remember { mutableStateOf("Photographer") } // default value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Text(
            text = "Create an Account",
            style = MaterialTheme.typography.headlineLarge.copy(fontSize = 24.sp),
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Username Field
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF1F2B6C),
                unfocusedBorderColor = Color(0xFF1F2B6C)
            )
        )

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF1F2B6C),
                unfocusedBorderColor = Color(0xFF1F2B6C)
            )
        )

        // Password Field
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .background(Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF1F2B6C),
                unfocusedBorderColor = Color(0xFF1F2B6C)
            )
        )

        // Account Type Selection (Radio Buttons)
        Text(
            text = "Select Account Type",
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .selectableGroup()
        ) {
            RadioButtonWithLabel(
                label = "Photographer",
                isSelected = accountType == "Photographer",
                onClick = { accountType = "Photographer" }
            )
            Spacer(modifier = Modifier.width(16.dp))
            RadioButtonWithLabel(
                label = "Client",
                isSelected = accountType == "Client",
                onClick = { accountType = "Client" }
            )
        }

        // Register Button
        Button(
            onClick = { onRegister(username, email, accountType) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
        ) {
            Text("Register", color = Color.White)
        }

        // Navigation to Login Screen if the user already has an account
        TextButton(onClick = { onNavigateToLogin() }) {
            Text("Already have an account? Login here.")
        }
    }
}

@Composable
fun RadioButtonWithLabel(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = isSelected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(selectedColor = Color(0xFF1F2B6C), unselectedColor = Color.Gray)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            color = if (isSelected) Color(0xFF1F2B6C) else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        onRegister = { username, email, accountType -> /* Handle registration logic */ },
        onNavigateToLogin = {}
    )
}
