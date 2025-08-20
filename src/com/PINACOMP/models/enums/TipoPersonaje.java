package com.PINACOMP.models.enums;

public enum TipoPersonaje {
    COMBATIENTES("Personaje Combatiente"),
    MAGOS("Personaje Mago"),
    SANADORES("Personaje Sanador"),
    LADRON("Personaje Ladrón"),
    APOYO("Personaje de Apoyo");
    private String personaje;

    TipoPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public String toString() {
        return personaje;
    }
}
