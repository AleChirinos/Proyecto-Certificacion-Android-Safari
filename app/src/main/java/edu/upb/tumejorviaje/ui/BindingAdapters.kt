package edu.upb.tumejorviaje.ui

import android.provider.Settings.System.getString
import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R

import java.util.*

@BindingAdapter ("srcUrl")
fun setSrcUrl(imageView: ImageView, url:String){
    if(url==null) return
    Glide.with(imageView).load(url).into(imageView)
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