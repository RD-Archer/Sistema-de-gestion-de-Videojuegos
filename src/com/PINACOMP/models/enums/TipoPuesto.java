package com.PINACOMP.models.enums;

public enum TipoPuesto {
    GERENTE("Gerente de tienda"),
    SUPERVISOR("Supervisor de area"),
    PRODUCTMANAGER("Product Manager"),
    ADMIN("Administrador de sistema"),
    VENDEDOR("Vendedor de videojuegos"),
    ANALISTA("Analista de datos"),
    ;
    private String puesto;

    TipoPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return puesto;
    }
}
