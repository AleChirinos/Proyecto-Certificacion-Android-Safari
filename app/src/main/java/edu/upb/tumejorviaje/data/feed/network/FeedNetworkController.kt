package edu.upb.tumejorviaje.data.feed.network

import edu.upb.tumejorviaje.model.Post

interface FeedNetworkController {
    suspend fun getAllPosts():List<Post>
    suspend fun addAPost(post: Post)
}