package edu.upb.tumejorviaje.model

import java.io.Serializable

data class Post(val publisher : String,
                val title : String,
                val shortDescription : String,
                val postUrl: String,
                val profileUrl : String,
                val longDescription: String
) : Serializable
