package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class CorreoInvalidoException extends Exception{
    public CorreoInvalidoException (String mensaje){super(mensaje);}
    private static final Pattern PATRON_CORREO = Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóú0-9._-]+@[A-Za-z]+\\.[A-Za-z]{2,}$");
}
