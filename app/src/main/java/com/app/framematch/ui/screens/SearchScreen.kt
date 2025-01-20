@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.text.BasicTextField
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
fun SearchScreen(
    onSearchResultClick: (String) -> Unit,
    onProfileClick: () -> Unit
) {
    var searchQuery by remember { mutableStateOf(TextFieldValue()) }
    val searchResults = listOf("Photographer 1", "Photographer 2", "Photographer 3", "Photographer 4") // Sample search results
    val profileImages = listOf(R.drawable.profile1, R.drawable.profile2, R.drawable.profile3, R.drawable.profile4) // Sample images

    Column(modifier = Modifier.fillMaxSize()) {

        // Header Bar
        TopAppBar(
            title = { Text(text = "Search") },
            actions = {
                IconButton(onClick = onProfileClick) {
                    Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "Profile", tint = Color.White)
                }
            }
        )

        // Search Bar
        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.medium)
                .padding(12.dp),
            decorationBox = { innerTextField ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search", tint = Color(0xFF1F2B6C))
                    Spacer(modifier = Modifier.width(8.dp))
                    innerTextField()
                }
            }
        )

        // Search Results Grid
        Spacer(modifier = Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 3 items per row
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(searchResults.filter { it.contains(searchQuery.text, ignoreCase = true) }) { result ->
                SearchResultThumbnail(result, profileImages[searchResults.indexOf(result)], onSearchResultClick)
            }
        }
    }
}

@Composable
fun SearchResultThumbnail(result: String, imageResId: Int, onResultClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onResultClick(result) }
            .height(150.dp)
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(Color.LightGray) // Placeholder background color
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = "Photographer Profile",
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                .background(Color.Gray) // Ensuring rounded corners for image
                .padding(4.dp),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .background(Color.Black.copy(alpha = 0.6f))
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = result, color = Color.White, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        onSearchResultClick = {},
        onProfileClick = {}
    )
}
