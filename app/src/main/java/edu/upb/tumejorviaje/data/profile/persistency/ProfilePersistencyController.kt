package edu.upb.tumejorviaje.data.profile.persistency

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

interface ProfilePersistencyController {
    fun  getNewFeedList(username:String) : Flow<List<Post>>
    fun savePosts(posts : List<Post>)


}