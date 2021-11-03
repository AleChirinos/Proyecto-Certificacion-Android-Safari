package edu.upb.tumejorviaje.data.user.network

import edu.upb.tumejorviaje.data.user.model.LoginRequest
import edu.upb.tumejorviaje.data.user.model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest)

    @POST("/register")
    suspend fun register(@Body registerRequest: RegisterRequest)
}