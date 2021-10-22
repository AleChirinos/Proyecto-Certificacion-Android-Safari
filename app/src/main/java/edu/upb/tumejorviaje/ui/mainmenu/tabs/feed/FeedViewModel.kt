package edu.upb.tumejorviaje.ui.mainmenu.tabs.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.TempDataSource
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkControllerImp
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistencyControllerImp

class FeedViewModel : ViewModel() {
    val feedRepository = FeedRepository(FeedNetworkControllerImp(), FeedPersistencyControllerImp())
    val post = feedRepository.getAllPostList().asLiveData()


    //    fun getAllPosts(context: Context) {
//        feedRepository.getAllPostList(context).onEach {
//            posts.postValue(it)
//        }.launchIn(CoroutineScope(Dispatchers.IO))
//    }


    fun searchPosts(query: String) {
        if (query.isNotBlank()) {
            feedRepository.searchPosts(query)
        } else {
            feedRepository.searchPosts("")
        }
    }


}