package edu.upb.tumejorviaje.model

data class AddPostRequest(val publisher: String,
                          val title: String,
                          val shortDescription: String,
                          val postUrl: String,
                          val profileUrl: String,
                          val longDescription: String,
                          val likes: Int,
                          val comments: Int,
                          val uploaded: String)