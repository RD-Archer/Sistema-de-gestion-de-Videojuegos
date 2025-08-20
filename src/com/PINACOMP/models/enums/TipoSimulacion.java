package com.PINACOMP.models.enums;

public enum TipoSimulacion {
    VIDA("Simulación de Vida "),
    VUELO("Simulación de Vuelo"),
    CARRERAS("Simulación de Carreras"),
    CONSTRUCCION("Simulación de Construcción"),
    NAVEGACION("Simulación de Navegación");
    private String simulacion;

    TipoSimulacion(String simulacion) {
        this.simulacion = simulacion;
    }

    @Override
    public String toString() {
        return simulacion;
    }
}
