package com.PINACOMP.Excepciones;

public class SueldoInvalidoException extends Exception {
    public SueldoInvalidoException(String mensaje ){
        super(mensaje);
    }

    //Metodos que validan y lanzan mensajes con posibles errores
    public static String validarSueldo(double sueldo) throws SueldoInvalidoException{
        if(sueldo==0){
            throw new SueldoInvalidoException("Sueldo invalido -> El sueldo no puede ser cero");
        }
        if(sueldo<0){
            throw new SueldoInvalidoException("Sueldo invalido -> El sueldo no puede ser negativo");
        }
        return "El sueldo  es valido";
    }
}
