@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun AddPortfolioScreen(navController: NavController) {
    val portfolioPhotos = remember { mutableStateListOf("Photo 1", "Photo 2", "Photo 3") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add to Portfolio") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("createPostScreen") }) {
                Icon(Icons.Default.Add, contentDescription = "Add Photo")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                text = "Your Portfolio",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // Display Portfolio Photos in a Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(portfolioPhotos) { photo ->
                    PortfolioPhotoCard(
                        photo = photo,
                        onEditClick = { /* Edit photo logic */ },
                        onDeleteClick = { portfolioPhotos.remove(photo) }
                    )
                }
            }
        }
    }
}

@Composable
fun PortfolioPhotoCard(photo: String, onEditClick: () -> Unit, onDeleteClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Placeholder image
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery), // Replace with actual image source
                contentDescription = photo,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Row(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Photo",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onEditClick),
                    tint = Color.White
                )
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Photo",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = onDeleteClick),
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun CreatePostScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create Post") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = "Add a New Photo", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle text input */ },
                label = { Text("Photo Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = "",
                onValueChange = { /* Handle text input */ },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { /* Handle photo upload logic */ },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Upload Photo")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddPortfolioScreenPreview() {
    val navController = rememberNavController() // Mock NavController for Preview
    AddPortfolioScreen(navController)
}

@Preview(showBackground = true)
@Composable
fun CreatePostScreenPreview() {
    val navController = rememberNavController() // Mock NavController for Preview
    CreatePostScreen(navController)
}

