package edu.upb.tumejorviaje.data.feed.persistency

import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.flow.Flow

interface FeedPersistencyController {
    fun getAllPosts(): Flow<List<Post>>
    fun savePosts(posts:List<Post>)
    fun searchPosts(query:String):List<Post>
}