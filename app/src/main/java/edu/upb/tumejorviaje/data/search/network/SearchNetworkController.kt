package edu.upb.tumejorviaje.data.search.network

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User

interface SearchNetworkController {
    suspend fun getUsersProfile(username:String) : List<User>
    suspend fun getAllUsersList (): List<User>
}