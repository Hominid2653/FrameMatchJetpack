//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package com.app.framematch.ui.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//
//@Composable
//fun AdminScreen() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "Admin Dashboard",
//                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
//                    )
//                },
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C)),
//                actions = {
//                    IconButton(onClick = { /* Add action for settings or notifications */ }) {
//                        Icon(
//                            imageVector = Icons.Default.Settings,
//                            contentDescription = "Settings",
//                            tint = Color.White
//                        )
//                    }
//                }
//            )
//        }
//    ) { innerPadding ->
//        AdminDashboardContent(modifier = Modifier.padding(innerPadding))
//    }
//}
//
//@Composable
//fun AdminDashboardContent(modifier: Modifier = Modifier) {
//    val adminOptions = listOf(
//        "User Management" to Icons.Default.Person,
//        "Content Moderation" to Icons.Default.Security,
//        "Statistics" to Icons.Default.BarChart,
//        "Reports" to Icons.Default.Assessment,
//        "System Settings" to Icons.Default.Settings
//    )
//
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Text(
//            text = "Overview",
//            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(2),
//            contentPadding = PaddingValues(8.dp),
//            verticalArrangement = Arrangement.spacedBy(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp),
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(adminOptions.size) { index ->
//                AdminOptionCard(option = adminOptions[index].first, icon = adminOptions[index].second)
//            }
//        }
//    }
//}
//
//@Composable
//fun AdminOptionCard(option: String, icon: ImageVector) {
//    Card(
//        onClick = { /* Handle click action */ },
//        modifier = Modifier
//            .fillMaxWidth()
//            .aspectRatio(1f),
//        shape = RoundedCornerShape(16.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Icon(
//                    imageVector = icon,
//                    contentDescription = option,
//                    modifier = Modifier.size(40.dp),
//                    tint = Color(0xFF1F2B6C)
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = option,
//                    style = MaterialTheme.typography.bodyLarge.copy(
//                        fontWeight = FontWeight.Medium,
//                        fontSize = 16.sp
//                    ),
//                    color = Color.Black
//                )
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun AdminScreenPreview() {
//    AdminScreen()
//}
