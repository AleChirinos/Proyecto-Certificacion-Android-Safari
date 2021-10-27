package edu.upb.tumejorviaje.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostsDao {
    @Query("SELECT * FROM post")
    fun getAllPosts(): Flow<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllPosts(posts: List<Post>)

    @Query("SELECT * FROM post WHERE shortDescription LIKE :query AND publisher LIKE :query")
    fun searchPosts(query: String): List<Post>
}