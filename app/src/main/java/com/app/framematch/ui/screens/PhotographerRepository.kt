
package com.app.framematch.ui.screens

object PhotographerRepository {

    // Mocked list of saved photographers
    fun getSavedPhotographers(): List<Photographer> {
        return listOf(
            Photographer(
                id = 1,
                name = "John Doe",
                profilePictureUrl = "https://example.com/profile1.jpg",
                bio = "Specializes in landscape and nature photography.",
                rating = 4.5f,
                portfolio = TODO()
            ),
            Photographer(
                id = 2,
                name = "Jane Smith",
                profilePictureUrl = "https://example.com/profile2.jpg",
                bio = "Expert in portrait and event photography.",
                rating = 4.7f,
                portfolio = TODO()
            ),
            Photographer(
                id = 3,
                name = "Carlos Ruiz",
                profilePictureUrl = "https://example.com/profile3.jpg",
                bio = "Passionate about architecture and cityscape photography.",
                rating = 4.3f,
                portfolio = TODO()
            )
        )
    }
}
