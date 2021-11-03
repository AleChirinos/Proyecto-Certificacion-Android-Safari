package edu.upb.tumejorviaje.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfilePostsDao {
    @Query("SELECT * FROM post")
    fun getAllPostsProfile(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllPosts(posts: List<Post>)


}