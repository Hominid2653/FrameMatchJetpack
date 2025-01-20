//package com.app.framematch.ui.screens  // or the appropriate package where your UI components are stored
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import coil.compose.rememberImagePainter
//import com.app.framematch.models.post.Post  // Import the Post data class
//
//@Composable
//fun PostCard(post: Post) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(8.dp),
//        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
//        elevation = CardDefaults.cardElevation(4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            // Load image using Coil
//            Image(
//                painter = rememberImagePainter(post.imageUrl),  // Use Coil to load image from URL
//                contentDescription = post.caption,
//                modifier = Modifier.fillMaxWidth().height(200.dp),
//                contentScale = ContentScale.Crop
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = post.caption, style = MaterialTheme.typography.bodyMedium)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PostCardPreview() {
//    // Sample post for preview
//    val samplePost = Post(id = 1, caption = "Beautiful sunset", imageUrl = "https://via.placeholder.com/150")
//    PostCard(post = samplePost)
//}
