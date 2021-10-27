package edu.upb.tumejorviaje

import android.app.Application
import androidx.room.Room
import edu.upb.tumejorviaje.databases.AppDatabase
import org.koin.dsl.module

class App:Application() {
    companion object {
        lateinit var db: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
         db= Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()
    }
}