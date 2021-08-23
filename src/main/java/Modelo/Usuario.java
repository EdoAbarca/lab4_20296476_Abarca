package Modelo;

import java.util.ArrayList;

/**
 * Clase Usuario. Esta clase tiene por objetivo representar un usuario en una red social.
 * 
 * @version 1.1, 23/08/2021
 * @author Eduardo Abarca
 */
public class Usuario
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private static int IdCorrelativoUsuarios = 1;
    private final int IdUsuario;
    private final String NombreUsuario;
    private final String Contrasenia;
    private final ArrayList<String> ListaSeguidos;
    private final ArrayList<String> ListaSeguidores;
    final ArrayList<PublicacionOriginal> PublicacionesUsuario; //Arreglar esto
    final ArrayList<PublicacionCompartida> PublicacionesCompartidas; //Arreglar esto
    
    //GETTERS Y SETTERS PARA INTENTAR ACCEDER A ELEMENTOS DE ARRAYLIST
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para la clase Usuario
     * @param Usuario Usuario a registrar en la clase a instanciar
     * @param Contrasenia Contrasenia a registrar en la clase a instanciar
     */

    public Usuario(String Usuario, String Contrasenia)
    {
        this.IdUsuario = IdCorrelativoUsuarios;
        IdCorrelativoUsuarios++;
        this.NombreUsuario = Usuario;
        this.Contrasenia = Contrasenia;
        this.ListaSeguidos = new ArrayList<>();
        this.ListaSeguidores = new ArrayList<>();
        this.PublicacionesUsuario = new ArrayList<>();
        this.PublicacionesCompartidas = new ArrayList<>();
    }
    
    /* GETTERS */
    
    /**
     * Getter para NombreUsuario
     * @return NombreUsuario (String)
     */
    public String getNombreUsuario()
    {return this.NombreUsuario;}
    
    /**
     * Getter para Contrasenia
     * @return Contrasenia (String)
     */
    public String getContrasenia()
    {return this.Contrasenia;}
    
    /**
     * Getter para 
     * @return 
     */
    public ArrayList<String> getSeguidosUsuario()
    {return this.ListaSeguidos;}
    
    /**
     * Getter para 
     * @return 
     */
    public ArrayList<PublicacionOriginal> getPublicacionesOrUsuario()
    {return this.PublicacionesUsuario;}
    
    /**
     * Getter para 
     * @return 
     */
    public ArrayList<PublicacionCompartida> getPublicacionesCompUsuario()
    {return this.PublicacionesCompartidas;}
    
    /**
     * Getter de indice de publicacion original mediante ID
     * @param id ID de la publicacion original buscada
     * @return Indice publicacion original apuntada (int)
     */
    public int getPublicacionOriginalPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        
        //Se revisa lista publicaciones originales usuario
        for(int i = 0; i < this.PublicacionesUsuario.size(); i++)
        {
            //Se encontro publicacion con el ID ingresado, se guarda indice y se corta ciclo for
            if(this.PublicacionesUsuario.get(i).getIdPublicacion() == id)
            {
                indicePublicacionRetorno = i;
                break;
            }
        }
        
        //Se retorna indice
        return indicePublicacionRetorno;
    }
    
    /**
     * Getter de indice de publicacion compartida mediante ID
     * @param id ID de la publicacion compartida buscada
     * @return Indice publicacion compartida apuntada (int)
     */
    public int getPublicacionCompartidaPorId(int id)
    {
        int indicePublicacionRetorno = -1;
        
        //Se revisa lista publicaciones originales usuario
        for(int i = 0; i < this.PublicacionesCompartidas.size(); i++)
        {
            //Se encontro publicacion con el ID ingresado, se guarda indice y se corta ciclo for
            if(this.PublicacionesCompartidas.get(i).getIdPublicacion() == id)
            {
                indicePublicacionRetorno = i;
                break;
            }
        }
        
        //Se retorna indice
        return indicePublicacionRetorno;
    } 
    
    /* SETTERS */
    //Sin setters
       
    /* METODOS ADICIONALES */
    
    /**
     * Metodo que revisa si el usuario ingresado por parametro se encuentra en la lista seguidos
     * @param Usuario Usuario a verificar
     * @return Booleano -> true: Usuario esta seguido / false caso contrario
     */
    public boolean EstaEnSeguidos(String Usuario)
    {
        boolean resultado = false;
        
        //Se revisa lista seguidos
        for(int i = 0; i < this.ListaSeguidos.size(); i++)
        {
            //Se encontro usuario en lista seguidos, se indica resultado en booleano y se corta ciclo for
            if(this.ListaSeguidos.get(i).equals(Usuario))
            {
                resultado = true;
                break;
            }
        }
        
        //Se retorna resultado
        return resultado;
    }
    
    /**
     * Metodo para agregar un nuevo seguimiento al usuario actual
     * @param Usuario Usuario a seguir
     */
    public void AgregarSeguimiento(String Usuario)
    {this.ListaSeguidos.add(Usuario);}
    
    /**
     * Metodo para agregar un nuevo seguidor al usuario actual
     * @param Usuario Usuario seguidor
     */
    public void AgregarSeguidor(String Usuario)
    {this.ListaSeguidores.add(Usuario);}
    
    /**
     * Metodo que verifica si los destinos ingresados por consola estan en los contactos de este usuario
     * @param ListaDestinos ArrayList con los usuarios destinados
     * @return Booleano -> true: Usuarios estan en contactos / false: Algun/ningun usuario esta en la lista de contactos
     */
    public boolean EstanDestinosEnContactos(ArrayList<String> ListaDestinos)
    {
        boolean EstanDestinos = true;
        
        //Si la lista no es vacia, se procesan los destinos
        if(!ListaDestinos.isEmpty())
        {
            //Se revisa cada destino
            for(int i = 0; i < ListaDestinos.size(); i++)
            {
                //Booleano para indicar si destino actual es contacto
                boolean EstaDestino = false;
                
                //Para cada destino se revisa la lista seguidos
                for(int j = 0; j < this.ListaSeguidos.size(); j++)
                {
                    //Si se encuentra destino en lista seguidos, se indica en booleano y se corta ciclo for
                    if(ListaDestinos.get(i).equals(this.ListaSeguidos.get(j)))
                    {
                        EstaDestino = true;
                        break;
                    }
                }
                
                //Si no se encontro destino, se muestra por consola/terminal y se indica que destinatarios no son validos
                if(!EstaDestino)
                {
                    System.out.print("El destino "+ListaDestinos.get(i)+" no esta en la lista de contactos.\n");
                    EstanDestinos = false;
                }
            }
        }
        
        //Se retorna resultado
        return EstanDestinos;
    }
}