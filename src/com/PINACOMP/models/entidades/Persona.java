package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;

public class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int edad;
    protected Genero genero;
    protected String domicilio;

    public Persona(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio){
        this.nombre=nombre;
        this.apellidoPaterno=aPaterno;
        this.apellidoMaterno=aMaterno;
        this.edad=edad;
        this.genero=genero;
        this.domicilio=domicilio;

    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }
    public String getApellidoMaterno(){

        return apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String toString() {
        return "Nombre: "+ apellidoPaterno+" "+apellidoMaterno+" "+nombre+"\n"+"Edad: "+edad+"\n"+"Genero: "+genero+"\n"+"Domicilio: "+domicilio;
    }
}
