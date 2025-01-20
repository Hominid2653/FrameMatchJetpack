package com.app.framematch.ui.components

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
import com.app.framematch.ui.screens.Job1

@Composable
fun JobCard(
    job1: Job1, // Accept Job1 object as a parameter
    onClick: () -> Unit, // Handle onClick for job details navigation
    showApplyButton: Boolean = false, // Optional parameter to show/hide apply button
    onApplyClick: (() -> Unit)? = null // Optional apply button action
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = job1.title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Status: ${job1.status}",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Budget: ${job1.budget}",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )

            if (showApplyButton) {
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { onApplyClick?.invoke() },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F2B6C))
                ) {
                    Text(text = "Apply", color = Color.White)
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun JobCardPreview() {
    JobCard(
        job1 = Job1(title = "Wedding Photoshoot", budget = 500, location = "Nairobi", description = "Looking for a photographer to cover a wedding.", status = "Open", budget2 = "$500"),
        onClick = { /* Handle click */ },
        showApplyButton = true,
        onApplyClick = { /* Handle Apply */ }
    )
}
