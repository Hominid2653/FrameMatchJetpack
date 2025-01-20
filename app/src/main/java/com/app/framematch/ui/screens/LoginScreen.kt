@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("client") } // Default role is "client"

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Login",
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Welcome Back!",
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Email Field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Email Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = { /* Handle login or dismiss keyboard */ }
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Role Selection - Radio Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                RadioButton(
                    selected = selectedRole == "client",
                    onClick = { selectedRole = "client" }
                )
                Text(text = "Client", modifier = Modifier.padding(start = 8.dp))

                Spacer(modifier = Modifier.width(16.dp))

                RadioButton(
                    selected = selectedRole == "photographer",
                    onClick = { selectedRole = "photographer" }
                )
                Text(text = "Photographer", modifier = Modifier.padding(start = 8.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Login Button
            Button(
                onClick = {
                    if (email.isNotEmpty() && password.isNotEmpty()) {
                        // Assuming login logic here (replace with actual authentication)
                        // Pass the user role (e.g., "photographer" or "client")
                        // After login, navigate based on the selected role
                        if (selectedRole == "client") {
                            // Navigate to Client Home Screen
                            navController.navigate("ClientDashboard") // Update with your actual screen
                        } else {
                            // Navigate to Photographer Home Screen
                            navController.navigate("PhotographerDashboard") // Update with your actual screen
                        }
                    } else {
                        val context = null
                        Toast.makeText(
                            context, "Please fill in all fields", Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
            ) {
                Text(text = "Login", color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Sign up link
            TextButton(onClick = {
                navController.navigate("RegisterUsersScreen")  // Navigate to the RegisterUsers screen
            }) {
                Text(text = "Don't have an account? Sign Up", color = Color(0xFF1F2B6C))
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    // Provide a preview with a mock login action
    val mockNavController = rememberNavController() // Assuming you're using NavController
    LoginScreen(navController = mockNavController)
}
