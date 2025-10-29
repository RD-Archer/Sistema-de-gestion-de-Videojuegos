package com.PINACOMP.Excepciones;

import java.text.Normalizer;

public class TextoInvalidoException extends Exception{
    public TextoInvalidoException (String mensaje){super(mensaje);}

    public static String normalizar(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[\\p{InCombiningDiacriticalMarks}]", "").toLowerCase().trim();
    }
    public static void validarTextoComun(String campo, String valor) throws TextoInvalidoException {
        if (valor == null || normalizar(valor).length() < 2) {
            throw new TextoInvalidoException("El campo '" + campo + "' es inválido o demasiado corto.");
        }
    }

}
