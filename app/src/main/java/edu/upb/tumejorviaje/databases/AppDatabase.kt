package edu.upb.tumejorviaje.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.upb.tumejorviaje.databases.daos.*
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User

@Database(entities=[Post::class, ChatBubble::class, User::class],version=1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun postsDao(): PostsDao
    abstract fun chatBubbleDao(): ChatBubbleDao
    abstract fun profilePostsDao(): ProfilePostsDao
    abstract fun searchDao(): SearchUsersDao
    abstract fun userDao(): UserDao

}