package edu.upb.tumejorviaje.data.directChat.network

import edu.upb.tumejorviaje.model.ChatBubble
import retrofit2.http.GET

interface DirectChatAPI {
    @GET("/directChatBubbles")
    suspend fun getAllChatBubbles():List<ChatBubble>
}