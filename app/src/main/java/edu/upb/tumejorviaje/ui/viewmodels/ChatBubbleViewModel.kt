package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource
import edu.upb.tumejorviaje.model.SavedChat

class ChatBubbleViewModel:ViewModel() {
    val chatBubbles=MutableLiveData(ChatDirectTempDataSource.getChatBubbleList())
    val savedChat = MutableLiveData<SavedChat>()
}