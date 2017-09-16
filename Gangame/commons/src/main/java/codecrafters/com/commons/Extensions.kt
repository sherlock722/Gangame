package codecrafters.com.commons

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by javier on 16/9/17.
 */
fun ViewGroup.inflate(layoutResId : Int, attachToRoot : Boolean = false) : View {

    //Toda View tiene un contexto por lo que se obtiene el inflate a partir de ese contexto
    val inflater = LayoutInflater.from(context)

    //En este caso "this" se refiere al contenedor que es el ViewGroup
    return inflater.inflate(layoutResId, this, attachToRoot)
}