package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;

public abstract class Persona {
    protected String nombre;
    protected String apellidoPaterno;
    protected String apellidoMaterno;
    protected int edad;
    protected Genero genero;
    protected String pais;
    protected int codigoPostal;
    protected String domicilio;


    public Persona(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, Genero genero, String pais, int codigoPostal, String domicilio) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.edad = edad;
        this.genero = genero;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
        this.domicilio = domicilio;
    }

    public Persona(){

    }
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno(){return apellidoMaterno;}

    public String getNombreCompleto(){
        return getNombre()+" "+ getApellidoPaterno()+" " + getApellidoMaterno();
    }

    public String getDomicilioCompleto(){
        return "Pais: "+getPais()+"\n"+"Codigo Postal: "+getCodigoPostal()+"\n"+"Domicilio"+getDomicilio();}

    public int getEdad() {
        return edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public int getCodigoPostal(){return codigoPostal;}

    public String getPais(){return pais;}

    public abstract String toString();

    public abstract void setCodigoPostal(int codigoPostal);

    public abstract  void setPais(String pais);

    public abstract void setDomicilio(String direccion);


}
