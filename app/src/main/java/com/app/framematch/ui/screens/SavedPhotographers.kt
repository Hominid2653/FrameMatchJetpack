package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter

// Updated Photographer Data Class
data class Photographer(
    val id: Int,
    val name: String,
    val bio: String,
    val profilePictureUrl: String,
    val rating: Float = 0f, // Default rating
    val portfolio: List<String> = emptyList() // Default empty portfolio
    )

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedPhotographerScreen(
    navController: NavController,
    savedPhotographers: List<Photographer>,
    onRemovePhotographer: (Photographer) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Saved Photographers") },
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
            items(savedPhotographers.size) { index ->
                val photographer = savedPhotographers[index]
                SavedPhotographerCard(
                    photographer = photographer,
                    onCardClick = { navController.navigate("photographer_profile/${photographer.id}") },
                    onRemoveClick = { onRemovePhotographer(photographer) }
                )
            }
        }
    }
}

@Composable
fun SavedPhotographerCard(
    photographer: Photographer,
    onCardClick: () -> Unit,
    onRemoveClick: () -> Unit
) {
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
            }
            IconButton(onClick = onRemoveClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Remove Photographer"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SavedPhotographerScreenPreview() {
    // Mock Photographer Data
    val mockPhotographers = listOf(
        Photographer(
            id = 1,
            name = "John Doe",
            bio = "A portrait and landscape photographer.",
            profilePictureUrl = "https://via.placeholder.com/64"
        ),
        Photographer(
            id = 2,
            name = "Jane Smith",
            bio = "Specializes in wildlife and travel photography.",
            profilePictureUrl = "https://via.placeholder.com/64"
        )
    )

    SavedPhotographerScreen(
        navController = rememberNavController(),
        savedPhotographers = mockPhotographers,
        onRemovePhotographer = { /* No-op for preview */ }
    )
}
