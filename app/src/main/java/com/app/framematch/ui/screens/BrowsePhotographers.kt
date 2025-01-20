package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrowsePhotographersScreen(navController: NavController, photographers: List<Photographer>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Browse Photographers") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(photographers) { photographer ->
                PhotographerCard(
                    photographer = photographer,
                    onCardClick = { navController.navigate("photographer_profile/${photographer.id}") }
                )
            }
        }
    }
}

@Composable
fun PhotographerCard(photographer: Photographer, onCardClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onCardClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = photographer.profilePictureUrl),
                contentDescription = "Profile Picture of ${photographer.name}",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = photographer.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = photographer.bio,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray
                )
                RatingBar(rating = photographer.rating)
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(5) { index ->
            Icon(
                imageVector = if (index < rating) Icons.Default.Star else Icons.Default.StarBorder,
                contentDescription = "Star",
                modifier = Modifier.size(20.dp),
                tint = Color.Yellow
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BrowsePhotographersScreenPreview() {
    val mockPhotographers = listOf(
        Photographer(
            id = 1,
            name = "John Doe",
            bio = "Portrait and landscape photographer.",
            rating = 4.5f,
            profilePictureUrl = "https://via.placeholder.com/64"
        ),
        Photographer(
            id = 2,
            name = "Jane Smith",
            bio = "Specializes in wildlife photography.",
            rating = 4.8f,
            profilePictureUrl = "https://via.placeholder.com/64"
        ),
        Photographer(
            id = 2,
        name = "Jane Smith",
        bio = "Specializes in wildlife photography.",
        rating = 3.8f,
        profilePictureUrl = "https://via.placeholder.com/64"
    )

    )

    BrowsePhotographersScreen(
        navController = rememberNavController(),
        photographers = mockPhotographers
    )
}
