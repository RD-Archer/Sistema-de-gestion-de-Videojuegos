package com.PINACOMP.models.enums;

public enum TipoCompra {
    FISICO("Version fisica."),
    DIGITAL("Version digital.");
    private String version;

    TipoCompra(String version){
        this.version=version;
    }

    @Override
    public String toString() {
        return version;
    }
}
