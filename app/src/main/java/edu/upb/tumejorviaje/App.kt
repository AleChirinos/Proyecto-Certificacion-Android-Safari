package edu.upb.tumejorviaje

import android.app.Application
import androidx.room.Room
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkController
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkControllerImp
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistenceController
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistenceControllerImp
import edu.upb.tumejorviaje.data.user.UserRepository
import edu.upb.tumejorviaje.data.user.network.UserNetworkController
import edu.upb.tumejorviaje.data.user.network.UserNetworkControllerImp
import edu.upb.tumejorviaje.databases.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App:Application() {
    companion object {
        lateinit var db: AppDatabase
    }

    val appModule = module {
        single<FeedPersistenceController> { FeedPersistenceControllerImp() }
        single<FeedNetworkController> { FeedNetworkControllerImp() }
        single { FeedRepository(get(),get()) }
        single<UserNetworkController>{UserNetworkControllerImp()}
        single { UserRepository(get()) }
    }

    override fun onCreate() {
        super.onCreate()
         db= Room.databaseBuilder(this, AppDatabase::class.java, "app-db").build()
        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(appModule)
        }
    }
}