package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class CorreoInvalidoException extends Exception{
    public CorreoInvalidoException (String mensaje){super(mensaje);}
    private static final Pattern PATRON_CORREO = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú0-9._-]+@[A-Za-z]+\\.[A-Za-z]{2,}$");

    public static String validarCorreo(String correo) throws CorreoInvalidoException {
        if (correo==null||correo.trim().isEmpty()){
            throw new CorreoInvalidoException("El correo no puede estar vacio");
        }
        if(!PATRON_CORREO.matcher(correo).matches()){
            throw new CorreoInvalidoException("El correo ingresado no es valido");
        }
        return "Correo valido";
    }
}
