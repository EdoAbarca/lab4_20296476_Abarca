package Modelo;

import java.util.ArrayList;

/**
 * Clase PubicacionOriginal. Esta clase tiene por objetivo representar una publicacion original (no compartida) en una red social.
 * Clase hija de "Publicacion"
 * @version 1.1, 23/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionOriginal extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    final ArrayList<Like> LikesPublicacionOr; //Arreglar esto
    final ArrayList<Comentario> ComentariosPublicacionOr; //Arreglar esto
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para PublicacionOriginal
     * @param Fecha Fecha de publicacion
     * @param Usuario Usuario que creo publicacion
     * @param Tipo Tipo publicacion
     * @param Contenido Contenido publicacion
     * @param Destinos Lista de destinos publicacion
     */
    public PublicacionOriginal(String Fecha, String Usuario, String Tipo, String Contenido, ArrayList<String> Destinos)
    {
        super(Fecha, Usuario, Tipo, Contenido, Destinos);
        this.LikesPublicacionOr = new ArrayList<>();
        this.ComentariosPublicacionOr = new ArrayList<>();
    }
    
    /* GETTERS */
    /**
     * Getter de comentario via ID reaccion
     * @param id ID comentario
     * @return Indice (posicion) de comentario apuntado
     */

    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        
        //Se revisa ArrayList de comentarios
        for(int i = 0; i < this.ComentariosPublicacionOr.size(); i++)
        {
            //Si se encontro el ID del comentario, se retorna indice y se corta ciclo for
            if(this.ComentariosPublicacionOr.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        
        //Se retorna indice
        return IndiceComentario;
    }
    
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
    // Sin metodos adicionales.
}
