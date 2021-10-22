package edu.upb.tumejorviaje.data.feed.persistency

import edu.upb.tumejorviaje.model.Post

class FeedPersistencyControllerImp: FeedPersistencyController {
    private var postList : List<Post> = listOf()

    override fun getAllPosts(): List<Post> {
        return postList
    }

    override fun savePosts(posts: List<Post>) {
        this.postList=posts
    }

    override fun searchPosts(query: String): List<Post> {
        return postList.filter{
            it.shortDescription.toLowerCase().contains(query.toLowerCase())
        }
    }
}