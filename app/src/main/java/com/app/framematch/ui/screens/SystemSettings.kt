//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package com.app.framematch.ui.screens
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Settings
//
//@Composable
//fun SystemSettingsScreen() {
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = { Text(text = "System Settings") },
//                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
//            )
//        }
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = "Configure system settings here.",
//                style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, color = Color.Black)
//            )
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun SystemSettingsScreenPreview() {
//    SystemSettingsScreen()
//}
