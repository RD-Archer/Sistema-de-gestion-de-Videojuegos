package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;
import com.PINACOMP.Data.UsuariosData;

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
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public boolean InicioSecion(String correoIngresado, String contraseñaIngresada){
        return correo.equals(correoIngresado) && contraseña.equals(contraseñaIngresada);

    }

    static UsuariosData data=new UsuariosData();
    public static boolean BuscarUsuario(String CorreoIngresado, String ContraseñaIngresado){
        for(Usuario u:data.getEmpleados()){
            if (u.getCorreo().equals(CorreoIngresado)){
                return true;

            }

        }

        return false;
    }



}

