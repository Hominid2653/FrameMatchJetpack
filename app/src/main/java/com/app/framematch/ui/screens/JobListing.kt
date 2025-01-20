@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class JobPost(val id: Int, val title: String, val description: String, val budget: String, val location: String)

@Composable
fun JobListingScreen(
    isPhotographer: Boolean, // To differentiate between Photographer and Client
    onJobSelected: (JobPost) -> Unit // To handle job selection and navigate to JobDetailsScreen
) {
    val jobPosts = remember {
        listOf(
            JobPost(1, "Wedding Photography", "Capture memories of a wedding ceremony", "$500", "Nairobi"),
            JobPost(2, "Product Photoshoot", "Take product photos for an online store", "$300", "Mombasa"),
            JobPost(3, "Event Photography", "Capture a corporate event", "$700", "Kisumu")
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Listings") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            items(jobPosts) { jobPost ->
                JobPostCard(jobPost = jobPost, isPhotographer = isPhotographer, onJobSelected = onJobSelected)
            }
        }
    }
}

@Composable
fun JobPostCard(
    jobPost: JobPost,
    isPhotographer: Boolean,
    onJobSelected: (JobPost) -> Unit
) {
    Card(
        onClick = { onJobSelected(jobPost) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = jobPost.title, style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = jobPost.description, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Budget: ${jobPost.budget}", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Location: ${jobPost.location}", style = MaterialTheme.typography.bodyMedium)

            if (isPhotographer) {
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = { /* Navigate to bid screen */ }) {
                    Text("Place a Bid")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun JobListingScreenPreview() {
    JobListingScreen(
        isPhotographer = true,
        onJobSelected = {}
    )
}
