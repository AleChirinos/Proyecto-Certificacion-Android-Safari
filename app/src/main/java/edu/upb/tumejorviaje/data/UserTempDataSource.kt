package edu.upb.tumejorviaje.data

import android.graphics.drawable.BitmapDrawable
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import edu.upb.tumejorviaje.model.User

object UserTempDataSource {
    var myUser: User = User(
        "dt.valdivia",
        "123445",
        "varita@gmail.com",
        "Soy auditor financiero, con un master en big data y otro en accounting management",
        "https://vevico.files.wordpress.com/2019/08/tachuri-siete-colores.png?crop"
    )
    var otherUser: User = User(
        "Maria Marcela",
        "pass",
        "caretita@gmail.com",
        "Careta",
        "https://i.pinimg.com/originals/3e/b1/43/3eb143771338702d4bacb845d1fd93fa.jpg"
    )

    var otherUser2: User = User(
        "Mario Marcelo",
        "pass",
        "careta@gmail.com",
        "Careta",
        "https://i.pinimg.com/originals/3e/b1/43/3eb143771338702d4bacb845d1fd93fa.jpg"
    )

    var otherUser3: User = User(
        "Marta",
        "pass",
        "cata@gmail.com",
        "Careta",
        "https://i.pinimg.com/originals/3e/b1/43/3eb143771338702d4bacb845d1fd93fa.jpg"
    )

}