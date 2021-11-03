package edu.upb.tumejorviaje.databases.daos

import androidx.room.*
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchUsersDao {
    @Query("SELECT * FROM user")
    fun getAllUserList(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllUsers(posts: List<User>)

    @Query("DELETE FROM user")
    fun deleteAll()


}