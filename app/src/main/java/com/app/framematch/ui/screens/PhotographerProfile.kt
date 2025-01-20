package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.app.framematch.models.post.Photographer
import com.app.framematch.models.post.Post

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun PhotographerProfileScreen(navController: NavController, photographerId: Int) {
    val photographer = getPhotographerById(photographerId)  // Fetch photographer data

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = photographer.name, style = MaterialTheme.typography.titleLarge)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Profile Section
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Profile Picture (Placeholder for now)
                ProfileImage(imageUrl = photographer.profilePictureUrl)

                Spacer(modifier = Modifier.width(16.dp))

                // Photographer Details
                Column {
                    Text(text = photographer.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = photographer.bio, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Rating: ${photographer.rating}", style = MaterialTheme.typography.bodySmall)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Posts Section
            Text(text = "Posts", style = MaterialTheme.typography.titleMedium)

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
//                // Ensure you're passing 'post' to 'PostCard', which is the correct type
//                items(photographer.posts) { post ->
//                    PostCard(post = post)  // Correct, post is a Post object
                }
            }
        }
    }


@Composable
fun ProfileImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl), // Using a placeholder for now
        contentDescription = "Profile Picture",
        modifier = Modifier
            .size(80.dp)
            .clip(RoundedCornerShape(40.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun PostCard(post: Post) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Load post image (placeholder)
            PostImage(imageUrl = post.imageUrl)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.caption, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun PostImage(imageUrl: String) {
    Image(
        painter = rememberImagePainter(imageUrl), // Placeholder for now
        contentDescription = "Post Image",
        modifier = Modifier.fillMaxWidth().height(200.dp),
        contentScale = ContentScale.Crop
    )
}

fun getPhotographerById(id: Int): Photographer {
    // Mocking the photographer data for this example
    return Photographer(
        id = id,
        name = "John Doe",
        bio = "Landscape photographer with a passion for nature.",
        rating = 4.7f,
//        posts = listOf(
//            Post(id = 1, caption = "Morning in the mountains", imageUrl = "https://via.placeholder.com/150"),
//            Post(id = 2, caption = "Desert Dunes", imageUrl = "https://via.placeholder.com/150")
//        ),
        profilePictureUrl = "https://via.placeholder.com/150"
    )
}




@Preview(showBackground = true)
@Composable
fun PhotographerProfileScreenPreview() {
    // Preview with sample data
    val samplePhotographer = Photographer(
        id = 1,
        name = "John Doe",
        profilePictureUrl = "https://via.placeholder.com/150",
        bio = "Photographer based in Nairobi. Capturing the beauty of the world.",
        rating = 4.5f,
//        posts = listOf(
//            Post(id = 1, caption = "Beautiful sunset", imageUrl = "https://via.placeholder.com/150"),
//            Post(id = 2, caption = "Amazing landscape", imageUrl = "https://via.placeholder.com/150")
        )

    PhotographerProfileScreen(navController = rememberNavController(), photographerId = samplePhotographer.id)
}
