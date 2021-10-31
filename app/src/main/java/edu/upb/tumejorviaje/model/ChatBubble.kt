package edu.upb.tumejorviaje.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class ChatBubble(
    @PrimaryKey val id:Int,
    val textComment: String,
    val time: String,
    val provenientUsername: String,
    val chatId: String
) : Serializable {
}