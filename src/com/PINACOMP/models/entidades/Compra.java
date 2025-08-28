package com.PINACOMP.models.entidades;

import java.util.Date;

public class Compra {

    public Videojuegos videojuegos;
    public int IdVentas;
    private Cliente cliente;
    public Date fechaCompra;
    public int descuento;

    public Compra(Videojuegos videojuegos, int idVentas, Cliente cliente, Date fechaCompra, int descuento) {
        this.videojuegos = videojuegos;
        IdVentas = idVentas;
        this.cliente = cliente;
        this.fechaCompra = fechaCompra;
        this.descuento = descuento;
    }
    public double AplicarDescuento(double precio){


    return descuento;
    }
    public double calcularTotal(){

        return calcularTotal();
    }
}
