@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun PhotographerDashboardScreen(navController: NavController, photographerName: String = "Photographer") {
    var notificationCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Photographer Dashboard",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                actions = {
                    IconButton(onClick = { /* Increment notifications for testing */ }) {
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
            WelcomeBanner(photographerName)

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Quick Actions",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
            PhotographerQuickActionsRow(navController)

            Spacer(modifier = Modifier.height(24.dp))

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
                    title = "View Jobs",
                    description = "See available jobs posted by clients.",
                    icon = Icons.Default.Work,
                    onClick = { navController.navigate("viewJobsScreen") }
                )
                DashboardCard(
                    title = "Manage Portfolio",
                    description = "Update and showcase your work.",
                    icon = Icons.Default.PhotoLibrary,
                    onClick = { navController.navigate("managePortfolioScreen") }
                )
                DashboardCard(
                    title = "Direct Message",
                    description = "Communicate with clients directly.",
                    icon = Icons.Default.Message,
                    onClick = { navController.navigate("directMessageScreen") }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            RecentActivitySection("You have 2 new job offers awaiting response.")
        }


    }


}
@Composable
fun PhotographerQuickActionsRow(navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        QuickActionButton(
            label = "View Jobs",
            icon = Icons.Default.Work,
            onClick = { navController.navigate("viewJobsScreen") }
        )
        QuickActionButton(
            label = "Manage Portfolio",
            icon = Icons.Default.PhotoLibrary,
            onClick = { navController.navigate("managePortfolioScreen") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PhotographerDashboardPreview() {
    val navController = rememberNavController()
    PhotographerDashboardScreen(navController = navController, photographerName = "John Doe")
}
