package edu.upb.tumejorviaje.data.feed.persistency

import edu.upb.tumejorviaje.model.Post

interface FeedPersistencyController {
    fun getAllPosts(): List<Post>
    fun savePosts(posts:List<Post>)
    fun searchPosts(query:String):List<Post>
}