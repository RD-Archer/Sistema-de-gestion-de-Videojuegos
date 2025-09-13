package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoPuesto;

public class Empleado extends Persona {
    private int numEmpleado;
    private double sueldoSemanal;
    private TipoPuesto puesto;
    private String nombreUsuario;
    private String contraseña;

    public Empleado(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, int numEmpleado, double sueldoSemanal, TipoPuesto puesto, String nombreUsuario, String contraseña) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio);
        this.numEmpleado = numEmpleado;
        this.sueldoSemanal = sueldoSemanal;
        this.puesto = puesto;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    public int getNumEmpleado() {
        return numEmpleado;
    }

    public double getSueldoSemanal() {
        return sueldoSemanal;
    }

    public TipoPuesto getPuesto() {
        return puesto;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("El nombre del empleado es: ").append(getNombreCompleto());
        sb.append("\nEl numero de empleado es el siguiente: ").append(getNumEmpleado());
        sb.append("\nSu puesto es: ").append(getPuesto());
        sb.append("\nSu sueldo semanal es: ").append(getSueldoSemanal());
        return sb.toString();
    }
}
