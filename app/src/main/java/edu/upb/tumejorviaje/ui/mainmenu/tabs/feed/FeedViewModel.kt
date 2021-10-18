package edu.upb.tumejorviaje.ui.mainmenu.tabs.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.TempDataSource

class FeedViewModel : ViewModel() {
    val post = MutableLiveData(TempDataSource.getNewFeedList())
}