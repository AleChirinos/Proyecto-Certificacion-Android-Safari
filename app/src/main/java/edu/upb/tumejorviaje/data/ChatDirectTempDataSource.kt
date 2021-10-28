package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.User

object ChatDirectTempDataSource {

    var user: User=User("dt.valdivia","Soy auditor financiero, con un master en big data y otro en accounting management", "https://vevico.files.wordpress.com/2019/08/tachuri-siete-colores.png?crop")
    private var user2: User=User("Sobble","Careta", "https://pbs.twimg.com/media/D8_Xkz9XYAAVC78.jpg")
    private var chatBubbleList= mutableListOf(

        ChatBubble("Esto ya no es divertido, es triste","9:50", R.drawable.ic_circle_profile_1,user),
        ChatBubble("Te pasaste de lanza con ese chiste","9:50",R.drawable.ic_circle_profile_1, user2),
        ChatBubble("Por favor, para con esto","9:51",R.drawable.ic_circle_profile_1,user2),
        ChatBubble("Lo siento, no lo volveré a hacer, es triste","9:50",R.drawable.ic_circle_profile_1,user2),
        ChatBubble("No quiero ofenderte","9:51",R.drawable.ic_circle_profile_1,user2),
        ChatBubble("Sabes que eres mi amigo","9:52",R.drawable.ic_circle_profile_1,user2),
        ChatBubble("Te perdono, amigo","9:52",R.drawable.ic_circle_profile_1,user),
        ChatBubble("El chiste estaba algo gracioso","9:53",R.drawable.ic_circle_profile_1,user),
        ChatBubble("XDXDXD","9:53",R.drawable.ic_circle_profile_1,user)
    )

    fun getChatBubbleList():List<ChatBubble>{
        return chatBubbleList
    }
    fun setChatBubbleList(chatBubbleList:List<ChatBubble>){
        this.chatBubbleList=chatBubbleList.toMutableList()
    }

}