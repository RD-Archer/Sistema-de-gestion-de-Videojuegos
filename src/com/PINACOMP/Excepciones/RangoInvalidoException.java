package com.PINACOMP.Excepciones;

public class RangoInvalidoException extends RuntimeException {
    public RangoInvalidoException(String message) {
        super(message);
    }



    public static void validarRango(int opcion,int min, int max){
        if(opcion<min || opcion>max){
            throw new RangoInvalidoException("Opcion fuera de rango ("+min+"-"+max+").");

        }
    }


}

