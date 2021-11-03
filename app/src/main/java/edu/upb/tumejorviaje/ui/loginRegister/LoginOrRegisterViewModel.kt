package edu.upb.tumejorviaje.ui.loginRegister

import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.user.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import org.koin.java.KoinJavaComponent.inject

class LoginOrRegisterViewModel: ViewModel() {
    private val userRepository by inject(UserRepository::class.java)

    fun login(usernamEmail: String, password: String): Job {
        return userRepository.login(usernamEmail, password).launchIn(CoroutineScope(Dispatchers.Main))
    }

}