@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.app.framematch.models.post.Post

@Composable
fun FeedScreenWithUniqueMethod(navController: NavController, posts: List<Post>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Client Feed",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                actions = {
                    IconButton(onClick = { /* Navigate to Notifications */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(posts.size) { index ->
                val post = posts[index]
                FeedPostCardWithUniqueMethod(post = post, onPostClick = { /* Handle post click, e.g., open post details */ })
            }
        }
    }
}

@Composable
fun FeedPostCardWithUniqueMethod(post: Post, onPostClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onPostClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = rememberImagePainter(data = post.imageUrl),
                contentDescription = "Post Image",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.caption,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreviewWithUniqueMethod() {
    val mockPosts = listOf(
        Post(id = 1, caption = "Beautiful Landscape!", imageUrl = "https://via.placeholder.com/200"),
        Post(id = 2, caption = "Wildlife Photography!", imageUrl = "https://via.placeholder.com/200")
    )

    FeedScreenWithUniqueMethod(navController = rememberNavController(), posts = mockPosts)
}
