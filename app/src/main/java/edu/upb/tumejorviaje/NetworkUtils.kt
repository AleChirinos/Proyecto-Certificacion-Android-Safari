package edu.upb.tumejorviaje

import android.content.Context

object NetworkUtils {
    var isOnline = false

    fun updateIsOnline(context: Context) {
        isOnline = isNetworkConnected(context)
    }
}