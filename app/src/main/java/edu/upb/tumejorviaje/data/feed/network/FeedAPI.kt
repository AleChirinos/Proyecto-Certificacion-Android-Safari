package edu.upb.tumejorviaje.data.feed.network

import edu.upb.tumejorviaje.model.Post
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedAPI {
    @GET("/feedPosts")
    suspend fun getAllPosts():List<Post>

    @POST("/feedPosts/1928398")
    suspend fun addNewPost():List<Post>
}