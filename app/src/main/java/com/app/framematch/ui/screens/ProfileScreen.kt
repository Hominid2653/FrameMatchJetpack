@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.R

@Composable
fun ProfileScreen(
    userName: String,
    bio: String,
    profileImageRes: Int,
    uploads: List<Int>, // List of drawable resource IDs for uploaded photos
    followersCount: Int,
    clientsCount: Int,
    onEditProfileClick: () -> Unit,
    onUploadClick: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Profile Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = profileImageRes),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.Gray, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(text = userName, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = bio, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
            }

            Button(onClick = onEditProfileClick) {
                Text(text = "Edit Profile")
            }
        }

        // Stats Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat(label = "Uploads", count = uploads.size)
            ProfileStat(label = "Followers", count = followersCount)
            ProfileStat(label = "Clients", count = clientsCount)
        }

        // Uploads Grid
        Text(
            text = "Uploads",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(uploads.size) { index ->
                val imageRes = uploads[index]
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = "Uploaded Photo",
                    modifier = Modifier
                        .aspectRatio(1f)
                        .clickable { onUploadClick(index) },
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun ProfileStat(label: String, count: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count.toString(), style = MaterialTheme.typography.titleMedium)
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        userName = "Elias",
        bio = "Photographer | Traveler | Creator",
        profileImageRes = R.drawable.ic_profile,
        uploads = listOf(R.drawable.ic_placeholder, R.drawable.ic_placeholder1, R.drawable.placeholder3, R.drawable.ic_placeholder, R.drawable.ic_placeholder, R.drawable.ic_placeholder, R.drawable.ic_placeholder),
        followersCount = 150,
        clientsCount = 20,
        onEditProfileClick = {},
        onUploadClick = {}
    )
}
