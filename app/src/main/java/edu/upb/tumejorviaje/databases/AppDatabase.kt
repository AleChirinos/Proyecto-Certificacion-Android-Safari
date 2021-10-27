package edu.upb.tumejorviaje.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.upb.tumejorviaje.databases.daos.PostsDao
import edu.upb.tumejorviaje.model.Post

@Database(entities=[Post::class],version=1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun postsDao(): PostsDao
}