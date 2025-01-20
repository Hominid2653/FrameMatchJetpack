package com.app.framematch.ui.screens

data class Message(
    val text: String,                // The content of the message
    val sender: String,              // Sender's name
    val time: String,                // Time of the message
    val isSentByCurrentUser: Boolean // Whether the message is sent by the current user or not
)
