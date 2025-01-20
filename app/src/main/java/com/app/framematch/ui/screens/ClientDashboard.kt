@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ClientDashboardScreen(navController: NavController, clientName: String = "User") {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Client Dashboard",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Welcome Banner
            WelcomeBanner(clientName)

            Spacer(modifier = Modifier.height(24.dp))

            // Quick Actions
            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            QuickActionsRow(navController)

            Spacer(modifier = Modifier.height(24.dp))

            // Navigation Cards
            Text(
                text = "Explore",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                DashboardCard(
                    title = "View Feed",
                    description = "See the latest posts and offers.",
                    icon = Icons.Default.Feed,
                    onClick = { navController.navigate("feedScreen") }
                )
                DashboardCard(
                    title = "Browse Photographers",
                    description = "Find and filter photographers to fit your style.",
                    icon = Icons.Default.Search,
                    onClick = { navController.navigate("browsePhotographersScreen") }
                )
                DashboardCard(
                    title = "Direct Message",
                    description = "Chat with photographers directly.",
                    icon = Icons.Default.Message,
                    onClick = { navController.navigate("directMessageScreen") }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Recent Activity Section
            RecentActivitySection("You have 2 new job offers awaiting response.")
        }
    }
}

@Composable
fun WelcomeBanner(clientName: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1F2B6C)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Hello, $clientName!",
                style = MaterialTheme.typography.titleMedium.copy(color = Color.White, fontWeight = FontWeight.Bold)
            )
            Text(
                text = "Ready to find the perfect photographer?",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.White)
            )
        }
    }
}

@Composable
fun QuickActionsRow(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuickActionButton(
            label = "Post a Job",
            icon = Icons.Default.Add,
            onClick = { navController.navigate("postJobScreen") }
        )
        QuickActionButton(
            label = "Saved Photographers",
            icon = Icons.Default.Favorite,
            onClick = { navController.navigate("savedPhotographersScreen") }
        )
    }
}

@Composable
fun QuickActionButton(label: String, icon: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
    ) {
        Icon(icon, contentDescription = label, tint = Color.White)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, color = Color.White)
    }
}

@Composable
fun RecentActivitySection(activityMessage: String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = "Recent Activity",
            style = MaterialTheme.typography.titleMedium,
        )
        Text(
            text = activityMessage,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun DashboardCard(
    title: String,
    description: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5)),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(40.dp),
                tint = Color(0xFF1F2B6C)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                    color = Color.Black
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ClientDashboardScreenPreview() {
    val navController = rememberNavController()
    ClientDashboardScreen(navController, clientName = "John")
}
