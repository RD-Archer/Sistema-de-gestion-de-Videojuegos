package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class DireccionInvalidaException extends RuntimeException {
    public DireccionInvalidaException(String message) {
        super(message);
    }
    public static final Pattern Pais_Patron = Pattern.compile("^[A-ZÁÉÍÓÚÑ][a-záéíóúñA-ZÁÉÍÓÚÑ\\s\\-]{1,49}$");
    public static final Pattern DireccionPostal_Patron = Pattern.compile("^[A-ZÁÉÍÓÚÑ][a-záéíóúñA-ZÁÉÍÓÚÑ0-9\\s\\-\\.,#]{4,99}$");


    public static String validarPais(String pais)throws DireccionInvalidaException{
        if (pais==null||pais.trim().isEmpty()){
            throw new DireccionInvalidaException("El pais no puede estar vacío ");

        }
        if(!Pais_Patron.matcher(pais).matches()){
            throw new DireccionInvalidaException("El pais no es valido: "+pais);

        }
        return pais;
    }

    public static int validarCodigoPostal(int codigoPostal){
        if(codigoPostal < 1000 || codigoPostal > 99999){
            throw new DireccionInvalidaException("El codigo postal ingresado no es valido: "+codigoPostal);

        }
        return codigoPostal;
    }
    public static String validarDireccionPostal(String direccionPostal){
        if(direccionPostal.trim().isEmpty()){
        throw new DireccionInvalidaException("La direccion no puede estar vacia.");
        }
        if(!DireccionPostal_Patron.matcher(direccionPostal).matches()){
            throw new DireccionInvalidaException("La direccion ingresada no es valida: "+direccionPostal);

        }
        return direccionPostal;

    }

}
