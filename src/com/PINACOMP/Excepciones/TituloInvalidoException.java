package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class TituloInvalidoException extends Exception{
    private static final Pattern PATRON_TITULO =
            Pattern.compile("^(?:[A-Za-z0-9]+(?:\\s+[A-Za-z0-9]+){0,4})$");
    public TituloInvalidoException(String mensaje){super(mensaje);}

    public static String validar(String titulo) throws TituloInvalidoException{
        if(titulo==null || titulo.trim().isEmpty()){
            throw new TituloInvalidoException("El titulo del videojuego no puede estar vacio");
        }
        titulo.trim();
        if(!PATRON_TITULO.matcher(titulo).matches()){
            throw new TituloInvalidoException("El título solo puede contener letras, números y hasta 5  palabras");
        }
        String[] palabras = titulo.split("\\s+");
        if(palabras.length>5){
            throw new TituloInvalidoException("El título no puede tener más de 5 palabras");
        }
        return titulo;
    }
}
