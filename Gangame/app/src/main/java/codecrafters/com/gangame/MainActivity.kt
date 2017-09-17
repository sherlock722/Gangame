package codecrafters.com.gangame

//Este import se utiliza para no tener que utilizar el método findViewById.
//Se importan las vistas con las kotlin android extensions
//Con ello se puede hacer mención a las vistas indicadas (en este caso en el activity_main)
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import codecrafters.com.gangame.deals.DealsFragment
import codecrafters.com.gangame.owned.TopOwnedFragment
import codecrafters.com.gangame.rated.TopRatedFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Lo que exista aquí dentro del "companion object" es estático, es decir es un objeto común
    //para todas las instancias de esta clase y no necesito crear una instancia de la clase para usarlo
    //La palabra const se pone para usar una constante de manera estática
    companion object {
       const val DEFAULT_OPTION = R.id.action_deals
    }

    //Se define una estructura de datos para almacenar los fragmentos,
    //asociando su id con la clase del fragmento (como si fuese un diccionario)
    //Cada R.id.xxx son las opciones del menú y las relacionamos con los fragmentos

    val fragments: HashMap <Int, android.support.v4.app.Fragment> = hashMapOf(
            Pair(R.id.action_deals, DealsFragment()),
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned,TopOwnedFragment())
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Cuando se crea la actividad, inicialmente se quiere pintar el fragmento por defecto es decir el DEFAULT_OPTION
        //Eso se hace con la funcion initView()
        initView()

        //Se le indica al BottomNavigationView cual la opcion seleccionada por defecto
        navigationView.selectedItemId= MainActivity.DEFAULT_OPTION


        //Listener que nos permite escuchar las opciones de navegación
        /*navigationView.setOnNavigationItemSelectedListener (object : BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })*/

        //El código anterior se ha convertido en una LAMBDA que es una función de primer orden dentro
        //de la programación funcional

        //Esta función es la sustitución del método onNavigationItemSelected(item: MenuItem): Boolean que recibe un item
        //y devuelve un boolean

        //En la programación funcional no se usa el comando return en las funciones. En estos casos, lo último que se escribe
        //es lo que va a devolver la función
        navigationView.setOnNavigationItemSelectedListener  { item ->

            //Esta linea para obterner el fragmento "fragments.get(item.itemId)" se puede sustituir por esta otra:
            val fragment : Fragment? = fragments[item.itemId]

            //Se reemplaza el fragmento
            if (fragment != null){
                replaceFragment(fragment)
            }
            true
        }
    }

    //Función que reemplaza un fragmento. El contenedor donde se tiene que reemplazar es fragmentContainer y el fragmento
    //a reemplazar es fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit()
    }

    //Esta función es impura porque altera lo que hay en la vista
    fun initView(){

        //Al inicializar la vista va a encontrar cual es el fragmento si es que hay un fragmento ya en nuestra vista
        //Al momento de añadir un fragmento, podemos añadir un ID o un TAG. Si no lo hacemos el ID por defecto
        //que toma es el ID de su contenedor y en este caso es fragmentContainer
        //Buscamos que fragmento hay dentro de ese contenedor
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)


        //Si no existe el fragmento lo añadimos. El contenedor es fragmentContainer y se añade el fragmento por defecto
        //que es R.id.action_deals
        if (currentFragment == null){
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTION])
                    .commit()
        }

    }
}
