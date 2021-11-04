package edu.upb.tumejorviaje.data.directChat

import android.util.Log
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkController
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceController
import edu.upb.tumejorviaje.model.ChatBubble
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class DirectChatRepository(val network:DirectChatNetworkController, val persistence: DirectChatPersistenceController) {


    fun getAllChatBubbles(): Flow<List<ChatBubble>>{
        return persistence.getAllChatBubbles()
    }

    fun updateAllChatBubblesForId(chatId: String):Flow<Any>{
        return flow{
            try {
                val chatBubbles = network.getAllChatBubblesForChatId(chatId)
                persistence.saveChatBubbles(chatBubbles)
                emit(chatBubbles)
            } catch (e: Exception) {
                Log.e("ERROR", e.message!!)
            }
        }
    }

    fun getAllChatBubblesForId(chatId: String):Flow<List<ChatBubble>>{
        return persistence.getAllChatBubblesForChatId(chatId)
    }

    fun addNewBubble(chatBubble: ChatBubble):Flow<Any> {
        return flow {
            persistence.addChatBubble(chatBubble)
        }
    }



}