package edu.upb.tumejorviaje.data.profile.persistency

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User

interface ProfilePersistencyController {
    fun getNewFeedList() : List<Post>
    fun savePosts(posts : List<Post>)
    fun getUser(): User?
}