package edu.upb.tumejorviaje.data.user.model

data class RegisterRequest(
    val username: String,
    val password: String,
    val email: String,
    val description: String,
    val profileUrl: String
)