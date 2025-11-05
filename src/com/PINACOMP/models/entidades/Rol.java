package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoPersonaje;
import com.PINACOMP.models.interfaces.ServicioVideojuegos;

import java.time.LocalDate;
import java.util.Date;

public class Rol extends Videojuegos implements ServicioVideojuegos {
    private TipoPersonaje personaje;
    private int cantNiveles;


    public Rol(int id, String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores, TipoPersonaje personaje, int cantNiveles, int stock) {
        super(id, titulo, precio, plataforma, clasificacion, genero, anioLanzamiento, desarrolladora, noJugadores,stock);
        this.personaje=personaje;
        this.cantNiveles= cantNiveles;
    }

    public TipoPersonaje getPersonaje() {
        return personaje;
    }

    public int getCantNiveles() {
        return cantNiveles;
    }

    @Override
    public void probarVideojuego() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("El ").append(personaje);
        sb.append(" El videojuego tiene la siguiente cantidad de niveles:  ").append(cantNiveles);
        return super.toString() + sb.toString();
    }
}
