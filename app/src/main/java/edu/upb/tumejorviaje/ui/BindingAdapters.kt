package edu.upb.tumejorviaje.ui

import android.provider.Settings.System.getString
import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R


import android.graphics.BitmapFactory
import android.util.Base64
import java.lang.Byte.decode


@BindingAdapter ("srcUrl")
fun setSrcUrl(imageView: ImageView, url:String){
    if(url==null) return
    val decodedByteArray: ByteArray = Base64.decode(url, Base64.NO_WRAP)
    val decodedBitmap = BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
    imageView.setImageBitmap(decodedBitmap)
}

@BindingAdapter("textInTimeFormat")
fun setTextInTimeFormat(textView: TextView, time:Long){
    val minutes = time.div(60)
    textView.text="$minutes min"
}


@BindingAdapter ("srcImage")
fun setSrcImage(imageView: ImageView, identificador:Int){
    if(identificador==null) return
    imageView.setImageResource(identificador)
}