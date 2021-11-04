package edu.upb.tumejorviaje.ui.directChat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.data.directChat.DirectChatRepository
import edu.upb.tumejorviaje.data.directChat.network.DirectChatNetworkControllerImp
import edu.upb.tumejorviaje.data.directChat.persistence.DirectChatPersistenceControllerImp
import edu.upb.tumejorviaje.data.profile.ProfileRepository
import edu.upb.tumejorviaje.model.ChatBubble
import edu.upb.tumejorviaje.model.SavedChat
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class ChatBubbleViewModel : ViewModel() {

    private val chatBubbleRepository =
        DirectChatRepository(DirectChatNetworkControllerImp(), DirectChatPersistenceControllerImp())
    val profileRepository by inject(ProfileRepository::class.java)
    val chatId = MutableLiveData<String>()
    val chatBubbles = MutableLiveData<List<ChatBubble>>(listOf())
    val savedChat = MutableLiveData<SavedChat>()


    fun updateChatBubbles(chatId: String): Job {
        return chatBubbleRepository.getAllChatBubblesForId(chatId).onEach {
            chatBubbles.postValue(it)
        }.launchIn(
            CoroutineScope(Dispatchers.IO)
        )
    }


    fun saveNewBubble(message: String): Job {
        return chatBubbleRepository.addNewBubble(
            ChatBubble(
                0, message, getHour(),
                profileRepository.getUserProfile()!!.username,
                profileRepository.getUserProfile()!!.profileUrl, chatId.value!!
            )
        ).launchIn(
            CoroutineScope(Dispatchers.IO)
        )
    }

    private fun getHour(): String {
        val date = Calendar.getInstance().time
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(date).toString()

    }


}