package edu.upb.tumejorviaje.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource

class ChatBubbleViewModel:ViewModel() {
    val chatBubbles=MutableLiveData(ChatDirectTempDataSource.getChatBubbleList())
}