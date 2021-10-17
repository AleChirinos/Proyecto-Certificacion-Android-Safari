package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.ChatsTempDataSource

class ChatsViewModel : ViewModel() {
    val chats = MutableLiveData(ChatsTempDataSource.getChatList())
}