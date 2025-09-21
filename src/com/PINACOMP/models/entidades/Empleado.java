package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

public class Empleado extends Usuario {
    private int numEmpleado;
    private double sueldoSemanal;
    private TipoPuesto puesto;
    private String nombreUsuario;
    //private String estado;

    public Empleado(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, String correo, String contraseña, TipoUsuario rol, int numEmpleado, double sueldoSemanal, TipoPuesto puesto, String nombreUsuario /*,String estado*/) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio, correo, contraseña, rol);
        this.numEmpleado = numEmpleado;
        this.sueldoSemanal = sueldoSemanal;
        this.puesto = puesto;
        this.nombreUsuario = nombreUsuario;
        //this.estado=estado;
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
    public void setDomicilio(String Domicilio){
        super.setDomicilio(domicilio);
    }

    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    public void setContraseña(String contraseña) {
        super.setContraseña(contraseña);
    }

    public void setSueldoSemanal(int sueldoSemanal) {
        this.sueldoSemanal = sueldoSemanal;
    }

    public void setPuesto(TipoPuesto puesto) {
        this.puesto = puesto;
    }

    /*public void setEstado(String estado) {
        this.estado = estado;
    }*/










}
