package edu.upb.tumejorviaje.ui.mainmenu.tabs.upload

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.model.Post
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent.inject

class UploadPhotoViewModel: ViewModel() {

    val feedRepository by inject(FeedRepository::class.java)
    fun savePost(post: Post): Job {
        return feedRepository.addPost(post).launchIn(CoroutineScope(Dispatchers.Main))
    }

    val photoPassed = MutableLiveData(false)
    val valid=MutableLiveData(false)




}