package com.PINACOMP.models.enums;

public enum TipoGenero {
    TERROR(" Videojuego de Terror"),
    ACCION("Videojuego Accion");
    private String genero;

    TipoGenero(String genero) {
        this.genero = genero;
    }
}
