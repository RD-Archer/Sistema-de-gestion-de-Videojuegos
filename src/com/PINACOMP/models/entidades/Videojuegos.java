package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;

import java.time.LocalDate;

public class Videojuegos {
    protected String titulo;
    protected double precio;
    protected Sistema plataforma;
    protected TipoClasificacion clasificacion;
    protected TipoGenero genero;
    protected LocalDate anioLanzamiento;
    protected String desarrolladora;
    protected int noJugadores;

    public Videojuegos(String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores) {
        this.titulo = titulo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.anioLanzamiento = anioLanzamiento;
        this.desarrolladora = desarrolladora;
        this.noJugadores = noJugadores;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public Sistema getPlataforma() {
        return plataforma;
    }

    public TipoClasificacion getClasificacion() {
        return clasificacion;
    }

    public TipoGenero getGenero() {
        return genero;
    }

    public LocalDate getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public int getNoJugadores() {
        return noJugadores;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("El titulo del videojuego es: ").append(titulo);
        sb.append(" \nSu precio es: ").append(precio);
        sb.append(" \nTiene una clasificación: ").append(clasificacion);
        sb.append(" \nSu genero es: ").append(genero);
        sb.append(" \nSu año de lanzamiento es: ").append(anioLanzamiento);
        sb.append(" \nSu desarrolladora es: ").append(desarrolladora);
        sb.append(" \nEl numero de jugadores es: ").append(noJugadores);
        sb.append(" \nInformacion de la consola:\n ").append(plataforma);
        return sb.toString();
    }
}
