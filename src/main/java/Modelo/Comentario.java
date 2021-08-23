package Modelo;

import java.util.ArrayList;

/**
 * Clase Comentario. Esta clase tiene por objetivo representar un comentario en una red social.
 * Clase hija de "Reaccion", el comentario puede ser a una publicacion o como respuesta a otro comentario.
 * @version 1.1, 23/08/2021
 * @author Eduardo Abarca
 */

public class Comentario extends Reaccion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    
    private final String ContenidoComentario;
    final ArrayList<Like> LikesComentario;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para clase Comentario
     * @param IdPS ID publicacion seleccionada
     * @param IdRS ID reaccion seleccionada
     * @param Fecha Fecha comentario
     * @param Autor Autor (usuario) comentario
     * @param Tipo Tipo reaccion
     * @param Contenido Contenido comentario
     */
    public Comentario(int IdPS, int IdRS, String Fecha, String Autor, String Tipo, String Contenido)
    {
        super(IdPS, IdRS, Fecha, Autor, Tipo);
        this.ContenidoComentario = Contenido;
        this.LikesComentario = new ArrayList<>();
    }
    
    /* GETTERS */

    /**
     * Getter para ContenidoComentario
     * @return ContenidoComentario (String)
     */
    public String getContenidoComentario()
    {return this.ContenidoComentario;}
    
    /* SETTERS */
    //Sin setters adicionales.
    
    /* METODOS ADICIONALES */
    //Sin metodos adicionales.
}