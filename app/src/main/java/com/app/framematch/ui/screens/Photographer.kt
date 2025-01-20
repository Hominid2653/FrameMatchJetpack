// Photographer.kt

package com.app.framematch.ui.screens  // Changed package to 'model' to avoid conflicts

data class ProfilePhotographer(
    val id: Int,
    val name: String,
    val bio: String,
    val rating: Float,
    val posts: List<String>,  // The list of posts
    val profilePictureUrl: String
)

data class Post(
    val id: Int,
    val caption: String,
    val imageUrl: String,
)