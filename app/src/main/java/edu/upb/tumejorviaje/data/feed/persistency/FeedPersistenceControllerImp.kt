package edu.upb.tumejorviaje.data.feed.persistency

import edu.upb.tumejorviaje.App
import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.flow.Flow

class FeedPersistenceControllerImp: FeedPersistenceController {
    private val db= App.db

    override fun getAllPosts(): Flow<List<Post>> {
        return db.postsDao().getAllPosts()
    }

    override fun savePosts(posts: List<Post>) {
        db.postsDao().saveAllPosts(posts)
    }

    override fun searchPosts(query: String): List<Post> {
        return db.postsDao().searchPosts(query)
    }
}