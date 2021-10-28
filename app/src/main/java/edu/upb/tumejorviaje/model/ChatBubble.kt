package edu.upb.tumejorviaje.model

import java.io.Serializable

data class ChatBubble (val textComment: String, val time: String,val profileImg: Int,val provenient:User) : Serializable{
}