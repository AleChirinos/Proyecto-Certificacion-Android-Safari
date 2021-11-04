package edu.upb.tumejorviaje.data.directChat.model

data class BubbleChatRequest (val textComment: String,
                              val time: String,
                              val provenientUsername: String,
                              val provenientProfileUrl:String,
                              val chatId: String) {
}