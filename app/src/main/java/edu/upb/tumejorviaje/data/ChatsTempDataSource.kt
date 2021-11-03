package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.model.SavedChat

object ChatsTempDataSource {
    private var chatsList = mutableListOf(
        SavedChat(
            user = UserTempDataSource.otherUser,
            chatLastMessage = "Aún estoy esperando.",
        ),
        SavedChat(
            user = UserTempDataSource.otherUser2,
            chatLastMessage = "Espero funcione."
        ),
        SavedChat(
            user = UserTempDataSource.otherUser3,
            chatLastMessage = "Ya lo sabía"
        )
    )

    fun getChatList(): List<SavedChat> {
        return chatsList
    }

    fun setChatList(chatList: List<SavedChat>) {
        this.chatsList = chatList.toMutableList()
    }
}