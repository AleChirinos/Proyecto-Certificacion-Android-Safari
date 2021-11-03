package edu.upb.tumejorviaje.data.feed.network

import edu.upb.tumejorviaje.model.AddPostRequest
import edu.upb.tumejorviaje.model.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface FeedAPI {
    @GET("/feedPosts")
    suspend fun getAllPosts():List<Post>

    @POST("/registerFeedPosts")
    suspend fun addNewPost(@Body addPostRequest: AddPostRequest)
}