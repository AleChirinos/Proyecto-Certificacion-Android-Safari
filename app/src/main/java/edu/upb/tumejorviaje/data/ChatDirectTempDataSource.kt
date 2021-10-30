package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.R
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.User

object ChatDirectTempDataSource {

    var user: User=User("dt.valdivia","Soy auditor financiero, con un master en big data y otro en accounting management", "https://vevico.files.wordpress.com/2019/08/tachuri-siete-colores.png?crop")
    private var user2: User=User("Sobble","Careta", "https://pbs.twimg.com/media/D8_Xkz9XYAAVC78.jpg")
    private var chatBubbleList= mutableListOf(

        ChatBubble(1,"Esto ya no es divertido, es triste","9:50", R.drawable.ic_circle_profile_1,user),
        ChatBubble(2,"Te pasaste de lanza con ese chiste","9:50",R.drawable.ic_circle_profile_1, user2),
        ChatBubble(3,"Por favor, para con esto","9:51",R.drawable.ic_circle_profile_1,user2),
        ChatBubble(4,"Lo siento, no lo volveré a hacer, es triste","9:50",R.drawable.ic_circle_profile_1,user2),
        ChatBubble(5,"No quiero ofenderte","9:51",R.drawable.ic_circle_profile_1,user2),
        ChatBubble(6,"Sabes que eres mi amigo","9:52",R.drawable.ic_circle_profile_1,user2),
        ChatBubble(7,"Te perdono, amigo","9:52",R.drawable.ic_circle_profile_1,user),
        ChatBubble(8,"El chiste estaba algo gracioso","9:53",R.drawable.ic_circle_profile_1,user),
        ChatBubble(9,"XDXDXD","9:53",R.drawable.ic_circle_profile_1,user)
    )

    fun getChatBubbleList():List<ChatBubble>{
        return chatBubbleList
    }
    fun setChatBubbleList(chatBubbleList:List<ChatBubble>){
        this.chatBubbleList=chatBubbleList.toMutableList()
    }

}