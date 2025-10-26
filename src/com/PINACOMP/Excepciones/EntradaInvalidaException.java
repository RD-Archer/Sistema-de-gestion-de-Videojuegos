package com.PINACOMP.Excepciones;

public class EntradaInvalidaException extends RuntimeException {
    public EntradaInvalidaException(String message) {
        super(message);
    }



    public static void validarRango(int opcion,int min, int max){
        if(opcion<min || opcion>max){
            throw new EntradaInvalidaException("Opcion fuera de rango ("+min+"-"+max+").");

        }
    }

}

