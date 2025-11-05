package com.PINACOMP.Excepciones;

public class PrecioInvalidoException extends Exception {

    public PrecioInvalidoException (String mensaje){super(mensaje);}

    public static Double validar(double precio) throws PrecioInvalidoException{
        if(precio==0){
            throw new PrecioInvalidoException("No puedes tener un precio de cero");
        }
        if(precio<0){
            throw new PrecioInvalidoException("No puedes tener un precio negativo");
        }
        return precio;
    }
}
