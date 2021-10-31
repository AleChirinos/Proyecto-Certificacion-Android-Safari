package edu.upb.tumejorviaje.ui.mainmenu.tabs.upload

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import edu.upb.tumejorviaje.data.feed.FeedRepository
import edu.upb.tumejorviaje.data.feed.network.FeedNetworkControllerImp
import edu.upb.tumejorviaje.data.feed.persistency.FeedPersistencyControllerImp
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.ui.mainmenu.tabs.feed.FeedViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class UploadPhotoViewModel: ViewModel() {
    val photoPassed = MutableLiveData(false)




}