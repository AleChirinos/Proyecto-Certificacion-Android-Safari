package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.NewChat
import edu.upb.tumejorviaje.model.SavedChat

object TempDataNewChats {
    private var chatsList = mutableListOf(
        NewChat(
            chatName = "Carlos Villagran",
        ),
        NewChat(
            chatName = "Carlota Muñoz",
        ),
        NewChat(
            chatName = "Carmela Nariño",
        ),
        NewChat(
            chatName = "Damian Dario",
        ),
        NewChat(
            chatName = "Esteban Espinoza",
        ),
        NewChat(
            chatName = "Fabio Fenandez",
        ),
        NewChat(
            chatName = "Gabriel Gallardo",
        ),
        NewChat(
            chatName = "Inés Ireneo",
        )
    )
    fun getNewChatList(): List<NewChat> {
        return chatsList
    }

    fun setNewChatList(chatList: List<NewChat>) {
        this.chatsList = chatList.toMutableList()
    }
}