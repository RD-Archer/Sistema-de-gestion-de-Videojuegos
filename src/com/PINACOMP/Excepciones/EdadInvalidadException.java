package com.PINACOMP.Excepciones;

public class EdadInvalidadException extends Exception {
    public EdadInvalidadException (String mensaje){
        super(mensaje);
    }

    public static void validarEdad(int edad) throws EdadInvalidadException {
        if (edad<=0){
            throw new EdadInvalidadException("La edad no puede ser menor a 0");

        } else if (edad>0&&edad<18) {
            throw new EdadInvalidadException("Debes de ser mayor de edad");

        }

    }

}
