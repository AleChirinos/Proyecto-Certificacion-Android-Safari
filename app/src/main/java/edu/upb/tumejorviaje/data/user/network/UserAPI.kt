package edu.upb.tumejorviaje.data.user.network

import edu.upb.tumejorviaje.data.user.model.LoginRequest
import edu.upb.tumejorviaje.data.user.model.RegisterRequest
import edu.upb.tumejorviaje.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserAPI {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @POST("/register")
    suspend fun register(@Body registerRequest: RegisterRequest)

    @GET("/getUser")
    suspend fun getUser(@Query("usernamEmail") usernamEmail:String): List<User>
}