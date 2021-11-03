package edu.upb.tumejorviaje.data.profile

import android.content.Context
import android.util.Log
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkController
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyController
import edu.upb.tumejorviaje.isNetworkConnected
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileRepository (private val network : ProfileNetworkController, private val persistency : ProfilePersistencyController ) {

    fun getAllPostProfile() : Flow<List<Post>> {
        return persistency.getNewFeedList()
    }

    fun getUserProfile(): User?{
        return UserTempDataSource.myUser
    }

    fun updatePostsP() : Flow<Any>{
         return flow{
            try {
                val posts = network.getAllPostsProfile(UserTempDataSource.myUser.username)
                persistency.savePosts(posts)
                emit(posts)
            }catch (e : Exception){
                Log.e("ERROR", e.message!!)
            }
        }
    }
}