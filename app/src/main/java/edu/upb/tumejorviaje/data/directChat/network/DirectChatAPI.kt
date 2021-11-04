package edu.upb.tumejorviaje.data.directChat.network

import edu.upb.tumejorviaje.data.directChat.model.BubbleChatRequest
import edu.upb.tumejorviaje.model.ChatBubble
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface DirectChatAPI {
    @GET("/directChatBubbles")
    suspend fun getAllChatBubbles(@Query("chatId")chatId: String):List<ChatBubble>

    @POST("/directChatBubbleAdd")
    suspend fun addChatBubble(@Body bubbleChatRequest:BubbleChatRequest)
}