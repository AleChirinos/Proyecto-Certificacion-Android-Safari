package edu.upb.tumejorviaje.data.directChat.network

import edu.upb.tumejorviaje.model.ChatBubble

interface DirectChatNetworkController {
    suspend fun getAllChatBubbles():List<ChatBubble>
}