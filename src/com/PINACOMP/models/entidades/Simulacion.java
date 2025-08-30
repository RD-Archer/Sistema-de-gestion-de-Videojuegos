package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoSimulacion;
import com.PINACOMP.models.interfaces.ServicioVideojuegos;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Simulacion  extends Videojuegos implements ServicioVideojuegos{
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
    public void probarVideojuego() {
        int dia;
        System.out.println("PROBANDO VIDEOJUEGO DE SIMULACION");
        Scanner lectura = new Scanner(System.in);
        System.out.println("Selecciona el dia que deseas probarlo");
        System.out.println("1-LUNES   2-MARTES   3-MIERCOLES   4-JUEVES   5-VIERNES   6-SABADO   7-DOMINGO");
        dia=lectura.nextInt();
        System.out.println("Su información es la siguiente");
        System.out.println(this.ciudad + this.simulacion + this.getTitulo());
        seleccionDia(dia);
    }

    public void seleccionDia(int dia){
        switch (dia){
            case 1:

                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Lunes");
                break;
            case 2:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Martes");
                break;
            case 3:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Miercoles");
                break;
            case 4:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Jueves");
                break;
            case 5:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Viernes");
                break;
            case 6:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Sabado");
                break;
            case 7:
                System.out.println("Seleccionaste el dia: " + dia+ " que equivale a Domingo");
                break;
            default:
                System.out.println("Saliste del rango de dias");
                break;

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLa ciudad es: ").append(ciudad);
        sb.append("\nJuego de  ").append(simulacion);
        return super.toString() + sb.toString();
    }
}
