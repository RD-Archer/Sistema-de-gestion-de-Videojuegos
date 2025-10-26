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
    protected TipoUsuario rol;


    public Usuario(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, String correo, String contraseña, TipoUsuario rol) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio);
        this.correo = correo;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    //Gets --------------------------------------
    public String getContraseña() {
        return contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public TipoUsuario getTipoUsuario() {
        return rol;

    }
    //Sets ----------------------------------------
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
 @Override
    public String toString(){
     return "Nombre: "+ apellidoPaterno+" "+apellidoMaterno+" "+nombre+"\n"+"Edad: "+edad+"\n"+"Genero: "+genero+"\n"+"Domicilio: "+domicilio;
 }






}

