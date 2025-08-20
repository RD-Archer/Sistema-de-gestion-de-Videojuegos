package com.PINACOMP.models.enums;

public enum Pais {
    MEXICO("País - México"),
    BRASIL("País - Brasil"),
    EUROPA("País - Francia"),
    EUo("País - Estados Unidos"),
    JAPON("País - Japón"),
    AUSTRALIA("País - Austraia");
    private String pais;

    Pais(String pais) {
        this.pais = pais;
    }
}
