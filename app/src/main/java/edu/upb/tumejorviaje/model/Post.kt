package edu.upb.tumejorviaje.model

import java.io.Serializable
import java.util.*

data class Post(val publisher : String,
                val title : String,
                val shortDescription : String,
                val postUrl: String,
                val profileUrl : String,
                val longDescription: String,
                val likes: Int,
                val comments: Int,
                val uploaded: Date
) : Serializable
