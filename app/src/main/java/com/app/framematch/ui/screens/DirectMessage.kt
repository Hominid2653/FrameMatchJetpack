@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DirectMessageScreen(navController: NavController) {
    // List of conversations (This would typically come from a data source or API)
    val conversations = listOf(
        Conversation("John Doe", "Hi! I would like to work with you.", "2:30 PM", true),
        Conversation("Jane Smith", "Hello, are you available?", "1:15 PM", false)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Direct Messages",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                actions = {
                    IconButton(onClick = { /* Add new message or contact */ }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Contact", tint = Color.White)
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
        ) {
            itemsIndexed(conversations) { index, conversation ->
                MessageCard(conversation = conversation, onClick = {
                    // Navigate to individual chat screen
                    navController.navigate("chatScreen/${conversation.name}")
                })
            }
        }
    }
}

@Composable
fun ClientDirectMessageScreen(navController: NavController) {
    // Client's conversations
    val conversations = listOf(
        Conversation("Photographer A", "Can you capture a wedding event?", "3:45 PM", true),
        Conversation("Photographer B", "Looking forward to our session!", "1:10 PM", false)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Your Messages",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                    )
                },
                actions = {
                    IconButton(onClick = { /* Add contact or message */ }) {
                        Icon(Icons.Default.Add, contentDescription = "New Message", tint = Color.White)
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
        ) {
            itemsIndexed(conversations) { _, conversation ->
                MessageCard(conversation = conversation, onClick = {
                    navController.navigate("clientChatScreen/${conversation.name}")
                })
            }
        }
    }
}


@Composable
fun MessageCard(conversation: Conversation, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = conversation.name,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.weight(1f)
            )
            Text(
                text = conversation.lastMessage,
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray),
                modifier = Modifier.weight(3f)
            )
            Text(
                text = conversation.time,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
        }
    }
}

data class Conversation(val name: String, val lastMessage: String, val time: String, val isUnread: Boolean)
@Preview(showBackground = true)
@Composable
fun DirectMessageScreenPreview() {
    val navController = rememberNavController()
    DirectMessageScreen(navController = navController)
}
