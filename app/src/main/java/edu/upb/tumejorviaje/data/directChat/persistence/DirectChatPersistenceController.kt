package edu.upb.tumejorviaje.data.directChat.persistence

import edu.upb.tumejorviaje.model.ChatBubble
import kotlinx.coroutines.flow.Flow

interface DirectChatPersistenceController {
    fun getAllChatBubbles(): Flow<List<ChatBubble>>
    fun saveChatBubbles(conversations:List<ChatBubble>)
}