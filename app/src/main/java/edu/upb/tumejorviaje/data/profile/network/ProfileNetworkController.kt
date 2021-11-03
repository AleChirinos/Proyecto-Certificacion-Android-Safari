package edu.upb.tumejorviaje.data.profile.network

import edu.upb.tumejorviaje.model.Post

interface ProfileNetworkController {
    suspend fun getAllPostsProfile() : List<Post>
}