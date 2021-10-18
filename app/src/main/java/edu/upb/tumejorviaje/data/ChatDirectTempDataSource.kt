package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.ChatBubble

object ChatDirectTempDataSource {
    private var chatBubbleList= mutableListOf(
        ChatBubble("Esto ya no es divertido, es triste","9:50", R.drawable.ic_circle_profile_1),
        ChatBubble("Te pasaste de lanza con ese chiste","9:50",R.drawable.ic_circle_profile_1),
        ChatBubble("Por favor, para con esto","9:51",R.drawable.ic_circle_profile_1),
        ChatBubble("Lo siento, no lo volveré a hacer, es triste","9:50",R.drawable.ic_circle_profile_1),
        ChatBubble("No quiero ofenderte","9:51",R.drawable.ic_circle_profile_1),
        ChatBubble("Sabes que eres mi amigo","9:52",R.drawable.ic_circle_profile_1),
        ChatBubble("Te perdono, amigo","9:52",R.drawable.ic_circle_profile_1),
        ChatBubble("El chiste estaba algo gracioso","9:53",R.drawable.ic_circle_profile_1),
        ChatBubble("XDXDXD","9:53",R.drawable.ic_circle_profile_1)
    )

    fun getChatBubbleList():List<ChatBubble>{
        return chatBubbleList
    }
    fun setChatBubbleList(chatBubbleList:List<ChatBubble>){
        this.chatBubbleList=chatBubbleList.toMutableList()
    }

}