package edu.upb.tumejorviaje.ui.directChat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.data.directChat.DirectChatRepository
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkControllerImp
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceControllerImp
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.SavedChat
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

class ChatBubbleViewModel:ViewModel() {
    private val chatBubbleRepository=DirectChatRepository(DirectChatNetworkControllerImp(),DirectChatPersistenceControllerImp())

    val chatBubbles=MutableLiveData<List<ChatBubble>>(listOf())


    val savedChat = MutableLiveData<SavedChat>()

    fun updateChatBubbles(user: User): Job {
        return chatBubbleRepository.getAllChatBubblesForId(user.username).onEach{
            chatBubbles.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }

    fun saveNewBubble(message: String) {
        return chatBubbleRepository.addNewBubble(ChatBubble(0,message,System.currentTimeMillis().toString(),UserTempDataSource.myUser.username,savedChat.value!!.user.username))
    }


}