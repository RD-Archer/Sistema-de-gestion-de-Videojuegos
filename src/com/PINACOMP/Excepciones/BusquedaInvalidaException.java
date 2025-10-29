package com.PINACOMP.Excepciones;

import com.PINACOMP.models.entidades.Usuario;

public class BusquedaInvalidaException extends Exception{
    public BusquedaInvalidaException(String mensaje){super(mensaje);}

    /*public static Usuario ValidarUsuario(Usuario u){
        if (u==null||u.trim().isEmpity)

    }*/
}
