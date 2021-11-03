package edu.upb.tumejorviaje.data.user.network

interface UserNetworkController {
    suspend fun login(usernamEmail: String, password: String)
    suspend fun register(
        username: String,
        password: String,
        email: String,
        description: String,
        photo: String
    )
}