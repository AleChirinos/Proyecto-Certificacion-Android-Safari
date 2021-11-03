package edu.upb.tumejorviaje.ui.loginRegister

import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent

class LoginOrRegisterViewModel: ViewModel() {
    private val userRepository by KoinJavaComponent.inject(UserRepository::class.java)

    fun login(username: String, password: String): Job {
        return userRepository.login(username, password).launchIn(CoroutineScope(Dispatchers.Main))
    }

}