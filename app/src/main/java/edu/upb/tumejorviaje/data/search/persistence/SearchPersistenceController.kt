package edu.upb.tumejorviaje.data.search.persistence

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

interface SearchPersistenceController {
    fun getNewUsersList() : Flow<List<User>>
    fun saveUserList(posts : List<User>)
    fun deleteList()
}