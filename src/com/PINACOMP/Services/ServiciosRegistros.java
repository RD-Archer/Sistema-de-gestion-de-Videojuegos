package com.PINACOMP.Services;

import com.PINACOMP.Excepciones.ContraseñaInvalidaException;
import com.PINACOMP.Excepciones.CorreoInvalidoException;
import com.PINACOMP.Excepciones.EdadInvalidadException;

import static com.PINACOMP.Services.lectura.entradaValoresTexto;

public class ServiciosRegistros {

    //validar edad para todo tipos de usuario
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
    //Validar correo para todo tipos de usuarios
    public static String solicitarCorreoValido(){
        while (true){
            try{
                System.out.print("Ingrese su dirección de correo: ");
                String correo=entradaValoresTexto();
                CorreoInvalidoException.validarCorreo(correo);
                return correo;
            }catch (CorreoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //Validar contraseña para todo tipos de usuarios
    public static String solicitarContraseñaValida(){
        while (true){
            try {
                System.out.println("Ingrese su contraseña(La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.)");
                String contraseña=entradaValoresTexto();
                ContraseñaInvalidaException.validarContraseña(contraseña);
                return contraseña;
            }catch (ContraseñaInvalidaException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void solicitarConfirmacionContraseñaValida(String original){
        while (true){
            System.out.println("Vuelva a ingresar su contraseña");
            String confimacion=entradaValoresTexto();
            if (confimacion.equals(original)){
                break;
            }else {
                System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
            }
        }

    }

}
