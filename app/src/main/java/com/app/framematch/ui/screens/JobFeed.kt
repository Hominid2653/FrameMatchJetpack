package com.app.framematch.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.framematch.ui.components.JobCard

@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun JobFeedScreen(
    job1s: List<Job1>, // Accept job list as parameter
    onJobClick: (Job1) -> Unit, // Callback when a job card is clicked
    onApplyClick: (Job1) -> Unit // Callback when Apply button is clicked
) {
    var searchQuery by remember { mutableStateOf("") }
    var locationFilter by remember { mutableStateOf("") }
    var budgetFilter by remember { mutableStateOf(0f) }
    var job1List by remember { mutableStateOf(job1s) }

    // Filter jobs based on search query and filters
    job1List = job1s.filter {
        it.title.contains(searchQuery, ignoreCase = true) &&
                (locationFilter.isEmpty() || it.location.contains(locationFilter, ignoreCase = true)) &&
                it.budget >= budgetFilter
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Job Feed") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color(0xFF1F2B6C))
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Search Bar
            BasicTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { /* Handle search */ }),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Gray.copy(alpha = 0.1f), RoundedCornerShape(8.dp)),
                textStyle = LocalTextStyle.current.copy(fontSize = 18.sp)
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Filters
            Text("Filters", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            LocationFilter(locationFilter) { locationFilter = it }
            Spacer(modifier = Modifier.height(8.dp))
            BudgetFilter(budgetFilter) { budgetFilter = it }

            Spacer(modifier = Modifier.height(16.dp))

            // Job Grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize()
            ) {
                items(job1List.size) { index ->
                    // Provide the onClick lambda function for JobCard
                    JobCard(
                        job1 = job1List[index],
                        onClick = { onJobClick(job1List[index]) },
                        onApplyClick = { onApplyClick(job1List[index]) }
                    )
                }
            }
        }
    }
}

@Composable
fun LocationFilter(locationFilter: String, onLocationChange: (String) -> Unit) {
    OutlinedTextField(
        value = locationFilter,
        onValueChange = onLocationChange,
        label = { Text("Location") },
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun BudgetFilter(budgetFilter: Float, onBudgetChange: (Float) -> Unit) {
    Slider(
        value = budgetFilter,
        onValueChange = onBudgetChange,
        valueRange = 0f..1000f,
        modifier = Modifier.fillMaxWidth(),
        steps = 10
    )
}

@Preview(showBackground = true)
@Composable
fun JobFeedScreenPreview() {
    val dummyJobList = listOf(
        Job1("Wedding Photoshoot", 500, "Nairobi", "Looking for a photographer to cover a wedding.", "Open", "$500"),
        Job1("Product Photography", 200, "Mombasa", "Need product shots for an online store.", "Open", "$200"),
        Job1("Family Portraits", 300, "Kisumu", "Looking for a photographer for family portraits.", "Closed", "$300")
    )
    JobFeedScreen(
        job1s = dummyJobList,
        onJobClick = { /* Handle job click */ },
        onApplyClick = { /* Handle apply click */ }
    )
}
