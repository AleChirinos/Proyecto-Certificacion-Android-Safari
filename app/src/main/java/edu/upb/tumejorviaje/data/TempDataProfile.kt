package edu.upb.tumejorviaje.data

import android.os.Build

import edu.upb.tumejorviaje.model.Post
import edu.upb.tumejorviaje.model.User
import java.time.LocalDate
import java.util.*

object TempDataProfile {
    private var user: User?=User("dt.valdivia","Soy auditor financiero, con un master en big data y otro en accounting management", "https://vevico.files.wordpress.com/2019/08/tachuri-siete-colores.png?crop")


    //sin esto, el LocalDate no nos podra funcionar, ya que nos indica que requiere un API minimo de 26
    private var feedList = mutableListOf(
        Post(
            publisher = "dv.Valdivia",
            title = "De camino a mi maestría Estados Unidos",
            shortDescription = "Hace unos meses me llego la carta de aceptación en una de las mejores universidades...",
            postUrl = "https://www.tendenciashoy.com/wp-content/uploads/2020/07/times-square-foto-anthony-rosset-unsplash.jpeg",
            longDescription = "El Lorem Ipsum fue concebido como un texto de relleno, formateado de una cierta manera para permitir la presentación de elementos gráficos en documentos, sin necesidad de una copia formal. El uso de Lorem Ipsum permite a los diseñadores reunir los diseños y la forma del contenido antes de que el contenido se haya creado, dando al diseño y al proceso de producción más libertad.\n" +
                    "\n" +
                    "Se cree ampliamente que la historia de Lorem Ipsum se origina con Cicerón en el siglo I aC y su texto De Finibus bonorum et malorum. Esta obra filosófica, también conocida como En los extremos del bien y del mal, se dividió en cinco libros. El Lorem Ipsum que conocemos hoy se deriva de partes del primer libro Liber Primus y su discusión sobre el hedonismo, cuyas palabras habían sido alteradas, añadidas y eliminadas para convertirlas en un latín sin sentido e impropio. No se sabe exactamente cuándo el texto recibió su forma tradicional actual. Sin embargo, las referencias a la frase \"Lorem Ipsum\" se pueden encontrar en la Edición de la Biblioteca Clásica Loeb de 1914 del De Finibus en las secciones 32 y 33. Fue en esta edición del De Finibus en la que H. Rackman tradujo el texto. El siguiente fragmento se selecciona de la sección 32:",
            profileUrl = user?.profileUrl!!,
            likes = 120,
            comments = 32,
            uploaded = "28/12/2020"
        ),
        Post(
            publisher = "dv.Valdivia",
            title = "Mi primera maestría en el extranjero",
            shortDescription = "Despues de acabar la carrera de contabilidad mi sueño siempre fue...",
            postUrl = "https://static.hosteltur.com/app/public/uploads/img/articles/2014/12/01/L_5c1a3eae0668b_sao_paulo.jpg",
            profileUrl = user?.profileUrl!!,
            longDescription = "El Lorem Ipsum fue concebido como un texto de relleno, formateado de una cierta manera para permitir la presentación de elementos gráficos en documentos, sin necesidad de una copia formal. El uso de Lorem Ipsum permite a los diseñadores reunir los diseños y la forma del contenido antes de que el contenido se haya creado, dando al diseño y al proceso de producción más libertad.\n" +
                    "\n" +
                    "Se cree ampliamente que la historia de Lorem Ipsum se origina con Cicerón en el siglo I aC y su texto De Finibus bonorum et malorum. Esta obra filosófica, también conocida como En los extremos del bien y del mal, se dividió en cinco libros. El Lorem Ipsum que conocemos hoy se deriva de partes del primer libro Liber Primus y su discusión sobre el hedonismo, cuyas palabras habían sido alteradas, añadidas y eliminadas para convertirlas en un latín sin sentido e impropio. No se sabe exactamente cuándo el texto recibió su forma tradicional actual. Sin embargo, las referencias a la frase \"Lorem Ipsum\" se pueden encontrar en la Edición de la Biblioteca Clásica Loeb de 1914 del De Finibus en las secciones 32 y 33. Fue en esta edición del De Finibus en la que H. Rackman tradujo el texto. El siguiente fragmento se selecciona de la sección 32:",
            likes = 100,
            comments = 22,
            uploaded = "29/04/2021"
        ),
        Post(
            publisher = "dv.Valdivia",
            title = "Vacaciones en Europa",
            shortDescription = "Mi sueño siempre fue conocer europa, conoci alrededor de quince países en tres semanas...",
            postUrl = "https://www.viajarafrancia.com/wp-content/uploads/2016/04/Paris-760x500.jpg",
            profileUrl = user?.profileUrl!!,
            longDescription = "El Lorem Ipsum fue concebido como un texto de relleno, formateado de una cierta manera para permitir la presentación de elementos gráficos en documentos, sin necesidad de una copia formal. El uso de Lorem Ipsum permite a los diseñadores reunir los diseños y la forma del contenido antes de que el contenido se haya creado, dando al diseño y al proceso de producción más libertad.\n" +
                    "\n" +
                    "Se cree ampliamente que la historia de Lorem Ipsum se origina con Cicerón en el siglo I aC y su texto De Finibus bonorum et malorum. Esta obra filosófica, también conocida como En los extremos del bien y del mal, se dividió en cinco libros. El Lorem Ipsum que conocemos hoy se deriva de partes del primer libro Liber Primus y su discusión sobre el hedonismo, cuyas palabras habían sido alteradas, añadidas y eliminadas para convertirlas en un latín sin sentido e impropio. No se sabe exactamente cuándo el texto recibió su forma tradicional actual. Sin embargo, las referencias a la frase \"Lorem Ipsum\" se pueden encontrar en la Edición de la Biblioteca Clásica Loeb de 1914 del De Finibus en las secciones 32 y 33. Fue en esta edición del De Finibus en la que H. Rackman tradujo el texto. El siguiente fragmento se selecciona de la sección 32:",
            likes = 110,
            comments = 12,
            uploaded = "18/02/2021"
        )
    )


    fun getNewFeedList() : List<Post>{
        return feedList
    }

    fun getUser():User?{
        return user
    }


    fun setNewFeedList(itemFeedList : List<Post>){
        this.feedList = itemFeedList.toMutableList()
    }
}