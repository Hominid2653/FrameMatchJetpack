package com.app.framematch.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.R

// Make sure you have the correct import for items
import androidx.compose.foundation.lazy.items

@Composable
fun PhotographerDetailScreen(
    photographerName: String,
    photographerBio: String,
    portfolioImages: List<Int>,  // List of resource IDs (Int)
    onBookSession: () -> Unit,
    onContactPhotographer: () -> Unit
) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.ic_sample_profile),
            contentDescription = "Photographer's Profile Picture",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        // Photographer's Name
        Text(
            text = photographerName,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        // Bio Section
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = photographerBio,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        // Portfolio Gallery
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Portfolio",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        // Display Portfolio Images
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(portfolioImages) { imageResId -> // Use 'items' with the list directly
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Portfolio Image",
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                )
            }
        }

        // Book Session and Contact Buttons
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onBookSession,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Book a Session")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = onContactPhotographer,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Contact Photographer")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotographerDetailPreview() {
    PhotographerDetailScreen(
        photographerName = "John Doe",
        photographerBio = "An experienced photographer specializing in portraits and events.",
        portfolioImages = listOf(R.drawable.ic_sample_image, R.drawable.ic_sample_image, R.drawable.ic_sample_image),
        onBookSession = {
            // Handle booking action
        },
        onContactPhotographer = {
            // Handle contact action
        }
    )
}
