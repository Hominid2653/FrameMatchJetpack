package com.app.framematch.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// External data class to hold job information
data class Job1(
    val title: String,
    val budget: Int,
    val location: String,
    val description: String,
    val status: String,
    val budget2: String // Assuming it might be used for displaying different budget info
)
