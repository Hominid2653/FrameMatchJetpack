package com.app.framematch.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define your color scheme here based on the Figma design
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1F2B6C), // Primary color
    secondary = Color(0xFF6200EE), // Secondary color
    background = Color(0xFFFFFFFF), // White background
    surface = Color(0xFFFFFFFF), // Surface color (for cards, etc.)
    onPrimary = Color.White, // Text color for primary elements
    onSecondary = Color.White, // Text color for secondary elements
    onBackground = Color(0xFF000000), // Text color on background
    onSurface = Color(0xFF000000), // Text color for surface elements
    error = Color(0xFFB00020), // Error color
)

@Composable
fun FrameMatchJetpackTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
