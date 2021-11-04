package edu.upb.tumejorviaje.data.directChat.network

import edu.upb.tumejorviaje.model.ChatBubble

interface DirectChatNetworkController {
    suspend fun getAllChatBubblesForChatId(chatId: String):List<ChatBubble>
    suspend fun addChatBubble(chatBubble: ChatBubble)
}