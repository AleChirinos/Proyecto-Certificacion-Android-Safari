package edu.upb.tumejorviaje.ui.loginRegister

import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent

class RegisterViewModel : ViewModel() {
    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun register(username: String, password: String): Job {
        return userRepository.register(username, password).launchIn(CoroutineScope(Dispatchers.Main))
    }
}