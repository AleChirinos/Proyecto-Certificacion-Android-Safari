package edu.upb.tumejorviaje.data.feed.network

import edu.upb.tumejorviaje.model.Post
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FeedNetworkControllerImp: FeedNetworkController {

    //127.0.0.1:1880
    //[ipWifiIPV4]:1880

    val client= Retrofit.Builder()
        .baseUrl("http://192.168.31.110:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FeedAPI::class.java)

    override suspend fun getAllPosts(): List<Post> {
        return client.getAllPosts()
    }
}