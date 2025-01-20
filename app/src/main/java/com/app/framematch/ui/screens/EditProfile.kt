@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen() {
    var username by remember { mutableStateOf(TextFieldValue("John Doe")) }
    var email by remember { mutableStateOf(TextFieldValue("johndoe@example.com")) }
    var phone by remember { mutableStateOf(TextFieldValue("+1 234 567 8901")) }
    var location by remember { mutableStateOf(TextFieldValue("New York, USA")) }
    var bio by remember { mutableStateOf(TextFieldValue("Photographer & Content Creator")) }
    var specialty by remember { mutableStateOf(TextFieldValue("Wedding Photography")) }
    var profileImageUri by remember { mutableStateOf<Uri?>(null) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        // Profile Image
        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Gray)
                .clickable { /* Add logic to choose image */ }
        ) {
            profileImageUri?.let {
                Image(
                    painter = painterResource(id = R.drawable.profile1), // Placeholder image
                    contentDescription = "Profile Image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            } ?: run {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera), // Placeholder icon for image upload
                    contentDescription = "Upload Profile Image",
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Username Field
        Text("Full Name", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Email Field
        Text("Email", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Phone Field
        Text("Phone Number", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Location Field
        Text("Location", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = location,
            onValueChange = { location = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bio Field
        Text("Bio", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = bio,
            onValueChange = { bio = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            maxLines = 3,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Specialty Field
        Text("Specialty", style = MaterialTheme.typography.bodyMedium, color = Color(0xFF1F2B6C))
        TextField(
            value = specialty,
            onValueChange = { specialty = it },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color(0xFFF0F0F0),
                focusedIndicatorColor = Color(0xFF1F2B6C),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Save Button
        Button(
            onClick = { /* Save Profile Changes */ },
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
        ) {
            Text("Save Changes", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    EditProfileScreen()
}
