package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.TempDataSource

class FeedViewModel : ViewModel() {
    val posts = MutableLiveData(TempDataSource.getNewFeedList())
}