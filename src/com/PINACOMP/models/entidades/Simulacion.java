package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoSimulacion;

import java.time.LocalDate;
import java.util.Date;

public class Simulacion  extends Videojuegos{
    private String ciudad;
    private TipoSimulacion simulacion;

    public Simulacion(String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores, String ciudad, TipoSimulacion simulacion) {
        super(titulo, precio, plataforma, clasificacion, genero, anioLanzamiento, desarrolladora, noJugadores);
        this.ciudad = ciudad;
        this.simulacion = simulacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public TipoSimulacion getSimulacion() {
        return simulacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" La ciudad es: ").append(ciudad);
        sb.append(" Juego de  ").append(simulacion);
        return super.toString() + sb.toString();
    }
}
