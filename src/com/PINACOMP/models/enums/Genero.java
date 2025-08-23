package com.PINACOMP.models.enums;

public enum Genero {
    MASCULINO("Masculino"),
    FEMENINO("Femenino"),
    BINARIO("Binario"),
    OTROS("39 Tipos de gay"); // a modificar

    private String genero;

    Genero(String genero) {
        this.genero=genero;
    }

    public String toString(){
        return genero;
    }
}
