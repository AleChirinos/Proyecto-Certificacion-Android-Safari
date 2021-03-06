package edu.upb.tumejorviaje.ui

import android.content.Context
import androidx.fragment.app.Fragment

fun Context.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

fun Context.pxToDp(px: Int): Int {
    return (px / resources.displayMetrics.density).toInt()
}

fun Fragment.dpToPx(dp: Int): Int {
    return (dp * resources.displayMetrics.density).toInt()
}

fun Fragment.pxToDp(px: Int): Int {
    return (px / resources.displayMetrics.density).toInt()
}