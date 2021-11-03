package edu.upb.tumejorviaje.ui.mainmenu.tabs.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkControllerImp
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistenceControllerImp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class FeedViewModel : ViewModel() {
    val feedRepository = FeedRepository(FeedNetworkControllerImp(), FeedPersistenceControllerImp())
    val post = feedRepository.getAllPostList().asLiveData(Dispatchers.IO)


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

    fun updateFeed(): Job {
        return feedRepository.updatePosts().launchIn(CoroutineScope(Dispatchers.IO))
    }


}