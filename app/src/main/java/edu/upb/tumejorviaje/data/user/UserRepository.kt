package edu.upb.tumejorviaje.data.user

import edu.upb.tumejorviaje.data.user.network.UserNetworkController
import edu.upb.tumejorviaje.data.user.persistency.UserPersistenceController
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(val network: UserNetworkController, val persistence:UserPersistenceController){
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


    fun getAllUsers(username: String, password: String): Flow<List<User>> {
       return flow{
           val users=network.getUser(username,password)
           persistence.saveUser(users)
           emit(users)
       }
    }

    fun getUser(username: String,password: String):Flow<User>{
        return persistence.getUser(username,password)
    }
}