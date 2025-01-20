//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package com.app.framematch.ui.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.app.framematch.R
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ActivityScreen() {
//    Column(modifier = Modifier.fillMaxSize()) {
//
//        // Top Bar
//        TopAppBar(
//            title = { Text(text = "Activity", color = Color.White) },
//            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1F2B6C))
//        )
//
//        // Activity Feed
//        LazyColumn(modifier = Modifier.padding(16.dp)) {
//            item { ActivityItem(icon = R.drawable.ic_follow, title = "New Follower", description = "John Doe started following you.") }
//            item { ActivityItem(icon = R.drawable.ic_like, title = "New Like", description = "Anna liked your photo.") }
//            item { ActivityItem(icon = R.drawable.ic_booking, title = "Booking Request", description = "David requested a session on Jan 20.") }
//            item { ActivityItem(icon = R.drawable.ic_comment, title = "New Comment", description = "Sophia: Amazing shot!") }
//            item { ActivityItem(icon = R.drawable.ic_notification, title = "System Update", description = "FrameMatch has introduced new features.") }
//        }
//    }
//}
//
//@Composable
//fun ActivityItem(icon: Int, title: String, description: String) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Surface(
//            modifier = Modifier.size(40.dp),
//            shape = CircleShape,
//            color = Color(0xFF1F2B6C)
//        ) {
//            Icon(
//                painter = painterResource(id = icon),
//                contentDescription = title,
//                tint = Color.White,
//                modifier = Modifier.padding(8.dp)
//            )
//        }
//
//        Spacer(modifier = Modifier.width(12.dp))
//
//        Column {
//            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp, color = Color.Black)
//            Text(text = description, fontSize = 14.sp, color = Color.Gray)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun ActivityScreenPreview() {
//    ActivityScreen()
//}
