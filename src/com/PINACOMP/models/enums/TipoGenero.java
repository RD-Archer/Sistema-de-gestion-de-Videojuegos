package com.PINACOMP.models.enums;

public enum TipoGenero {
    TERROR(" Videojuego de Terror"),
    ACCION("Videojuego de Accion"),
    AVENTURA("Videojuego de Aventura"),
    SHHOTERS("Videojuego de Shooters"),
    RPG("Videojuego de RPG"),
    SIMULACION("Videojuego de Simulacion"),
    PLATAFORMA("Videojuego de Plataforma"),
    DEPORTES("Videojuego de Deportes"),
    MMORPG("Videojuego del MMORPG"),
    BATTLEROYALE("Videojuego de Battle Royale");

    private String genero;

    TipoGenero(String genero) {
        this.genero = genero;
    }
}
