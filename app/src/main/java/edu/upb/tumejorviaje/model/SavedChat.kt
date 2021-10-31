package edu.upb.tumejorviaje.model

import java.io.Serializable

data class SavedChat (val user: User,
                      val chatLastMessage: String) : Serializable