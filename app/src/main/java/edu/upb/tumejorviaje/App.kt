package edu.upb.tumejorviaje

import android.app.Application
import androidx.room.Room
import edu.upb.tumejorviaje.data.directChat.DirectChatRepository
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkController
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkControllerImp
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceController
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceControllerImp
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkController
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkControllerImp
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistenceController
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistenceControllerImp
import edu.upb.tumejorviaje.data.profile.ProfileRepository
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkController
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkControllerImp
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyController
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyControllerImp
import edu.upb.tumejorviaje.data.search.SearchRepository
import edu.upb.tumejorviaje.data.search.network.SearchNetworkController
import edu.upb.tumejorviaje.data.search.network.SearchNetworkControllerImp
import edu.upb.tumejorviaje.data.search.persistence.SearchPersistenceController
import edu.upb.tumejorviaje.data.search.persistence.SearchPersistenceControllerImp
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
        single<SearchPersistenceController>{SearchPersistenceControllerImp()}
        single<SearchNetworkController>{ SearchNetworkControllerImp() }
        single{SearchRepository(get(),get())}
        single<DirectChatPersistenceController>{ DirectChatPersistenceControllerImp() }
        single<DirectChatNetworkController>{ DirectChatNetworkControllerImp() }
        single{ DirectChatRepository(get(),get()) }
        single<ProfileNetworkController>{ ProfileNetworkControllerImp() }
        single<ProfilePersistencyController>{ ProfilePersistencyControllerImp() }
        single{ProfileRepository(get(),get())}
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