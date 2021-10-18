package edu.upb.tumejorviaje.ui.mainmenu.tabs.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.TempDataProfile

class ProfileViewModel : ViewModel() {
    val myPosts = MutableLiveData(TempDataProfile.getNewFeedList())
    val user=MutableLiveData(TempDataProfile.getUser())
}