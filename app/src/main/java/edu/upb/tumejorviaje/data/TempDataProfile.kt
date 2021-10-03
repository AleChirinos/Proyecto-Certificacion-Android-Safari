package edu.upb.tumejorviaje.data

import edu.upb.tumejorviaje.model.Post

object TempDataProfile {
    val feedList = mutableListOf<Post>(
        Post(
            publisher = "dv.Valdivia",
            title = "De camino a mi maestría Estados Unidos",
            shortDescription = "Hace unos meses me llego la carta de aceptación en una de las mejores universidades...",
            postUrl = "https://www.tendenciashoy.com/wp-content/uploads/2020/07/times-square-foto-anthony-rosset-unsplash.jpeg",
            profileUrl = ""
        ),
        Post(
            publisher = "dv.Valdivia",
            title = "Mi primera maestría en el extrangero",
            shortDescription = "Despues de acabar la carrera de contabilidad mi sueño siempre fue...",
            postUrl = "https://static.hosteltur.com/app/public/uploads/img/articles/2014/12/01/L_5c1a3eae0668b_sao_paulo.jpg",
            profileUrl = ""
        ),
        Post(
            publisher = "dv.Valdivia",
            title = "Vacaciones en Europa",
            shortDescription = "Mi sueño siempre fue conocer europa, conoci alrededor de quince países en tres semanas...",
            postUrl = "https://www.viajarafrancia.com/wp-content/uploads/2016/04/Paris-760x500.jpg",
            profileUrl = ""
        )
    )
}