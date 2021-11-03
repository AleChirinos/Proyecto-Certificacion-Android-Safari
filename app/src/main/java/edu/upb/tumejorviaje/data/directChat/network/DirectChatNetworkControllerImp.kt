package edu.upb.tumejorviaje.data.directChat.network

import edu.upb.tumejorviaje.model.ChatBubble
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DirectChatNetworkControllerImp:DirectChatNetworkController {
    val client= Retrofit.Builder()
        .baseUrl("http://192.168.0.9:1880")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(DirectChatAPI::class.java)

    override suspend fun getAllChatBubblesForChatId(chatId: String): List<ChatBubble> {
        return client.getAllChatBubbles(chatId)
    }
}