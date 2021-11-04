package edu.upb.tumejorviaje.data.user.network

import edu.upb.tumejorviaje.data.user.model.LoginRequest
import edu.upb.tumejorviaje.data.user.model.RegisterRequest
import edu.upb.tumejorviaje.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserNetworkControllerImp : UserNetworkController{
    val client = Retrofit.Builder()
        .baseUrl("http://192.168.0.9:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(UserAPI::class.java)

    override suspend fun login(usernamEmail: String, password: String) {
        return client.login(LoginRequest(usernamEmail, password))
    }

    override suspend fun register(
        username: String,
        password: String,
        email: String,
        description: String,
        profileUrl: String
    ) {
        return client.register(RegisterRequest(username, password,email,description,profileUrl))
    }

    override suspend fun getUser(username: String, password: String): List<User> {
        return client.getUser(username)
    }


}