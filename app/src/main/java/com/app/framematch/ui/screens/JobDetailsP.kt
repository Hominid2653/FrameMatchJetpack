package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JobDetailsScreen(job: Job1) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Details") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(text = "Title: ${job.title}", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Location: ${job.location}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Budget: ${job.budget}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${job.description}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Status: ${job.status}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
