package edu.upb.tumejorviaje.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

import java.util.*

@Entity
data class Post(
    @PrimaryKey val id:Int,
    val publisher : String,
                val title : String,
                val shortDescription : String,
                val postUrl: String,
                val profileUrl : String,
                val longDescription: String,
                val likes: Int,
                val comments: Int,
                val uploaded: String
) : Serializable
