package com.PINACOMP.models.enums;

public enum TipoClasificacion {
    A("A - Todo Público"),
    B("B - Mayores de 12 años"),
    B15("B15 - Mayores de 15 años"),
    C("C - Mayores de 18 años"),
    D("D - Solo para adultos");
    private String clasificacion;

    public String getClasificacion() {
        return clasificacion;
    }

    TipoClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
