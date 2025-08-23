package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;
import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    protected String correo;
    protected String contraseña;
    protected TipoUsuario rol;


    public Usuario(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, String correo, String contraseña, TipoUsuario rol) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio);
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public TipoUsuario getTipoUsuario() {
        return rol;

    }
        //temporal
    public List <Usuario> usuariosEstaticos(){
        List <Usuario> Usuarios=new ArrayList<>();
    Usuarios.add(new Usuario("Rogelio","Quiroz","San Vicente",19,Genero.MASCULINO,"xxxxxxxx","correoprueba06@gmail.com","contraseñaPreba08",TipoUsuario.Administrador));

        return Usuarios;
    }

    public boolean InicioSecion(String correoIngresado, String contraseñaIngresada){
        return this.correo.equals(correoIngresado) && this.contraseña.equals(contraseñaIngresada);

    }
    public Videojuegos ActualizarVideojuegos(Videojuegos videojuegos){
        System.out.println("Funcion no implementada");
        return videojuegos;
    }
    public Videojuegos agregarVideojuegos(Videojuegos videojuegos){
        System.out.println("Funcion no implementada");
        return videojuegos;
    }
    public Videojuegos EliminarVideojuegos(Videojuegos videojuegos){
        System.out.println("Funcion no implementada");
        return videojuegos;
    }

}

