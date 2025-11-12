package com.PINACOMP.models.entidades;

import com.PINACOMP.Data.VentasData;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Informe {

    private LocalDate fecha;
    private int idUsuario;
    private int totalVentas;
    private double ganancias;
    public Sistema plataforma;

    public Informe(LocalDate fecha, int idUsuario, Sistema plataforma) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.plataforma = plataforma;
        generarDatos();
    }

    public Informe(LocalDate fecha, int idUsuario, int totalVentas, double ganancias, Sistema plataforma) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.totalVentas = totalVentas;
        this.ganancias = ganancias;
        this.plataforma = plataforma;
    }


    private void generarDatos(){
        List<Compra> ventas = VentasData.obtenerVentas();
        List<Compra> ventasFiltradas = new ArrayList<>();

        for(Compra venta : ventas){
            if(plataforma== null || venta.getVideojuego().getPlataforma().equals(plataforma)){
                ventasFiltradas.add(venta);
            }
        }
        totalVentas= ventasFiltradas.size();
        ganancias=0;

        for(Compra venta : ventasFiltradas){
            double subtotal = venta.getVideojuego().getPrecio();
            ganancias+=subtotal;
        }
    }

    @Override
    public String toString() {
        return "Informe{" +
                "fecha=" + fecha +
                ", idUsuario=" + idUsuario +
                ", totalVentas=" + totalVentas +
                ", plataforma=" + (plataforma != null ? plataforma: "Todas") +
                ", ganancias=" + ganancias +
                '}';
    }
    public List<Videojuegos> videojuegos(){

    return videojuegos();
    }
}
