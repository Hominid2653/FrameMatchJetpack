//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package com.app.framematch.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.app.framematch.R
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun FollowersAndClientsScreen() {
//    var searchQuery by remember { mutableStateOf(TextFieldValue()) }
//
//    // Sample data
//    val followers = listOf("Client 1", "Client 2", "Client 3", "Client 4")
//    val profileImages = listOf(R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4)
//
//    // Statistics
//    val totalFollowers = 120
//    val newClients = 5
//    val dealsInProgress = 7
//    val closedDeals = 3
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        // Header Bar
//        TopAppBar(
//            title = { Text(text = "Followers & Clients") }
//        )
//
//        // Statistics Section
//        StatisticsSection(totalFollowers, newClients, dealsInProgress, closedDeals)
//
//        // Search Bar
//        Spacer(modifier = Modifier.height(16.dp))
//        BasicTextField(
//            value = searchQuery,
//            onValueChange = { searchQuery = it },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//                .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.medium)
//                .padding(12.dp),
//            decorationBox = { innerTextField ->
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search", tint = Color(0xFF1F2B6C))
//                    Spacer(modifier = Modifier.width(8.dp))
//                    innerTextField()
//                }
//            }
//        )
//
//        // List of Followers/Clients
//        Spacer(modifier = Modifier.height(16.dp))
//        LazyColumn(modifier = Modifier.padding(16.dp)) {
//            items(followers.filter { it.contains(searchQuery.text, ignoreCase = true) }) { follower ->
//                FollowerClientItem(follower, profileImages[followers.indexOf(follower)])
//            }
//        }
//    }
//}
//
//@Composable
//fun StatisticsSection(totalFollowers: Int, newClients: Int, dealsInProgress: Int, closedDeals: Int) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        // Statistics Box
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//                .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.medium)
//                .padding(16.dp),
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            StatisticCard("Followers", totalFollowers)
//            StatisticCard("Clients", newClients)
//            StatisticCard("Deals", dealsInProgress)
//            StatisticCard("Closed", closedDeals)
//        }
//    }
//}
//
//@Composable
//fun StatisticCard(title: String, count: Int) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        Text(text = title, style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(text = count.toString(), style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
//    }
//}
//
//@Composable
//fun FollowerClientItem(name: String, imageResId: Int) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(8.dp)
//            .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
//            .padding(16.dp)
//    ) {
//        Image(
//            painter = painterResource(id = imageResId),
//            contentDescription = "Profile Picture",
//            modifier = Modifier.size(40.dp).clip(MaterialTheme.shapes.medium)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//        Text(text = name, style = MaterialTheme.typography.bodyLarge)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun FollowersAndClientsScreenPreview() {
//    FollowersAndClientsScreen()
//}
