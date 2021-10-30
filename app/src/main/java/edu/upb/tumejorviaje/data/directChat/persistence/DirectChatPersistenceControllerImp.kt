package edu.upb.tumejorviaje.data.directChat.persistence

import edu.upb.tumejorviaje.App
import edu.upb.tumejorviaje.model.ChatBubble
import kotlinx.coroutines.flow.Flow

class DirectChatPersistenceControllerImp: DirectChatPersistenceController{
    private val db= App.db
    override fun getAllChatBubbles(): Flow<List<ChatBubble>> {
        return db.chatBubbleDao().getAllChatBubbles()
    }

    override fun saveChatBubbles(conversations: List<ChatBubble>) {
        db.chatBubbleDao().saveChatBubbles(conversations)
    }
}