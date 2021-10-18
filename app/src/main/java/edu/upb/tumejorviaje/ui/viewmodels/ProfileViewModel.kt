package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.TempDataProfile

class ProfileViewModel : ViewModel() {
    val myPosts = MutableLiveData(TempDataProfile.getNewFeedList())

}