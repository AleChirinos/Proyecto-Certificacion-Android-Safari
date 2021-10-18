package edu.upb.tumejorviaje.model

import java.io.Serializable

data class SavedChat (val chatName: String,
                      val chatLastMessage: String,
                      val profileImg: Int) : Serializable