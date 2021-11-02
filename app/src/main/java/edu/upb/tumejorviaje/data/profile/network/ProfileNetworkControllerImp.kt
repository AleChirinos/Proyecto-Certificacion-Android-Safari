package edu.upb.tumejorviaje.data.profile.network

import edu.upb.tumejorviaje.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ProfileNetworkControllerImp : ProfileNetworkController{
    val client = Retrofit.Builder()
        .baseUrl("https://192.168.0.11:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProfileAPI::class.java)

    override suspend fun getAllPostsProfile() : List<Post>{
         return client.getAllPostsProfile()
    }
}