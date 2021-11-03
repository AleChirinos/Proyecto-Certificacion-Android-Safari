package edu.upb.tumejorviaje.ui.loginRegister

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent.inject

class RegisterViewModel : ViewModel() {
    private val userRepository by inject(UserRepository::class.java)
    val photoPassed= MutableLiveData(false)
    val valid=MutableLiveData(false)

    fun register(username: String, password: String, email:String, description:String, photo:String): Job {
        return userRepository.register(username, password,email,description,photo).launchIn(CoroutineScope(Dispatchers.Main))
    }
    
}