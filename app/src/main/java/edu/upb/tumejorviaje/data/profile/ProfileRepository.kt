package edu.upb.tumejorviaje.data.profile

import android.content.Context
import android.util.Log
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkController
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkControllerImp
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyController
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyControllerImp
import edu.upb.tumejorviaje.isNetworkConnected
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProfileRepository (val network : ProfileNetworkController, val persistency : ProfilePersistencyController ) {

    fun getAllPostProfile(context : Context) : Flow<List<Post>> {
        return flow{
            emit(persistency.getNewFeedList())
            try {
                if (isNetworkConnected(context)){
                    val posts = network.getAllPostsProfile()
                    persistency.savePosts(posts)
                    emit(posts)
                }
            }catch (e : Exception){
                Log.e("ERROR", e.message!!)
            }
        }
    }

    fun getUserProfile(): User?{
        return persistency.getUser()
    }
}