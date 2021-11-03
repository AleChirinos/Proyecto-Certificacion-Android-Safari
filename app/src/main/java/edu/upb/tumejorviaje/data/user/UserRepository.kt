package edu.upb.tumejorviaje.data.user

import edu.upb.tumejorviaje.data.user.network.UserNetworkController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(val network: UserNetworkController){
    fun login(usernamEmail: String, password: String): Flow<Any> {
        return flow {
            network.login(usernamEmail, password)
        }
    }

    fun register(username: String, password: String,email:String, description:String, photo:String): Flow<Any> {
        return flow {
            network.register(username, password,email,description,photo)
        }
    }
}