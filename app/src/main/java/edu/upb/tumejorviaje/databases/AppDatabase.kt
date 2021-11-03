package edu.upb.tumejorviaje.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.upb.tumejorviaje.data.feed.Converters
import edu.upb.tumejorviaje.databases.daos.ChatBubbleDao
import edu.upb.tumejorviaje.databases.daos.PostsDao
import edu.upb.tumejorviaje.databases.daos.ProfilePostsDao
import edu.upb.tumejorviaje.databases.daos.SearchUsersDao
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User

@Database(entities=[Post::class, ChatBubble::class, User::class],version=1)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun postsDao(): PostsDao
    abstract fun chatBubbleDao(): ChatBubbleDao
    abstract fun profilePostsDao(): ProfilePostsDao
    abstract fun searchDao(): SearchUsersDao
}