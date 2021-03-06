package edu.upb.tumejorviaje.ui.mainmenu.tabs.profile

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.profile.ProfileRepository
import edu.upb.tumejorviaje.data.profile.network.ProfileNetworkControllerImp
import edu.upb.tumejorviaje.data.profile.persistency.ProfilePersistencyControllerImp
import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProfileViewModel : ViewModel() {
    private val profileRepository = ProfileRepository(ProfileNetworkControllerImp(), ProfilePersistencyControllerImp())
    val user=MutableLiveData(profileRepository.getUserProfile())
    val myPosts = MutableLiveData<List<Post>>(listOf())
    val userToShow=MutableLiveData(profileRepository.getUserProfile())




    /*fun getAllPostsProfile(context: Context){
        //profileRepository.getAllPostProfile(context).launchIn(CoroutineScope(Dispatchers.IO))
        profileRepository.getAllPostProfile(context).onEach {
            myPosts.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))

    }*/


    fun updatePostsProfile(username:String) :Job{
        return profileRepository.updatePostsP(username).onEach{
            myPosts.postValue(it)
        }
            .launchIn(CoroutineScope(Dispatchers.IO))
        }
}