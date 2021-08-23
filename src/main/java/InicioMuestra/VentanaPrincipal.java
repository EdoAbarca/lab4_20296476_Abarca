
package InicioMuestra;

import Modelo.ImplementacionRedSocial;
import Vista.MuestraInicial;

/*
Laboratorio 4 Paradigmas de Programacio1n
Objetivo: Implementar un programa que simule las funcionalidades de una red social, usando el Paradigma Orientado a Objetos y Paradigma Orientado a Eventos
Nombre Alumno: Eduardo Abarca
Seccion: C-3
Profesor: Daniel Gacitua
Entrega: Original (23/08/2021)

VERSION PRE-FINAL, REQUERIMIENTOS FUNCIONALES MINIMOS SE ESPERAN ESTAR FUNCIONALES.
*/

/**
 * Clase VentanaPrincipal.
 * Esta clase tiene por objetivo instanciar la ventana que dara inicio a la muestra de la interfaz grafica.
 * @version 1.3, 23/08/2021
 * @author Eduardo Abarca
 */

public class VentanaPrincipal
{
    /** Metodo main
     * Aca se inicia la ejecucion del programa, instanciando y haciendo visible la ventana principal de la interfaz grafica.
     * @param args los argumentos ingresados por linea de comandos
     */
    public static void main(String[] args)
    {
        /*
        ATRIBUTOS DE RED SOCIAL NO SERAN ESTATICOS
        SE DEBE INSTANCIAR LA RED SOCIAL E INGRESARLA POR PARAMETRO A CADA VENTANA A USAR EN LA EJECUCION
        EN CADA UNA DE ESTAS SE DEBE LLAMAR AL METODO RESPECTIVO A LA VENTANA, LUEGO DE INGRESAR LOS DATOS EN LOS CAMPOS A CREAR...
        */
                
        //Instancia red social
        ImplementacionRedSocial ModeloRedSocial = new ImplementacionRedSocial("Instabook");
        
        //Instancia ventana principal
        MuestraInicial VentanaInicioRedSocial = new MuestraInicial(ModeloRedSocial);
        
        //Inicio muestreo ventana principal
        VentanaInicioRedSocial.setVisible(true);
    }
}

