package edu.upb.tumejorviaje.data.user.persistency

import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

interface UserPersistenceController {
    fun saveUser(users: List<User>)
    fun getUser(username: String, password: String): Flow<User>



}