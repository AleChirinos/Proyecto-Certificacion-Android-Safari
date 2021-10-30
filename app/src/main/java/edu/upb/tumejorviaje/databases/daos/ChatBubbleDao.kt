package edu.upb.tumejorviaje.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.upb.tumejorviaje.model.ChatBubble
import kotlinx.coroutines.flow.Flow

@Dao
interface ChatBubbleDao {
    @Query("SELECT * FROM chatbubble")
    fun getAllChatBubbles(): Flow<List<ChatBubble>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveChatBubbles(conversations: List<ChatBubble>)
}