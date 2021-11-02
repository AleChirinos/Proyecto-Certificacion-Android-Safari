package edu.upb.tumejorviaje.data.profile.persistency

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User

class ProfilePersistencyControllerImp : ProfilePersistencyController{
    private var user: User?= User("dt.valdivia","Soy auditor financiero, con un master en big data y otro en accounting management", "https://vevico.files.wordpress.com/2019/08/tachuri-siete-colores.png?crop")


    //sin esto, el LocalDate no nos podra funcionar, ya que nos indica que requiere un API minimo de 26
    private var feedList : List<Post> = listOf()

    override fun getNewFeedList() : List<Post>{
        return feedList
    }

    override fun savePosts(posts : List<Post>){
        feedList = posts
    }

    override fun getUser(): User?{
        return user
    }
}