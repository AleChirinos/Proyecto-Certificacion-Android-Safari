package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.User

object ChatDirectTempDataSource {
    private var chatBubbleList= mutableListOf(
        ChatBubble(1,"Esto ya no es divertido, es triste","9:50", UserTempDataSource.myUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(2,"Te pasaste de lanza con ese chiste","9:50", UserTempDataSource.otherUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(3,"Por favor, para con esto","9:51", UserTempDataSource.otherUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(4,"Lo siento, no lo volveré a hacer, es triste","9:50", UserTempDataSource.otherUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(5,"No quiero ofenderte","9:51", UserTempDataSource.otherUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(6,"Sabes que eres mi amigo","9:52", UserTempDataSource.otherUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(7,"Te perdono, amigo","9:52", UserTempDataSource.myUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(8,"El chiste estaba algo gracioso","9:53" ,UserTempDataSource.myUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser)),
        ChatBubble(9,"XDXDXD","9:53",UserTempDataSource.myUser.username, getChatId(UserTempDataSource.myUser, UserTempDataSource.otherUser))
    )

    fun getChatBubbleList():List<ChatBubble>{
        return chatBubbleList
    }
    fun setChatBubbleList(chatBubbleList:List<ChatBubble>){
        this.chatBubbleList=chatBubbleList.toMutableList()
    }

    // TODO: NUEVO
    fun getChatId(user1: User, user2: User): String {
        return user1.username + "_" + user2.username
    }
}