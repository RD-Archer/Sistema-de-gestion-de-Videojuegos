package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class NumeroInvalidoException extends RuntimeException {
    public NumeroInvalidoException(String message) {
        super(message);
    }
    private static final Pattern Patron_Numero=Pattern.compile("^\\d{10}");

    public static String validarTelefono(String telefono){
        if(telefono.trim().isEmpty()){
            throw new NumeroInvalidoException("El numero no puede estar vacio");
        }
        if(!Patron_Numero.matcher(telefono).matches()){
            throw new NumeroInvalidoException("El numero ingresado no es valido");
        }
        return telefono;
    }
}
