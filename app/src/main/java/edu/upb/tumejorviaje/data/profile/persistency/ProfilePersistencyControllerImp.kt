package edu.upb.tumejorviaje.data.profile.persistency

import edu.upb.tumejorviaje.App
import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import kotlinx.coroutines.flow.Flow

class ProfilePersistencyControllerImp : ProfilePersistencyController{
    //private var user: User?= User("dt.valdivia","Soy auditor financiero, con un master en big data y otro en accounting management", "https://i.imgur.com/RBZQYyP.png")
    private val db= App.db

    //sin esto, el LocalDate no nos podra funcionar, ya que nos indica que requiere un API minimo de 26
    //private var feedList : List<Post> = listOf()

    override fun getNewFeedList(username:String) : Flow<List<Post>> {
        return db.profilePostsDao().getAllPostsProfile(username)
    }

    override fun savePosts(posts : List<Post>){
        return db.profilePostsDao().saveAllPosts(posts)
    }




}