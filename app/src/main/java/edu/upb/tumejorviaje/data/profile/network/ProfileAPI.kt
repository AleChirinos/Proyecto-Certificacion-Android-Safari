package edu.upb.tumejorviaje.data.profile.network

import edu.upb.tumejorviaje.model.Post
import retrofit2.http.GET
import retrofit2.http.POST

interface ProfileAPI {
    @GET("/postsprofile")
    suspend fun getAllPostsProfile () : List<Post>

    @POST("/post/173867482")
    suspend fun getUserProfile () : List<Post>
}