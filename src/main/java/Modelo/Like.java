package Modelo;

/**
 * Clase Like. Esta clase tiene por objetivo representar un "Me gusta" a una publicacion en una red social.
 * Clase hija de "Reaccion", el Me gusta puede ser dirigido a una publicacion o un comentario.
 * @version 1.1, 23/08/2021
 * @author Eduardo Abarca
 */

public class Like extends Reaccion
{
    
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    //Sin atributos adicionales.
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para clase Like
     * @param IdPS ID publicacion seleccionada
     * @param IdRS ID reaccion seleccionada
     * @param Fecha Fecha like
     * @param Autor Autor (usuario like)
     * @param Tipo Tipo reaccion
     */
    public Like(int IdPS, int IdRS, String Fecha, String Autor, String Tipo)
    {
        super(IdPS, IdRS, Fecha, Autor, Tipo);
    }
    
    /* GETTERS */
    // Sin getters.
    
    /* SETTERS */
    // Sin setters.
    
    /* METODOS ADICIONALES */
    // Sin metodos adicionales.
}
