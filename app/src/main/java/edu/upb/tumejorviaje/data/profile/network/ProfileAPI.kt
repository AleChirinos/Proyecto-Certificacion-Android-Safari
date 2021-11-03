package edu.upb.tumejorviaje.data.profile.network

import edu.upb.tumejorviaje.model.Post
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ProfileAPI {
    @GET("/postsprofile")
    suspend fun getAllPostsProfile (@Query("publisher") publisher:String) : List<Post>


    @POST("/post/173867482")
    suspend fun getUserProfile () : List<Post>
}