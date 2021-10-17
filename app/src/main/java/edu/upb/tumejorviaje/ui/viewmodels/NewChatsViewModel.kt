package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.TempDataNewChats

class NewChatsViewModel : ViewModel() {
    val newChats = MutableLiveData(TempDataNewChats.getNewChatList())
}