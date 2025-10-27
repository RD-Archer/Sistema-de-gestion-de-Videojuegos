package com.PINACOMP.Excepciones;

import java.util.regex.Pattern;

public class ContraseñaInvalidaException extends RuntimeException {
    public ContraseñaInvalidaException(String message) {
        super(message);
    }
    private static final Pattern PATRON_CONTRASEÑA=Pattern.compile("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    public static String validarContraseña(String contraseña)throws ContraseñaInvalidaException{
        if (contraseña==null||contraseña.trim().isEmpty()){
            throw new ContraseñaInvalidaException("La contraseña no puede estar vacía.");

        }
        if (!PATRON_CONTRASEÑA.matcher(contraseña).matches()){
            throw new ContraseñaInvalidaException("La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.");
        }
        return "Contraseña valida";
    }
}
