package com.PINACOMP.models.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Compra {

    public List<Videojuegos> carritoVideojuegos;
    public int IdVentas;
    private Cliente cliente;
    public Date fechaCompra;
    public int descuento;
    public Compra() {
        this.carritoVideojuegos = new ArrayList<>();
        this.fechaCompra = new Date();
        this.descuento = 0;
    }
    public Compra(List<Videojuegos> carritoVideojuegos, int idVentas, Cliente cliente, Date fechaCompra, int descuento) {
        this.carritoVideojuegos = carritoVideojuegos;
        IdVentas = idVentas;
        this.cliente = cliente;
        this.fechaCompra = fechaCompra;
        this.descuento = descuento;
    }
    public double AplicarDescuento(double precio){


    return descuento;
    }
    public void realizarCompra(List<Videojuegos> videojuegos, int descuento, Scanner scanner){
        boolean seguirComprndo= true;
        while(seguirComprndo){
            scanner.nextLine();
            System.out.println("Escribe el titulo del videojuego que deseas comprar");
            String tituloVideojuego= scanner.nextLine();
            Videojuegos juegoEncontrado = null;
            for(Videojuegos v : videojuegos){
                if (v.getTitulo().equalsIgnoreCase(tituloVideojuego)){
                    juegoEncontrado=v;
                    break;
                }
            }
            if(juegoEncontrado!=null){
                carritoVideojuegos.add(juegoEncontrado);
                System.out.println(juegoEncontrado.getTitulo());
            }else{
                System.out.println("No se encontro ese videojuego");
            }
            System.out.println("¿Deseas comprar otro videojuego? (S/N)");
            String respuesta= scanner.nextLine();
            if(!respuesta.equalsIgnoreCase("s")){
                seguirComprndo=false;
            }
        }
        System.out.println("Compra finalizada");
        System.out.println("Total: $"+calcularTotal());
    }
    public double calcularTotal(){
        double total=0;
        for(Videojuegos v: carritoVideojuegos){
            total+=v.getPrecio();

        }
        return total;
    }
}
