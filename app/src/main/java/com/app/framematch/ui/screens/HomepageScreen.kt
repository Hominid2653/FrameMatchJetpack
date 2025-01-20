//package com.app.framematch.ui.screens
//
//import android.widget.Toast
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import com.app.framematch.R
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun FeedScreen(
//    onProfileClick: () -> Unit,
//    onSearchClick: () -> Unit,
//    onUploadClick: () -> Unit,
//    onActivityClick: () -> Unit,
//    posts: List<Post> = listOf()
//) {
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        // Header Bar
//        TopAppBar(
//            title = { Text(text = "FrameMatch") },
//            actions = {
//                IconButton(onClick = onSearchClick) {
//                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
//                }
//                IconButton(onClick = onProfileClick) {
//                    Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profile")
//                }
//            }
//        )
//
//        // Post Feed
//        Column(modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp)
//            .weight(1f)
//        ) {
//            posts.forEach { post ->
//                PostItem(post = post)
//            }
//        }
//
//        // Bottom Navigation Bar
//        BottomNavigationBar(
//            onUploadClick = onUploadClick,
//            onActivityClick = onActivityClick
//        )
//    }
//}
//
//@Composable
//fun PostItem(post: Post) {
//    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//        // Photographer's Profile Picture
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Image(
//                painter = painterResource(id = post.photographerImageRes),
//                contentDescription = "Photographer's Profile",
//                modifier = Modifier.size(40.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Text(text = post.photographerName, fontWeight = FontWeight.Bold)
//        }
//
//        // Post Image
//        Spacer(modifier = Modifier.height(8.dp))
//        Image(
//            painter = painterResource(id = post.imageRes),
//            contentDescription = "Post Image",
//            modifier = Modifier.fillMaxWidth().height(250.dp)
//        )
//
//        // Post Description
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(text = post.caption, style = MaterialTheme.typography.bodyLarge)
//
//        // Engagement Buttons
//        Spacer(modifier = Modifier.height(8.dp))
//        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
//            IconButton(onClick = {}) {
//                Icon(painter = painterResource(id = R.drawable.ic_like), contentDescription = "Like")
//            }
//            IconButton(onClick = {}) {
//                Icon(painter = painterResource(id = R.drawable.ic_comment), contentDescription = "Comment")
//            }
//            IconButton(onClick = {}) {
//                Icon(painter = painterResource(id = R.drawable.ic_share), contentDescription = "Share")
//            }
//        }
//
//        // Likes Count
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "${post.likesCount} Likes", style = MaterialTheme.typography.bodySmall)
//
//        // Comments Section
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = "View all ${post.commentsCount} comments", style = MaterialTheme.typography.bodySmall)
//    }
//}
//
//@Composable
//fun BottomNavigationBar(
//    onUploadClick: () -> Unit,
//    onActivityClick: () -> Unit
//) {
//    BottomAppBar(
//        modifier = Modifier.fillMaxWidth(),
//        containerColor = Color(0xFFF0F0F0)
//    ) {
//        IconButton(onClick = { /* Go to Feed Screen */ }) {
//            Icon(painter = painterResource(id = R.drawable.ic_feed), contentDescription = "Feed")
//        }
//        IconButton(onClick = { /* Go to Search Screen */ }) {
//            Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search")
//        }
//        IconButton(onClick = onUploadClick) {
//            Icon(painter = painterResource(id = R.drawable.ic_upload), contentDescription = "Upload")
//        }
//        IconButton(onClick = onActivityClick) {
//            Icon(painter = painterResource(id = R.drawable.ic_activity), contentDescription = "Activity")
//        }
//    }
//}
//
////data class Post(
////    val photographerImageRes: Int,
////    val photographerName: String,
////    val imageRes: Int,
////    val caption: String,
////    val likesCount: Int,
////    val commentsCount: Int
////)
//
//@Preview(showBackground = true)
//@Composable
//fun FeedScreenPreview() {
//    FeedScreen(
//        onProfileClick = {},
//        onSearchClick = {},
//        onUploadClick = {},
//        onActivityClick = {},
//        posts = listOf(
//            Post(
//                photographerImageRes = R.drawable.ic_sample_profile,
//                photographerName = "Elias",
//                imageRes = R.drawable.ic_sample_image,
//                caption = "Captured this beautiful sunset! #nature #photography",
//                likesCount = 120,
//                commentsCount = 45
//            ),
//            Post(
//                photographerImageRes = R.drawable.ic_sample_profile,
//                photographerName = "Hominid",
//                imageRes = R.drawable.ic_sample_image,
//                caption = "Product shoot for @brandname. #productphotography",
//                likesCount = 150,
//                commentsCount = 32
//            )
//        )
//    )
//}
