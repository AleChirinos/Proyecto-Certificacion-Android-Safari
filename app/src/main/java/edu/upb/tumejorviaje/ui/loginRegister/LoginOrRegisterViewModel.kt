package edu.upb.tumejorviaje.ui.loginRegister

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.upb.tumejorviaje.data.user.UserRepository
import edu.upb.tumejorviaje.data.user.network.UserNetworkControllerImp
import edu.upb.tumejorviaje.data.user.persistency.UserPersistenceControllerImp
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.java.KoinJavaComponent.inject

class LoginOrRegisterViewModel: ViewModel() {
    private val userRepository= UserRepository(UserNetworkControllerImp(),UserPersistenceControllerImp())

    val myUser=MutableLiveData<List<User>>(listOf())

    fun login(usernamEmail: String, password: String): Job {
        return userRepository.login(usernamEmail, password).launchIn(CoroutineScope(Dispatchers.Main))
    }

    fun getUser(username:String, password: String): Job {
        return userRepository.getAllUsers(username,password).onEach{
            myUser.postValue(it)
        }.launchIn(CoroutineScope(Dispatchers.IO))
    }








}