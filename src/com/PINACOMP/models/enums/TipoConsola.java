package com.PINACOMP.models.enums;

public enum TipoConsola {
    XBOX("Consola - XBOX"),
    PLAYSTATION("Consola - PlayStation"),
    NINTENDO("Consola - Nintendo");
    private String consola;

    TipoConsola(String consola) {
        this.consola = consola;
    }
}
