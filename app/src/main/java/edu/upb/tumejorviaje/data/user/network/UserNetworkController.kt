package edu.upb.tumejorviaje.data.user.network

import edu.upb.tumejorviaje.model.User

interface UserNetworkController {
    suspend fun login(usernamEmail: String, password: String)
    suspend fun register(
        username: String,
        password: String,
        email: String,
        description: String,
        profileUrl: String
    )

    suspend fun getUser(username: String, password: String): List<User>
}