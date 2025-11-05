package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class DesarrolladoraInvalidaException extends Exception{
    private static final Pattern PATRON_TITULO =
            Pattern.compile("^(?:[A-Za-z0-9]+(?:\\s+[A-Za-z0-9]+){0,4})$");
    public DesarrolladoraInvalidaException(String mensaje){super(mensaje);}

    public static String validar(String titulo) throws DesarrolladoraInvalidaException {
        if(titulo==null || titulo.trim().isEmpty()){
            throw new DesarrolladoraInvalidaException("El nombre de la desarrolladora no puede estar vacia");
        }
        titulo.trim();
        if(!PATRON_TITULO.matcher(titulo).matches()){
            throw new DesarrolladoraInvalidaException("El nombre de la desarrolladora solo puede contener letras, números y hasta 5  palabras");
        }
        String[] palabras = titulo.split("\\s+");
        if(palabras.length>5){
            throw new DesarrolladoraInvalidaException("El nombre de la desarrolladora no puede tener más de 5 palabras");
        }
        return titulo;
    }
}
