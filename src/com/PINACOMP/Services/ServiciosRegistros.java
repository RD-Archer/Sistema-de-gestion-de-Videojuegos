package com.PINACOMP.Services;

import com.PINACOMP.Excepciones.EdadInvalidadException;

public class ServiciosRegistros {


    public static int solicitarEdadValida() {
        while (true) {
            try {
                System.out.print("Ingrese su edad: ");
                int edad = lectura.entradaValoresSafe();
                EdadInvalidadException.validarEdad(edad);
                return edad;
            } catch (EdadInvalidadException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
