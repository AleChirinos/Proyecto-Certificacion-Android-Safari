package edu.upb.tumejorviaje.ui

import android.graphics.Bitmap
import android.provider.Settings.System.getString
import android.widget.ImageView
import android.widget.TextView

import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import edu.upb.tumejorviaje.R


import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.util.Base64
import androidx.lifecycle.viewModelScope
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import kotlinx.coroutines.*
import org.koin.android.viewmodel.compat.ScopeCompat
import java.io.IOException
import java.net.URL


@BindingAdapter ("srcUrl")
fun setSrcUrl(imageView: ImageView, url:String){

    if(url==null) return
    if (url.contains("http",true)){
        //Con BitmapFactory y un asincrono, podemos obtener la fuente del url y convertirla a bitmap
        val urlSource:URL= URL(url)
        val result:Deferred<Bitmap?> = GlobalScope.async {
            urlSource.toBitmap()
        }
        GlobalScope.launch(Dispatchers.Main) {
            imageView.setImageBitmap(result.await())
        }
    } else {
        //Si es un bitmap normal, pasarlo en imageview
        val decodedByteArray: ByteArray = Base64.decode(url, Base64.NO_WRAP)
        val decodedBitmap =
            BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
        imageView.setImageBitmap(decodedBitmap)
    }
}

fun URL.toBitmap(): Bitmap?{
    return try {
        BitmapFactory.decodeStream(openStream())
    }catch (e: IOException){
        null
    }
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