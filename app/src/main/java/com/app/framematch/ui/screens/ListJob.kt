@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Title
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PostJobScreen(navController: NavController) {
    var jobTitle by remember { mutableStateOf(TextFieldValue("")) }
    var jobDescription by remember { mutableStateOf(TextFieldValue("")) }
    var jobBudget by remember { mutableStateOf(TextFieldValue("")) }
    var jobLocation by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Post Job", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Job Title
            OutlinedTextField(
                value = jobTitle,
                onValueChange = { jobTitle = it },
                label = { Text("Job Title") },
                leadingIcon = { Icon(Icons.Default.Title, contentDescription = "Title") },
                modifier = Modifier.fillMaxWidth()
            )

            // Job Description
            OutlinedTextField(
                value = jobDescription,
                onValueChange = { jobDescription = it },
                label = { Text("Job Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            // Job Budget
            OutlinedTextField(
                value = jobBudget,
                onValueChange = { jobBudget = it },
                label = { Text("Budget (in KES)") },
                leadingIcon = { Icon(Icons.Default.Money, contentDescription = "Budget") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            // Job Location
            OutlinedTextField(
                value = jobLocation,
                onValueChange = { jobLocation = it },
                label = { Text("Location") },
                leadingIcon = { Icon(Icons.Default.LocationOn, contentDescription = "Location") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Submit Button
            Button(
                onClick = {
                    // Handle job submission logic here
                    navController.navigate("jobSummaryScreen") // Example navigation
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
            ) {
                Text("Submit Job", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostJobScreenPreview() {
    val navController = rememberNavController()
    PostJobScreen(navController)
}
