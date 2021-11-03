package edu.upb.tumejorviaje.data.user.network

import edu.upb.tumejorviaje.data.user.model.LoginRequest
import edu.upb.tumejorviaje.data.user.model.RegisterRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp : UserNetworkController{
    val client = Retrofit.Builder()
        .baseUrl("http://192.168.31.110:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    override suspend fun login(username: String, password: String) {
        return client.login(LoginRequest(username, password))
    }

    override suspend fun register(username: String, password: String) {
        return client.register(RegisterRequest(username, password))
    }
}