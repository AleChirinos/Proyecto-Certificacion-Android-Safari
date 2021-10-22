package edu.upb.tumejorviaje.data.feed

import android.util.Log
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkController
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistencyController
import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class FeedRepository     (
    val network: FeedNetworkController,
    val persistency: FeedPersistencyController
) {
    fun getAllPostList(): Flow<List<Post>>{
        return flow {
            emit(persistency.getAllPosts())
            try{
                val posts=network.getAllPosts()
                persistency.savePosts(posts)
                emit(posts)
            } catch (e:Exception){
                Log.e("ERROR",e.message!!)
            }
        }
    }

    fun searchPosts(query:String):List<Post>{
        return persistency.searchPosts(query)
    }

}