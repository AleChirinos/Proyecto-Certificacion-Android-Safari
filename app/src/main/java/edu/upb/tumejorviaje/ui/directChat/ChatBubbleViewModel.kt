package edu.upb.tumejorviaje.ui.directChat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.ChatDirectTempDataSource
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.data.directChat.DirectChatRepository
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkControllerImp
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceControllerImp
import edu.upb.tumejorviaje.model.SavedChat
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn

class ChatBubbleViewModel:ViewModel() {
    private val chatBubbleRepository=DirectChatRepository(DirectChatNetworkControllerImp(),DirectChatPersistenceControllerImp())
    val chatBubbles=chatBubbleRepository.getAllChatBubbles().asLiveData(Dispatchers.IO)

    fun updateChatBubbles(user: User): Job {
        return chatBubbleRepository.updateChatBubbles(getChatId(user)).launchIn(CoroutineScope(Dispatchers.IO))
    }

    val savedChat = MutableLiveData<SavedChat>()

    fun getChatId(user2: User): String {
        return UserTempDataSource.myUser.username + "_" + user2.username
    }
}