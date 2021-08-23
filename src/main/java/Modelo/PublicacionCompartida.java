package Modelo;

import java.util.ArrayList;

/**
 * Clase PubicacionCompartida. Esta clase tiene por objetivo representar el resultado de compartir una publicacion en una red social.
 * Clase hija de "Publicacion"
 * @version 1.1, 23/08/2021
 * @author Eduardo Abarca
 */
public class PublicacionCompartida extends Publicacion
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    
    private final int IdPublicacionCompartida;
    private final String FechaComparte;
    private final String UsuarioQueComparte;
    private final String UsuarioDestinoComparte;
    final ArrayList<Like> LikesPublicacionComp; 
    final ArrayList<Comentario> ComentariosPublicacionComp;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para PublicacionCompartida
     * @param P Publicacion original compartida
     * @param IdP ID publicacion compartida
     * @param FechaC Fecha en la que se compartio la publicacion
     * @param Comparte Usuario que comparte la publicacion
     * @param DestinoComparte Usuario al que se le compartio la publicacion
     */

    public PublicacionCompartida(PublicacionOriginal P, int IdP, String FechaC, String Comparte, String DestinoComparte)
    {
        super(P.getFechaPublicacion(), P.getAutorPublicacion(), P.getTipoPublicacion(), P.getContenidoPublicacion(), P.getUsuariosDirigidos());
        this.IdPublicacionCompartida = IdP;
        this.UsuarioQueComparte = Comparte;
        this.UsuarioDestinoComparte = DestinoComparte;
        this.FechaComparte = FechaC;
        this.LikesPublicacionComp = new ArrayList<>();
        this.ComentariosPublicacionComp = new ArrayList<>();
    }
    
    /* GETTERS */
    
    /**
     * Getter de indice comentario mediante ID reaccion
     * @param id ID comentario
     * @return Indice (posicion) comentario apuntado
     */
    @Override
    public int getComentarioViaIdReaccion(int id)
    {
        int IndiceComentario = -1;
        
        //Se revisa ArrayList de comentarios
        for(int i = 0; i < this.ComentariosPublicacionComp.size(); i++)
        {
            //Se encontro comentario con ID ingresado, se guarda indice y se corta ciclo for
            if(this.ComentariosPublicacionComp.get(i).getIdReaccion() == id)
            {
                IndiceComentario = i;
                break;
            }
        }
        
        //Se retorna resultado
        return IndiceComentario;
    }
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
    // Sin metodos adicionales.
}