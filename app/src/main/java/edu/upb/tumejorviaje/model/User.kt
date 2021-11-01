package edu.upb.tumejorviaje.model

import androidx.room.Entity
import java.io.Serializable

@Entity
class User (var username:String, var description:String, var profileUrl:String):Serializable {

}