package com.PINACOMP.models.interfaces;

import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;

import java.util.List;

public interface BusquedaVideojuego {

    //Metodo que busca por id
    List<Videojuegos> buscarId(int id);
    //Método que busca por titulo
    List<Videojuegos> buscarTitulo(String titulo);
    //Método que busca por precio
    List<Videojuegos> buscarPrecio(double precio);

    //Metodo que busca por rango de precio
    List<Videojuegos> buscarPorRangoPrecio(double preciomin ,double precioMax);

    //Método que busca por plataforma
    List<Videojuegos> buscarPorPlataforma(TipoConsola consola);

    //Método que busca por genero
    List<Videojuegos> buscarPorGenero(TipoGenero genero);


}
