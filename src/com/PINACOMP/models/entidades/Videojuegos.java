package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.interfaces.BusquedaVideojuego;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public  class Videojuegos  implements BusquedaVideojuego {
    protected int id;
    protected String titulo;
    protected double precio;
    protected Sistema plataforma;
    protected TipoClasificacion clasificacion;
    protected TipoGenero genero;
    protected LocalDate anioLanzamiento;
    protected String desarrolladora;
    protected int noJugadores;

    public Videojuegos(int id, String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.plataforma = plataforma;
        this.clasificacion = clasificacion;
        this.genero = genero;
        this.anioLanzamiento = anioLanzamiento;
        this.desarrolladora = desarrolladora;
        this.noJugadores = noJugadores;
    }

    public int getId() {
        return id;
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

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPlataforma(Sistema plataforma) {
        this.plataforma = plataforma;
    }

    public void setClasificacion(TipoClasificacion clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setGenero(TipoGenero genero) {
        this.genero = genero;
    }

    public void setAnioLanzamiento(LocalDate anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public void setNoJugadores(int noJugadores) {
        this.noJugadores = noJugadores;
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
    public void probarVideojuego() {
        System.out.println("Este juego no tiene demo disponible.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("El id del videojuego es: ").append(id);
        sb.append(" \nEl titulo del videojuego es: ").append(titulo);
        sb.append(" \nSu precio es: ").append(precio);
        sb.append(" \nTiene una clasificación: ").append(clasificacion);
        sb.append(" \nSu genero es: ").append(genero);
        sb.append(" \nSu año de lanzamiento es: ").append(anioLanzamiento);
        sb.append(" \nSu desarrolladora es: ").append(desarrolladora);
        sb.append(" \nEl numero de jugadores es: ").append(noJugadores);
        sb.append(" \nInformacion de la consola:\n ").append(plataforma);
        return sb.toString();
    }


    @Override
    public List<Videojuegos> buscarId(int id) {
        List<Videojuegos> resultado = new ArrayList<>();
        if(this.id==id){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Videojuegos> buscarTitulo(String titulo) {
        List<Videojuegos> encontrado = new ArrayList<>();
        if(this.titulo.equalsIgnoreCase(titulo)){
            encontrado.add(this);
        }
        return encontrado;
    }

    @Override
    public List<Videojuegos> buscarPrecio(double precio) {
        List<Videojuegos> resultado = new ArrayList<>();
        if (this.precio==precio){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Videojuegos> buscarPorRangoPrecio(double preciomin, double precioMax) {
        List<Videojuegos> resultado = new ArrayList<>();
        if(this.precio>=preciomin && this.precio<=precioMax){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Videojuegos> buscarPorPlataforma(TipoConsola consola) {
        List<Videojuegos> resultado = new ArrayList<>();
        if(this.plataforma.getConsola()==consola){
            resultado.add(this);
        }
        return resultado;
    }

    @Override
    public List<Videojuegos> buscarPorGenero(TipoGenero genero) {
        List<Videojuegos> resultado = new ArrayList<>();
        if(this.genero==genero){
            resultado.add(this);
        }
        return resultado;
    }
}
