package Modelo;


import java.util.ArrayList;
import java.util.Calendar;

/**
 * Clase RedSocial. Esta clase tiene por objetivo representar una red social generica dentro del programa.
 * Aca se encontraran los atributos basicos de una red social y los metodos necesarios para poder interactuar en ella.
 * Requerimientos funcionales cubiertos en este archivo.
 * @version 1.4, 23/08/2021
 * @author Eduardo Abarca
 */
public class ImplementacionRedSocial implements RedSocial
{
    /* /////////////////////////////////////////////////// ATRIBUTOS /////////////////////////////////////////////////// */
    private final String NombreRedSocial;
    private final String FechaRegistroRedSocial;
    final ArrayList<Usuario> ListaUsuarios;
    private String UsuarioLogueado;
    
    /* //////////////////////////////////////////////////// METODOS //////////////////////////////////////////////////// */
    
    /* CONSTRUCTOR */

    /**
     * Constructor para ImplementacionRedSocial
     * @param NombreAsignado Nombre para red social
     */

    public ImplementacionRedSocial(String NombreAsignado)
    {
        this.NombreRedSocial = NombreAsignado;
        this.FechaRegistroRedSocial = FechaDeHoy();
        this.ListaUsuarios = new ArrayList<>();
        this.UsuarioLogueado = null;
    }
    
    /* GETTERS */

    /**
     * Getter para NombreRedSocial
     * @return NombreRedSocial (String)
     */
    public String getNombreRedSocial()
    {return this.NombreRedSocial;}
    
    /**
     * Getter para FechaRegistroRedSocial
     * @return NombreRedSocial (String)
     */
    public String getFechaRegistroRedSocial()
    {return this.FechaRegistroRedSocial;}
    
    /**
     * Getter para UsuarioLogueado
     * @return UsuarioLogueado (String)
     */
    public String getUsuarioLogueado()
    {return this.UsuarioLogueado;}
    
    /**
     * Getter para ListaUsuarios
     * @return ListaUsuarios (ArrayList< Usuario >)
     */
    @Override
    public ArrayList<Usuario> getUsuariosRegistrados()
    {return this.ListaUsuarios;}
    
    /* SETTERS */
    
    /**
     * Primer setter para UsuarioLogueado
     * @param Usuario Usuario registrado que inicio sesion
     */
    @Override
    public void AsignarUsuarioLogueado(String Usuario)
    {this.UsuarioLogueado = Usuario;}
    
    /**
     * Segundo setter para UsuarioLogueado.
     */
    @Override
    public void ExpulsarUsuarioLogueado()
    {this.UsuarioLogueado = null;}
    
    /* //////////////////////////////////////////////// METODOS DE APOYO //////////////////////////////////////////////// */

    /**
     * Metodo que genera la fecha de la ejecucion de este programa, a registrar en las clases a instanciar
     * @return Fecha en formato String dd/mm/yyyy 
     */
    @Override
    public String FechaDeHoy()
    {
        //Instancia de Calendar, para poder obtener la fecha de hoy
        Calendar calendario = Calendar.getInstance();
        
        //Se obtiene cada parte de la fecha, convirtiendo de int a string
        String anio = Integer.toString(calendario.get(Calendar.YEAR));
        String mes = Integer.toString(calendario.get(Calendar.MONTH)+1);
        String dia = Integer.toString(calendario.get(Calendar.DATE));
        
        //Se retorna un string con la fecha en formato dd/mm/yyyy
        return dia+"/"+mes+"/"+anio;
    }
        
    /**
     * Metodo que verifica si el usuario a registrar no esta en uso
     * @param Usuario Usuario a registrar
     * @param Contrasenia Contrasenia a registrar
     * @return Booleano -> false: Usuario esta en uso / true: Usuario esta disponible para ser registrado
     */
    @Override
    public boolean ValidarDatosRegistro(String Usuario, String Contrasenia)
    {
        boolean UsuarioEnUso = false, ContraseniaEnUso = false, EsPosibleRegistro;
        
        //Se revisa lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario, no es posible registro
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                UsuarioEnUso = true;
                break;
            }
            // Se encontro contrasenia, se definio que no se pueden repetir entre usuarios
            else if (this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
            {
                ContraseniaEnUso = true;
                break;
            }
        }
        
        //Retorno resultado: Usuario no esta en uso y contrasenia no esta en uso
        return !(UsuarioEnUso) && !(ContraseniaEnUso);
    }
    
    /**
     * Metodo que verifica la validez de las credenciales ingresadas (i.e., que existe un usuario con esos datos)
     * @param Usuario Usuario que quiere iniciar sesion
     * @param Contrasenia Contrasenio de usuario que quiere iniciar sesion
     * @return Booleano -> false: Datos de usuario y contrasenia no coinciden con ningun usuario / true: Ambos parametros coinciden con un solo usuario
     */
    @Override
    public boolean ValidarCredenciales(String Usuario, String Contrasenia)
    {
        boolean ExisteUsuario = false, ContraseniaCoincide = false;
        
        //Se revisa lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario, se guarda registro de esto en su variable respectiva
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                ExisteUsuario = true;
                
                //Si la contrasenia tambien coincide, se almacena registro de esto
                if(this.ListaUsuarios.get(i).getContrasenia().equals(Contrasenia))
                {
                    ContraseniaCoincide = true;
                    break;
                }
                
                break;
            }
        }
        
        //Se retorna resultado
        return ExisteUsuario && ContraseniaCoincide;
    }
    
    /**
     * Metodo que retorna la posicion en el ArrayList del usuario apuntado por parametro
     * @param Usuario Usuario al que se busca obtener su ubicacion (indice)
     * @return Entero, valor de su posicion (indice) en su coleccion (ArrayList)
     */
    @Override
    public int getUsuarioViaUsername(String Usuario)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra usuario)
        int IndiceUsuarioRetorno = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Se encontro usuario apuntado, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getNombreUsuario().equals(Usuario))
            {
                IndiceUsuarioRetorno = i;
                break;
            }
        }
        
        //Se retorna resultado
        return IndiceUsuarioRetorno;
    }
    
    /**
     * Metodo que, en base al ID de una publicacion original, retorna la posicion del usuario duenio de tal publicacion
     * @param id ID publicacion original apuntada
     * @return Posicion (indice) en el ArrayList del usuario duenio de la publicacion
     */
    @Override
    public int ReferenciarUsuarioPublicacionOr(int id)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra publicacion original con ese id)
        int IndiceUsuario = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Si el usuario actual tiene una publicacion original con ese id, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getPublicacionOriginalPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        
        //retorno de indice
        return IndiceUsuario;
    }
    
    /**
     * Metodo que, en base al ID de una publicacion compartida, retorna la posicion del usuario duenio de tal publicacion 
     * @param id ID publicacion compartida apuntada
     * @return Posicion (indice) en el ArrayList del usuario duenio de la publicacion
     */
    @Override
    public int ReferenciarUsuarioPublicacionComp(int id)
    {
        //Variable a retornar (por defecto -1 por si no se encuentra publicacion compartida con ese id)
        int IndiceUsuario = -1;
        
        //Se recorre lista usuarios
        for(int i = 0; i < this.ListaUsuarios.size(); i++)
        {
            //Si el usuario actual tiene una publicacion compartida con ese id, se guarda indice y se corta ciclo for
            if(this.ListaUsuarios.get(i).getPublicacionCompartidaPorId(id) != -1)
            {
                IndiceUsuario = i;
                break;
            }
        }
        
        //retorno de indice
        return IndiceUsuario;
    }
    
    
    /**
     * Metodo que busca al usuario logueado en el ArrayList de usuarios y revisa si los destinos ingresados por parametros estan en sus contactos
     * @param ListaDestinos Destinos ingresados por consola/terminal
     * @return Boolean -> true: Todos los destinos estan en contactos / false: Algun/ningun destino no esta en contactos
     */
    @Override
    public boolean ValidarDestinos(ArrayList<String> ListaDestinos)
    {
        return this.ListaUsuarios.get(getUsuarioViaUsername(this.UsuarioLogueado)).EstanDestinosEnContactos(ListaDestinos);
    }
    

    /* /////////////////////////////////////////// REQUERIMIENTOS FUNCIONALES /////////////////////////////////////////// */

    /**
     * Requerimiento funcional Register, parte de Authentication, registra un usuario en la red social
     * @param UsuarioARegistrar Usuario que se busca registrar
     * @param ContraseniaARegistrar Contrasenia a ligar al usuario
     * @return 
     */
    @Override
    public String Register(String UsuarioARegistrar, String ContraseniaARegistrar)
    {
        //Se declara string retorno con resultado operacion
        String Resultado = "";
        
        //Si los datos estan disponibles, se registra nuevo usuario
        if(ValidarDatosRegistro(UsuarioARegistrar, ContraseniaARegistrar))
        {
            Usuario NuevoUsuario = new Usuario(UsuarioARegistrar, ContraseniaARegistrar);
            this.ListaUsuarios.add(NuevoUsuario);
            Resultado += "Usuario registrado exitósamente!";
        }
        
        //Caso contrario, no es posible registrar nuevo usuario, advertencia de esto por consola/terminal
        else
        {Resultado += "Error: Nombre de usuario ya esta en uso.";}
        
        //Retorno string con resultado
        return Resultado;
    }
    
    /**
     * Requermiento funcional Login, parte de Authentication, inicia sesion con un usuario registrado
     * @param UsuarioLogin
     * @param ContraseniaLogin
     * @return 
     */
    @Override
    public String Login(String UsuarioLogin, String ContraseniaLogin)
    {
        //Se declara string retorno con resultado operacion
        String Resultado = "";
        
        //Si se encontro un usuario que coincida con las credenciales ingresadas, se inicia sesion con ese usuario
        if(ValidarCredenciales(UsuarioLogin, ContraseniaLogin))
        {
            //Asignacion usuario que inicio sesion
            AsignarUsuarioLogueado(UsuarioLogin);
            
            //Agregar resultado al string
            Resultado += "Sesion iniciada exitosamente!";
        }
        
        else
        {Resultado += "Error: Credenciales ingresadas no coinciden con ningun usuario.";}
        
        return Resultado;
    }
    
    /**
     * Requerimiento funcional Logout, parte de Authentication, finaliza la sesion del usuario logueado
     */
    @Override
    public void Logout()
    {ExpulsarUsuarioLogueado();}
    
    /**
     * Requerimiento funcional Post, el usuario con sesion iniciada realiza una publicacion en la red social, teniendo la posibilidad de asignar destinatarios a esta.
     * @param TipoPublicacion Tipo de la publicacion creada
     * @param ContenidoPublicacion Contenido (Cuerpo) de la publicacion
     * @param UsuariosDestino Lista de contactos a los cuales se les destina la publicacion
     * @return 
     */
    @Override
    public String Post(String TipoPublicacion, String ContenidoPublicacion, ArrayList<String> UsuariosDestino)
    {
        //Se declara string retorno con resultado operacion
        String Resultado = "";
        
        //Crear publicacion
        PublicacionOriginal NuevaPublicacion = new PublicacionOriginal(FechaDeHoy(), this.UsuarioLogueado, TipoPublicacion, ContenidoPublicacion, UsuariosDestino);
            
        //Referenciar indice usuario logueado 
        int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
            
        //Agregar publicacion a espacio usuario logueado
        this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesUsuario.add(NuevaPublicacion);
        
        //Retorno string se vera en 2 casos: Si hay o no destinatarios (El programa esta hecho para que se ingresen destinos validos)
        if(UsuariosDestino.isEmpty())
        {Resultado += "Publicacion sin destinos creada exitosamente!";}
        else
        {Resultado += "Publicacion con destinos creada exitosamente!";}
        
        //Se retorna string con resultado
        return Resultado;
    }
    
    /**
     * Requerimiento funcional Follow, el usuario con sesion iniciada sigue a otro usuario registrado en la red social 
     * @param UsuarioApuntado
     * @return 
     */
    @Override
    public String Follow(String UsuarioApuntado)
    {
        //Se declara string salida
        String Resultado = "";
        
        //Indices de usuario ingresado por parametro y usuario logueado
        int IndiceUsuarioApuntado = getUsuarioViaUsername(UsuarioApuntado);
        int IndiceUsuarioLogueado = getUsuarioViaUsername(this.UsuarioLogueado);
        
        // Si el usuario ya se siguio previamente, no se puede seguir de nuevo, advertencia de esto por consola/terminal
        if(this.ListaUsuarios.get(IndiceUsuarioLogueado).EstaEnSeguidos(UsuarioApuntado)) 
        {Resultado += "Error: Usuario a seguir ya esta seguido.";}
            
        // Usuario a seguir es el mismo con el que se inicio sesion, advertencia de esto por consola/terminal
        else if (IndiceUsuarioApuntado == IndiceUsuarioLogueado)
        {Resultado += "Error: Usuario apuntado es usuario logueado.";}
        
        //Se cumplen condiciones, se sigue usuario apuntado
        else 
        {
            //Se agregan usuarios en respectivos espacios:
            //Se agrega a seguidores de usuario apuntado el usuario logueado
            this.ListaUsuarios.get(IndiceUsuarioApuntado).AgregarSeguidor(this.UsuarioLogueado);
            
            //Se agrega a seguidos de usuario logueado el usuario apuntado
            this.ListaUsuarios.get(IndiceUsuarioLogueado).AgregarSeguimiento(UsuarioApuntado);
            
            //Se agrega resultado a string retorno
            Resultado += "Usuario "+ UsuarioApuntado +" seguido desde "+ this.UsuarioLogueado +" exitosamente!";
        }
        
        return Resultado;
    }

    /**
     * Requerimiento funcional Share, el usuario con sesion iniciada compartira una publicacion ya creada, ya sea a los destinos asignados o en su propio espacio (sin destinos).
     * @param IdPublicacion ID de la publicacion a compartir
     * @param UsuariosDestino Lista de destinos (contactos) a compartir la publicacion
     * @return String con el resultado de la operacion
     */
    @Override
    public String Share(int IdPublicacion, ArrayList<String> UsuariosDestino)
    {
        //Se declara string retorno con resultado operacion
        String Resultado = "";
        
        //Se obtiene indice usuario al que le pertenece la publicacion original con ese ID
        int IndiceUsuarioPublicacion = this.ReferenciarUsuarioPublicacionOr(IdPublicacion);
        
        //Se recupera indice publicacion a compartir
        int IndicePublicacion = this.ListaUsuarios.get(IndiceUsuarioPublicacion).getPublicacionOriginalPorId(IdPublicacion);
            
        //Si no hay destinos, se comparte en espacio de usuario logueado
        if(UsuariosDestino.isEmpty())
        {
            int IndiceUsuarioLogueado = this.getUsuarioViaUsername(this.UsuarioLogueado);
            
            //Se instancia publicacion compartida
            PublicacionCompartida CompartidoLogueado = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).PublicacionesUsuario.get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, this.UsuarioLogueado);   

            //Se agrega publicacion compartida a espacio usuario destino actual
            this.ListaUsuarios.get(IndiceUsuarioLogueado).PublicacionesCompartidas.add(CompartidoLogueado);
            
            //Se agrega a string retorno el resultado de la operacion
            Resultado += "Post compartido a espacio propio exitosamente!";
        }
        
        //Caso contrario, se comparte en espacio de cada contacto
        else
        {
            //String para presentar en resultado
            String StringUsuariosCompartidos = "";
            
            //Se debe compartir la publicacion para cada usuario, se recorre la lista de destinos
            for(int i = 0; i < UsuariosDestino.size(); i++)
            {
                //Se recupera indice usuario
                int IndiceUsuarioActual = this.getUsuarioViaUsername(UsuariosDestino.get(i));
                
                //Se instancia publicacion compartida
                PublicacionCompartida CompartidoADestino = new PublicacionCompartida(this.ListaUsuarios.get(IndiceUsuarioPublicacion).PublicacionesUsuario.get(IndicePublicacion), IdPublicacion, FechaDeHoy(), this.UsuarioLogueado, this.ListaUsuarios.get(IndiceUsuarioActual).getNombreUsuario());
         
                //Se agrega publicacion compartida a espacio destino actual
                this.ListaUsuarios.get(IndiceUsuarioActual).PublicacionesCompartidas.add(CompartidoADestino);
                
                //Se agrega resultado a string 
                StringUsuariosCompartidos += UsuariosDestino.get(i)+" ";
            }
            
            //Se agrega resultado a string retorno
            Resultado += "Post compartido a los usuarios "+ StringUsuariosCompartidos +"exitosamente!";
        }
        
        //Se retorna string con resultado opeacion
        return Resultado;
    }
    

    /**
     * Requerimiento funcional optativo Comment, el usuario con sesion iniciada realiza un comentario en la red social, y este puede ser dirigido a una publicacion o como respuesta a otro comentario.
     * @param IdPublicacion ID publicacion a comentar
     * @param IdComentario ID comentario a responder dentro de la publicacion apuntada (0 si se desea comentar la publicacion)
     * @param ContenidoComentario Contenido (cuerpo) del comentario
     * @return 
     */
    @Override
    public String Comment(int IdPublicacion, int IdComentario, String ContenidoComentario)
    {
        //Se declara string que se usara como retorno
        String Resultado = "";
        
        //Revisar si el comentario va hacia una publicacion compartida o una publicacion original (referenciar indice)
        int IndiceUsuarioPublicacionOr = ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndiceUsuarioPublicacionComp = ReferenciarUsuarioPublicacionComp(IdPublicacion);
        
        // Resultado distinto de -1, el ID pertenece a una publicacion original
        if(IndiceUsuarioPublicacionOr > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).getPublicacionOriginalPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se crea comentario
                Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", ContenidoComentario);
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.add(NuevoComentario);
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    //Obtener usuario que realizo comentario para mencionar en comentario a crear
                    String UsuarioAMencionar = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).getAutorReaccion();
                    
                    //Instanciar comentario
                    Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", "@"+UsuarioAMencionar+ " "+ContenidoComentario);
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.add(NuevoComentario);
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    Resultado += "Error: No existe comentario con ese ID dentro de la publicacion seleccionada";
                }
            }
        }
        
        // Resultado distinto de -1, el ID pertenece a una publicacion compartida
        else if(IndiceUsuarioPublicacionComp > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).getPublicacionCompartidaPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se crea comentario
                Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", ContenidoComentario);
                
                //Se agrega comentario al espacio de comentarios de la publicacion compartida
                this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.add(NuevoComentario);
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    //Obtener usuario que realizo comentario para mencionar en comentario a crear como respuesta
                    String UsuarioAMencionar = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).getAutorReaccion();
                    
                    //Instanciar comentario
                    Comentario NuevoComentario = new Comentario(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Comentario", "@"+UsuarioAMencionar+ " "+ContenidoComentario);
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.add(NuevoComentario);
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    Resultado += "Error: No existe comentario con ese ID dentro de la publicacion seleccionada";
                }
            }
        }
        // No existe publicacion con ese ID
        else
        {Resultado += "Error: No existe publicacion con ese ID.";}
        
        //Retorno de string con resultado
        return Resultado;
    }
    
    /**
     *  Requerimiento funcional optativo Like, el usuario con sesion iniciada realiza un "Me gusta", ya sea a una publicacion o un comentario.
     * @param IdPublicacion ID publicacion a dar like
     * @param IdComentario ID comentario a dar like (0 para dar like a publicacion)
     * @return 
     */
    @Override
    public String Like(int IdPublicacion, int IdComentario)
    {
        //Se declara string retorno con resultado operacion
        String Resultado = "";
        
        //Revisar si el like va hacia una publicacion compartida o una publicacion original (referenciar indice)
        int IndiceUsuarioPublicacionOr = ReferenciarUsuarioPublicacionOr(IdPublicacion);
        int IndiceUsuarioPublicacionComp = ReferenciarUsuarioPublicacionComp(IdPublicacion);
        
        // Resultado distinto de -1, el ID pertenece a una publicacion original
        if(IndiceUsuarioPublicacionOr > -1)
        {
            //Se recupera posicion de la publicacion a agregar like
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).getPublicacionOriginalPorId(IdPublicacion);
            
            //Revisar caso si es like a publicacion o a otro comentario (y que el like en tal instancia no exista por parte del usuario)
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se instancia like
                Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).LikesPublicacionOr.add(NuevoLike);
                
                
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    
                    //Se instancia like
                    Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                    
                    //Se agregaa like en espacio de likes del comentario
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).ComentariosPublicacionOr.get(IndiceComentario).LikesComentario.add(NuevoLike);
                    
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        
        // Resultado distinto de -1, el ID pertenece a una publicacion compartida
        else if(IndiceUsuarioPublicacionComp > -1)
        {
            //Se recupera posicion de la publicacion a agregar comentario
            int IndicePublicacionApuntada = this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).getPublicacionCompartidaPorId(IdPublicacion);
            
            //Revisar caso si es comentario a publicacion o a otro comentario (y que el like en tal instancia no exista por parte del usuario)
            if(IdComentario == 0) //Se comenta publicacion
            {
                //Se instancia like
                Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                
                //Se agrega comentario al espacio de comentarios de la publicacion
                this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).LikesPublicacionComp.add(NuevoLike);
                
                   
            }
            else //Buscar comentario a responder
            {
                //Verificar si existe comentario en publicacion
                int IndiceComentario = this.ListaUsuarios.get(IndiceUsuarioPublicacionOr).PublicacionesUsuario.get(IndicePublicacionApuntada).getComentarioViaIdReaccion(IdComentario);
                if(IndiceComentario > -1)
                {
                    
                    //Se instancia like
                    Like NuevoLike = new Like(IdPublicacion, IdComentario, FechaDeHoy(), this.UsuarioLogueado, "Like");
                    
                    
                    //Agregar comentario en espacio respectivo
                    this.ListaUsuarios.get(IndiceUsuarioPublicacionComp).PublicacionesCompartidas.get(IndicePublicacionApuntada).ComentariosPublicacionComp.get(IndiceComentario).LikesComentario.add(NuevoLike);
                    
                    
                }
                else //No existe comentario con ese ID en la publicacion, se muestra mensaje por consola
                {
                    System.out.println("Error: No existe comentario con ese ID dentro de la publicacion seleccionada.\n");
                }
            }
        }
        // No existe publicacion con ese ID
        else
        {System.out.println("Error: No existe publicacion con ese ID.\n");}
        
        //Se retorna string resultado
        return Resultado;
    }
}
