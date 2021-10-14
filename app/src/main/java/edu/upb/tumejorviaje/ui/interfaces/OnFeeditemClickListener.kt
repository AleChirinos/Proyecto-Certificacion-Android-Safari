package edu.upb.tumejorviaje.ui.interfaces

import edu.upb.tumejorviaje.model.Post

interface OnFeedItemClickListener {
    fun onItemClick(post: Post)
}