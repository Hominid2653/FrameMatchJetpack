package com.app.framematch.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MessageCard(message: Message) {
    // Set the background color based on whether the message was sent by the current user
    val backgroundColor = if (message.isSentByCurrentUser) Color(0xFF1F2B6C) else Color.LightGray
    val textColor = if (message.isSentByCurrentUser) Color.White else Color.Black

    // Display the message in a row
    Row(
        horizontalArrangement = if (message.isSentByCurrentUser) Arrangement.End else Arrangement.Start,
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(backgroundColor, RoundedCornerShape(12.dp))
                .padding(12.dp)
        ) {
            Text(
                text = message.text,
                color = textColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MessageCardPreview() {
    MessageCard(
        message = Message("Hi! How can I help you?", "John Doe", "2:30 PM", true)
    )
}

@Preview(showBackground = true)
@Composable
fun MessageCardPreviewOtherUser() {
    MessageCard(
        message = Message("Hello! I need assistance with a project.", "Jane Smith", "2:31 PM", false)
    )
}
