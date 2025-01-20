package com.app.framematch.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(navController: NavController, userName: String) {
    var messageText by remember { mutableStateOf("") }

    // Sample messages (This could come from a data source)
    val messages = listOf(
        Message("Sure, when are you available?", "You", "2:31 PM", false),
        Message("Hi! I would like to work with you.", "John Doe", "2:30 PM", true)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Chat with $userName") },
                actions = {
                    IconButton(onClick = { /* Add other action like calling or video chat */ }) {
                        Icon(Icons.Default.Call, contentDescription = "Call", tint = Color.White)
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
                .padding(16.dp)
        ) {
            // Messages
            LazyColumn(
                modifier = Modifier.weight(1f),
                reverseLayout = true
            ) {
                itemsIndexed(messages) { index, message ->
                    MessageCard(message = message)
                }
            }

            // Message Input
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = messageText,
                    onValueChange = { messageText = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    placeholder = { Text("Type a message") },
                    maxLines = 1
                )
                IconButton(
                    onClick = {
                        // Send message logic here
                        messageText = ""  // Clear input after sending
                    }
                ) {
                    Icon(Icons.Default.Send, contentDescription = "Send")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    val navController = rememberNavController()
    ChatScreen(navController = navController, userName = "John Doe")
}
