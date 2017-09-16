package codecrafters.com.commons

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by javier on 16/9/17.
 */
abstract  class BaseFragment : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Crear la vista --> Se pasa el layout del fragment (en este caso se recupera con el método getLayoutresId),
        // un contenedor que viene en el método y "false" para no seguir la jerarquia se vistas
        val view = inflater.inflate(getLayoutresId(), container, false)

        //retorna la vista
        return view
    }

    abstract fun getLayoutresId(): Int

}