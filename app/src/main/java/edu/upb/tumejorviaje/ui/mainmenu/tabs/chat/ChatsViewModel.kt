package edu.upb.tumejorviaje.ui.mainmenu.tabs.chat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.ChatsTempDataSource

class ChatsViewModel : ViewModel() {
    val chats = MutableLiveData(ChatsTempDataSource.getChatList())
}