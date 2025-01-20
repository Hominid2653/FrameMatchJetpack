//@file:OptIn(ExperimentalMaterial3Api::class)
//
//package com.app.framematch.ui.screens
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import com.app.framematch.R
//
//@Composable
//fun DrawerContent(
//    username: String,
//    email: String,
//    profileImageRes: Int,
//    onNavigateTo: (String) -> Unit,
//    onLogout: () -> Unit
//) {
//    Column(modifier = Modifier.fillMaxSize()) {
//        // User Information
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Image(
//                painter = painterResource(id = profileImageRes),
//                contentDescription = "User Avatar",
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(CircleShape)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Column {
//                Text(text = username, style = MaterialTheme.typography.titleMedium)
//                Text(text = email, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
//            }
//        }
//
//        Divider(color = Color.Gray, thickness = 1.dp)
//
//        // Drawer Items
//        val drawerItems = listOf(
//            Triple("Profile", R.drawable.ic_profile, "profile"),
//            Triple("Uploads", R.drawable.ic_uploads, "uploads"),
//            Triple("Followers and Clients", R.drawable.ic_followers_clients, "followers"),
//            Triple("Edit Profile", R.drawable.ic_edit_profile, "editProfile"),
//            Triple("Switch Account", R.drawable.ic_switch_account, "switchAccount"),
//            Triple("View Analytics", R.drawable.ic_analytics, "analytics"),
//            Triple("Logout", R.drawable.ic_logout, null)
//        )
//
//        drawerItems.forEach { (label, iconRes, destination) ->
//            if (destination != null) {
//                DrawerItem(label = label, iconRes = iconRes) {
//                    onNavigateTo(destination)
//                }
//            } else {
//                DrawerItem(label = label, iconRes = iconRes, onClick = onLogout)
//            }
//        }
//    }
//}
//
//@Composable
//fun DrawerItem(label: String, iconRes: Int, onClick: () -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(12.dp)
//            .clickable { onClick() },
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Icon(
//            painter = painterResource(id = iconRes),
//            contentDescription = label,
//            tint = Color(0xFF1F2B6C),
//            modifier = Modifier.size(24.dp)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//        Text(
//            text = label,
//            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium),
//            color = Color.Black
//        )
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DrawerContentPreview() {
//    DrawerContent(
//        username = "John Doe",
//        email = "johndoe@example.com",
//        profileImageRes = R.drawable.ic_profile_placeholder, // Replace with a valid drawable resource
//        onNavigateTo = {},
//        onLogout = {}
//    )
//}
