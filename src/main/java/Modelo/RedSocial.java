package Modelo;

import java.util.ArrayList;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica.
 * Aca se encontraran los atributos basicos de una red social, como los metodos necesarios para poder interactuar en ella.
 * @version 1.2, 23/08/2021
 * @author Eduardo Abarca
 */
public interface RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    // Sin atributos.
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* //////////////////////////////////////////////// METODOS DE APOYO /////////////////////////////////////////////// */
    //A comentar en clase que implemente esta interfaz.
    
    public void AsignarUsuarioLogueado(String Usuario);
    
    public void ExpulsarUsuarioLogueado();
    
    public String FechaDeHoy();
    
    public ArrayList<Usuario> getUsuariosRegistrados();
    
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia);
    
    public boolean ValidarCredenciales(String Usuario, String Contrasenia);
    
    public int getUsuarioViaUsername(String NombreUsuario);
    
    public int ReferenciarUsuarioPublicacionOr(int id);
    
    public int ReferenciarUsuarioPublicacionComp(int id);
    
    public boolean ValidarDestinos(ArrayList<String> ListaDestinos);
    
    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */
    
    public String Register(String UsuarioARegistrar, String ContraseniaARegistrar);
    
    public String Login(String UsuarioLogin, String ContraseniaLogin);
    
    public void Logout();

    public String Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino);
    
    public String Follow(String UsuarioApuntado);
    
    public String Share(int IdPublicacion, ArrayList<String> UsuariosDestino);
    
    public String Comment(int IdPublicacion, int IdReaccion, String ContenidoComentario);
    
    public String Like(int IdPublicacion, int IdReaccion);
}