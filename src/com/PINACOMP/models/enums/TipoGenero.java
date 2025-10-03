package com.PINACOMP.models.enums;

public enum TipoGenero {
    TERROR("Terror"),
    ACCION("Accion"),
    AVENTURA("Aventura"),
    SHHOTERS("Shooters"),
    RPG("RPG"),
    SIMULACION("Simulacion"),
    PLATAFORMA("Plataforma"),
    DEPORTES("Deportes"),
    MMORPG("MMORPG"),
    BATTLEROYALE("Battle Royale");

    private String genero;

    TipoGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
