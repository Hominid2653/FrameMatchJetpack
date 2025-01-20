@file:OptIn(ExperimentalMaterial3Api::class)

package com.app.framematch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.framematch.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchPicksScreen(
    onPickClick: (String) -> Unit,
    onBackClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {

        // Header Bar
        TopAppBar(
            title = { Text(text = "Recommended for You") },
            navigationIcon = {
                IconButton(onClick = onBackClick) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            }
        )

        // Grid of Picks
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) { index -> // Replace 10 with dynamic data count
                SearchPickItem(
                    name = "Photographer $index",
                    imageRes = R.drawable.ic_profile, // Replace with real image resources
                    onClick = { onPickClick("Photographer $index") }
                )
            }
        }
    }
}

@Composable
fun SearchPickItem(name: String, imageRes: Int, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF0F0F0), shape = MaterialTheme.shapes.medium)
            .clickable(onClick = onClick)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(120.dp)
                .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = name,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchPicksScreenPreview() {
    SearchPicksScreen(
        onPickClick = {},
        onBackClick = {}
    )
}
