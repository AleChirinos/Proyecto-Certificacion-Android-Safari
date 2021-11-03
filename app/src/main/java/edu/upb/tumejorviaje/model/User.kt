package edu.upb.tumejorviaje.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class User (
    @PrimaryKey var username:String,
    var password:String,
    var email:String,
    var description:String,
    var profileUrl:String):Serializable {

}