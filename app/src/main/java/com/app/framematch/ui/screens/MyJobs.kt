package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.ui.components.JobCard // Import the JobCard component

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyJobsScreen(jobs: List<Job1>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Jobs") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)  // Ensure innerPadding is applied here
                .padding(16.dp)  // Additional padding if necessary
        ) {
            // Add the content for MyJobsScreen with JobCard for each job
            jobs.forEach { job ->
                JobCard(
                    job1 = job,
                    onClick = {
                        // Handle job card click
                    },
                    showApplyButton = false // Change to true if you want to show apply button
                )
                Spacer(modifier = Modifier.height(16.dp)) // Space between jobs
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyJobsScreenPreview() {
    MyJobsScreen(
        jobs = listOf(
            Job1("Wedding Photoshoot", 500, "Nairobi", "Looking for a photographer to cover a wedding.", "Open", "$500"),
            Job1("Product Photography", 200, "Mombasa", "Need product shots for an online store.", "Closed", "$200"),
            Job1("Family Portraits", 300, "Kisumu", "Looking for a photographer for family portraits.", "In Progress", "$300")
        )
    )
}
