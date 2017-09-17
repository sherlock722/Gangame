package codecrafters.com.gangame.deals

import codecrafters.com.commons.BaseFragment
import codecrafters.com.gangame.R

/**
 * Created by javier on 16/9/17.
 */

class DealsFragment : BaseFragment(){
    override fun getLayoutresId(): Int {

        return R.layout.fragment_deal
    }

    //En un fragmento con vistas lo que se necesita es crear la vista por eso creamos en el onCreateView
    //El inflater nunca es null por lo que se puede quitar el ? del LayoutInflater
    //override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Creamos la vista --> Se pasa el layout del fragment (R.layout.fragment_deal), un contenedor que viene en el método
        // y "false" para no seguir la jerarquia se vistas
        //val view = inflater.inflate(R.layout.fragment_deal, container, false)

        //retornamos la vista
        //return view
    //}

}
