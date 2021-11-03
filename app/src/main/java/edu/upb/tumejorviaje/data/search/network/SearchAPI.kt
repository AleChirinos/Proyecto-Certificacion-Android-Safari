package edu.upb.tumejorviaje.data.search.network

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {
    @GET("/usersSelected")
    suspend fun getAllSelectedUsersList (@Query("username") username:String) : List<User>

    @GET("/usersAll")
    suspend fun getAllUsersList () : List<User>
}