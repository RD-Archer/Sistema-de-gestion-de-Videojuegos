package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class NombreApellidosInvalidosException extends Exception{
    public  NombreApellidosInvalidosException(String mensaje){super(mensaje);}
    //Creando mi expresion regular
    private static final Pattern PATRON_NOMBRE_APELLIDOS= Pattern.compile("^[A-Za-zÁÉÍÓÚáéíóúÑñ]+(\\s[A-Za-zÁÉÍÓÚáéíóúÑñ]+){0,2}$");
    //Metodo validar Nombre
    public static String validarNombreApellido(String palabra) throws NombreApellidosInvalidosException{
        if(palabra == null || palabra.trim().isEmpty()){
            throw new NombreApellidosInvalidosException("El nombre o apellido no puede ser vacio");
        }
        if(!PATRON_NOMBRE_APELLIDOS.matcher(palabra.trim()).matches()){
            throw new NombreApellidosInvalidosException("Formato inválido");
        }
        return "Nombre o apellido corectamente capturado";
    }

}
