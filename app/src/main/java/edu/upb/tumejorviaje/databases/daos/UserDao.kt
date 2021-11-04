package edu.upb.tumejorviaje.databases.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUserList(): Flow<List<User>>

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    fun saveUser(userList:List<User>)

    @Query("SELECT * FROM user WHERE username=:username & password=:password")
    fun getUser(username:String,password:String):Flow<User>
}