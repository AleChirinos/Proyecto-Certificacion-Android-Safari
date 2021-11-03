package edu.upb.tumejorviaje.data.search.network

import edu.upb.tumejorviaje.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SearchNetworkControllerImp:SearchNetworkController {
    val client = Retrofit.Builder()
        .baseUrl("http://192.168.0.9:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SearchAPI::class.java)

    override suspend fun getUsersProfile(username: String): List<User> {
        return client.getAllSelectedUsersList(username)
    }

    override suspend fun getAllUsersList(): List<User> {
        return client.getAllUsersList()
    }
}