package com.PINACOMP.models.enums;

public enum TipoEstado {
    ACTIVO("Activo. "),
    PENDIENTE("Inactivo o suspendido."),
    BAJA("Baja.");

    private String estado;

    TipoEstado(String estado) {
        this.estado = estado;
    }
    public String toString(){
        return estado;
    }
}
