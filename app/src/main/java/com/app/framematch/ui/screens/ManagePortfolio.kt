package com.app.framematch.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.framematch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManagePortfolioScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manage Portfolio") },
                actions = {
                    IconButton(onClick = { /* Handle Notifications */ }) {
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
            // Portfolio Title
            Text(
                text = "Your Portfolio",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Display Portfolio Images
            PortfolioGrid()

            Spacer(modifier = Modifier.height(24.dp))

            // Add New Image Button
            Button(
                onClick = { /* Trigger Image Upload */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
            ) {
                Text(text = "Add New Image", color = Color.White)
            }
        }
    }
}

@Composable
fun PortfolioGrid() {
    // Sample portfolio images - This should be dynamic based on the photographer's portfolio
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // For each image in the portfolio, you would create an Image view here
        // Currently using placeholders as examples
        Image(
            painter = painterResource(id = R.drawable.placeholder_image),
            contentDescription = "Portfolio Image",
            modifier = Modifier
                .size(100.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.placeholder_image),
            contentDescription = "Portfolio Image",
            modifier = Modifier
                .size(100.dp)
                .fillMaxWidth()
        )
        Image(
            painter = painterResource(id = R.drawable.placeholder_image),
            contentDescription = "Portfolio Image",
            modifier = Modifier
                .size(100.dp)
                .fillMaxWidth()
        )

    }
}

@Preview(showBackground = true)
@Composable
fun ManagePortfolioScreenPreview() {
    val navController = rememberNavController()
    ManagePortfolioScreen(navController = navController)
}
