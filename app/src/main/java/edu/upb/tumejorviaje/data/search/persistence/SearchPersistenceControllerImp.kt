package edu.upb.tumejorviaje.data.search.persistence

import edu.upb.tumejorviaje.App
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

class SearchPersistenceControllerImp:SearchPersistenceController {

    private val db= App.db

    override fun getNewUsersList(): Flow<List<User>> {
        return db.searchDao().getAllUserList()
    }

    override fun saveUserList(posts: List<User>) {
        return db.searchDao().saveAllUsers(posts)
    }

    override fun deleteList() {
        return db.searchDao().deleteAll()
    }
}