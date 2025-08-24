package com.PINACOMP.models.entidades;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class Informe {

    private Date fecha;
    private int idUsuario;
    private int totalVentas;
    private double ganancias;
    public Sistema plataforma;

    public Informe(Date fecha, int idUsuario, int totalVentas, double ganancias, Sistema plataforma) {
        this.fecha = fecha;
        this.idUsuario = idUsuario;
        this.totalVentas = totalVentas;
        this.ganancias = ganancias;
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "fecha=" + fecha +
                ", idUsuario=" + idUsuario +
                ", totalVentas=" + totalVentas +
                ", ganancias=" + ganancias +
                ", plataforma=" + plataforma +
                '}';
    }
    public List<Videojuegos> videojuegos(){

    return videojuegos();
    }
}
