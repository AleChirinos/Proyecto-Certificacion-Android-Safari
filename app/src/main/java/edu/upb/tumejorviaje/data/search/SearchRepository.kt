package edu.upb.tumejorviaje.data.search

import android.util.Log
import edu.upb.tumejorviaje.data.UserTempDataSource
import edu.upb.tumejorviaje.data.search.network.SearchNetworkController
import edu.upb.tumejorviaje.data.search.persistence.SearchPersistenceController
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SearchRepository(private val network:SearchNetworkController, private val persistence: SearchPersistenceController) {
    fun getAllUsers(): Flow<List<User>> {
        return persistence.getNewUsersList()
    }

    fun updateUserlist(username:String):Flow<Any>{
        return flow{
            try {
                persistence.deleteList()
                val users:List<User>
                if(username.isBlank()) {
                    users=network.getAllUsersList()
                } else {
                    users=network.getUsersProfile(username)
                }
                persistence.saveUserList(users)
                emit(users)
            }catch (e : Exception){
                Log.e("ERROR", e.message!!)
            }
        }
    }
}