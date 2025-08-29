package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoConsola;

import java.time.LocalDate;

public class Sistema {
    TipoConsola consola;
    String creador;
    String version;
    LocalDate anioLanzamiento;

    public Sistema(TipoConsola consola, String creador, String version, LocalDate anioLanzamiento) {
        this.consola = consola;
        this.creador = creador;
        this.version = version;
        this.anioLanzamiento = anioLanzamiento;
    }

    public TipoConsola getConsola() {
        return consola;
    }

    public String getCreador() {
        return creador;
    }

    public String getVersion() {
        return version;
    }

    public LocalDate getAnioLanzamiento() {
        return anioLanzamiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("").append(consola);
        sb.append("\nEl creador de la consola es: ").append(creador);
        sb.append("\nLa version de la consola es un: ").append(version);
        sb.append("\nEl año de lanzamiento de la consola es: ").append(anioLanzamiento);

        return sb.toString() ;
    }
}
