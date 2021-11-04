package edu.upb.tumejorviaje.data.user.persistency

import edu.upb.tumejorviaje.App
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow


class UserPersistenceControllerImp:UserPersistenceController {
    private val db= App.db
    override fun saveUser(users: List<User>) {
        db.userDao().saveUser(users)
    }

    override fun getUser(username: String, password: String): Flow<User> {
        return db.userDao().getUser(username,password)
    }
}