package com.PINACOMP.models.entidades;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;
import com.PINACOMP.Data.EmpleadosData;

public class Usuario extends Persona {

    protected String correo;
    protected String contraseña;
    protected String numero;
    protected TipoUsuario rol;


    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, Genero genero, String pais, int codigoPostal, String domicilio, String correo, String contraseña, String numero, TipoUsuario rol) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, genero, pais, codigoPostal, domicilio);
        this.correo = correo;
        this.contraseña = contraseña;
        this.numero = numero;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, String pais, int codigoPostal, String domicilio, String correo) {
        super(nombre, apellidoPaterno, apellidoMaterno, pais, codigoPostal, domicilio);
        this.correo = correo;
    }

    public Usuario(){}

    //Gets --------------------------------------
    public String getContraseña() {return contraseña;}

    public String getCorreo() {return correo;}

    public String getNumero(){return numero;}

    public TipoUsuario getTipoUsuario() {
        return rol;

    }

    //Sets ----------------------------------------
    public void setCorreo(String correo) {this.correo = correo;}

    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public void setPais(String pais){this.pais=pais;}

    public void setDomicilio(String domicilio){this.domicilio=domicilio;}

    public void setNumero(String numero){this.numero=numero;}
    @Override
    public String toString(){
        return "Nombre: "+ apellidoPaterno+" "+apellidoMaterno+" "+nombre+"\n"+"Edad: "+edad+"\n"+"Genero: "+genero+"\n"+"Direccion: "+getDomicilioCompleto()+"\n"+"Numero"+numero;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal=codigoPostal;

    }



    static EmpleadosData datosEmpleados=new EmpleadosData();
    static ClienteData clienteData= new ClienteData();

    //Inicio de sesion ---------------------------------
    public boolean inicioSesionAdmin(String correoIngresado, String contraseñaIngresada){
        for (Empleado u: datosEmpleados.getEmpleados()){
            if(u.getCorreo().equals(correoIngresado)&&u.getContraseña().equals(contraseñaIngresada)&&u.getTipoUsuario().equals(TipoUsuario.EMPLEADO)&&u.getPuesto().equals(TipoPuesto.ADMIN)&&u.getEstado().equals(TipoEstado.ACTIVO)){
                return true;
            }
        }
        return false;
    }

    public boolean inicioSesionEmpleado(String correoIngresado, String contraseñaIngresada){
        for (Empleado u: datosEmpleados.getEmpleados()){
            if(u.getCorreo().equals(correoIngresado)&&u.getContraseña().equals(contraseñaIngresada)&&u.getTipoUsuario().equals(TipoUsuario.EMPLEADO)&&u.getEstado().equals(TipoEstado.ACTIVO)){
                return true;
            }
        }
        return false;
    }

    public boolean inicioSesionCliente(String correoIngresado, String contraseñaIngresada) {
        for (Usuario u: clienteData.getClientes()){
            if (u.getCorreo().equals(correoIngresado)&&u.getContraseña().equals(contraseñaIngresada)&&u.getTipoUsuario().equals(TipoUsuario.CLIENTE)){
                return true;
            }

        }
        return false;
    }
    //Temporal/opcional


}

