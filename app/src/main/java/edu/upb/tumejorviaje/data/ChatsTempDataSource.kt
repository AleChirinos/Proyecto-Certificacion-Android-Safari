package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.SavedChat

object ChatsTempDataSource {
    private var chatsList = mutableListOf(
        SavedChat(
            chatName = "Maria Marcela",
            chatLastMessage = "Aún estoy esperando.",
            profileImg = R.drawable.ic_circle_profile_1
        ),
        SavedChat(
            chatName = "Rodrigo Cárdenas",
            chatLastMessage = "Espero funcione.",
            profileImg = R.drawable.ic_circle_profile_2
        ),
        SavedChat(
            chatName = "Daniel Delgado",
            chatLastMessage = "Ya lo sabía",
            profileImg = R.drawable.ic_circle_profile_3
        )
    )
    fun getChatList(): List<SavedChat> {
        return chatsList
    }

    fun setChatList(chatList: List<SavedChat>) {
        this.chatsList = chatList.toMutableList()
    }
}