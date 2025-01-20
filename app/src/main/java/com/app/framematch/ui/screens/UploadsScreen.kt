//package com.app.framematch.ui.screens
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.text.BasicTextField
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.sp
//import com.app.framematch.R
//
//
//
//class UploadsActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            UploadsScreen()
//        }
//    }
//}
//
//@Composable
//fun UploadsScreen() {
//    var caption by remember { mutableStateOf(TextFieldValue()) }
//    var selectedImage by remember { mutableStateOf<String?>(null) } // Placeholder for selected image
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        // Title
//        Text(
//            text = "Upload Photos",
//            style = TextStyle(fontWeight = FontWeight.Bold, color = Color(0xFF1F2B6C), fontSize = 24.sp),
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        // File Upload Button
//        UploadButton(
//            onClick = { /* Add file selection logic here */ }
//        )
//
//        // Image Preview Section
//        if (selectedImage != null) {
//            // Placeholder for image preview
//            Text(
//                text = "Image Selected: $selectedImage", // Replace with actual image preview
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 16.dp)
//            )
//            IconButton(
//                onClick = { selectedImage = null },
//                modifier = Modifier.align(Alignment.End)
//            ) {
//                // Use the custom close drawable from resources
//                Image(
//                    painter = painterResource(id = R.drawable.ic_close), // Use your actual close icon drawable here
//                    contentDescription = "Remove Image",
//                    modifier = Modifier.size(24.dp)
//                )
//            }
//        }
//
//        // Caption Field
//        Text("Write a Caption", style = TextStyle(color = Color(0xFF1F2B6C)))
//        Spacer(modifier = Modifier.height(8.dp))
//        BasicTextField(
//            value = caption,
//            onValueChange = { caption = it },
//            textStyle = TextStyle(color = Color.Black),
//            modifier = Modifier
//                .fillMaxWidth()
//                .heightIn(min = 100.dp)
//                .padding(16.dp)
//                .border(1.dp, Color.Gray)
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        // Tags Section
//        Text("Add Tags", style = TextStyle(color = Color(0xFF1F2B6C)))
//        // Placeholder for Tags (Use dropdown or multi-select)
//        Spacer(modifier = Modifier.height(8.dp))
//        TagsButton(
//            onClick = { /* Handle tag selection */ }
//        )
//
//        // Upload Button
//        UploadActionButton(
//            onClick = { /* Handle upload logic here */ },
//            enabled = selectedImage != null && caption.text.isNotEmpty()
//        )
//    }
//}
//
//// Custom Upload Button
//@Composable
//fun UploadButton(onClick: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .height(50.dp)
//            .border(2.dp, Color(0xFF1F2B6C))
//            .clickable { onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Choose File", color = Color(0xFF1F2B6C), fontWeight = FontWeight.Bold)
//    }
//}
//
//// Custom Tags Button
//@Composable
//fun TagsButton(onClick: () -> Unit) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp)
//            .height(50.dp)
//            .border(2.dp, Color(0xFF1F2B6C))
//            .clickable { onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(text = "Select Tags", color = Color(0xFF1F2B6C), fontWeight = FontWeight.Bold)
//    }
//}
//
//// Custom Upload Action Button
//@Composable
//fun UploadActionButton(onClick: () -> Unit, enabled: Boolean) {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 16.dp)
//            .height(50.dp)
//            .border(2.dp, Color(0xFF1F2B6C))
//            .clickable { if (enabled) onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            text = "Upload",
//            color = if (enabled) Color(0xFF1F2B6C) else Color.Gray,
//            fontWeight = FontWeight.Bold
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    UploadsScreen()
//}
