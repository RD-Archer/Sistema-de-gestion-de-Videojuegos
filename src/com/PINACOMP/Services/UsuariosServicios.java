package com.PINACOMP.Services;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.List;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;

import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

import static com.PINACOMP.Excepciones.TextoInvalidoException.normalizar;
import static com.PINACOMP.Services.ServiciosRegistros.*;
import static com.PINACOMP.Services.lectura.*;


public class UsuariosServicios {
    static EmpleadosData datosEmpleados=new EmpleadosData();
    static ClienteData datosClientes=new ClienteData();



    public static void mostrarClientes(){

        for (Usuario usuario: datosClientes.getClientes()){

            System.out.println("Nombre: " + usuario.getNombreCompleto()
                    + "\n" + "Edad: " + usuario.getEdad()
                    + "\n" + "Genero: " + usuario.getGenero()
                    + "\n" + "Direccion: " + usuario.getDomicilio()
                    + "\n" + "Correo: " + usuario.getCorreo()
                    + "\n" + "Contraseña: " + "No disponible"
                    + "\n" + "Tipo: " + usuario.getTipoUsuario());
            System.out.println();
        }
    }
    //nuevo
    public static void registroClientes(){
        String respuesta;
        do {
            System.out.println("Desea continuar con su registro? (Si/No)");
            respuesta=entradaValoresTexto();
            if (respuesta.equalsIgnoreCase("Si")){
                String nombre=solicitarNombreValido("nombre");
                String apellidoP=solicitarNombreValido("apellido paterno");
                String apellidoM=solicitarNombreValido("apellido materno");
                int edad=solicitarEdadValida();
                Genero genero=solicitarGeneroValido();
                String pais=solicitarPaisValido();
                int codigoPostal=solicitarCodigoPostal();
                String direccion=solicitarDireccionPostal();
                String correo=solicitarCorreoValido();
                String contraseña=solicitarContraseñaValida();
                solicitarConfirmacionContraseñaValida(contraseña);
                String numero=solicitarNumeroValido();

                Usuario cliente=new Usuario(normalizar(nombre),normalizar(apellidoP),normalizar(apellidoM),edad,genero,pais,codigoPostal,direccion,correo,contraseña,numero,TipoUsuario.CLIENTE);
                datosClientes.agregarClientes(cliente);
                System.out.println("Registro exitoso. ");
                break;
            }
            else if(respuesta.equalsIgnoreCase("no")){
                System.out.println("Registro cancelado");
            }
            else {
                System.out.println("Respuesta no válida. Por favor escriba 'Si' o 'No'.");
            }

        }while (!respuesta.equalsIgnoreCase("no"));
    }

    public static int validarInicio(String correo, String contraseña){
        //Validacion Admi
            for (Empleado u: datosEmpleados.getEmpleados()){
                if(u.getCorreo().equals(correo)&&u.getContraseña().equals(contraseña)&&u.getTipoUsuario().equals(TipoUsuario.EMPLEADO)&&u.getPuesto().equals(TipoPuesto.ADMIN)&&u.getEstado().equals(TipoEstado.ACTIVO)){
                    return 1;
                }
            }
        //Validacion Empleado
        for (Empleado u: datosEmpleados.getEmpleados()){
            if(u.getCorreo().equals(correo)&&u.getContraseña().equals(contraseña)&&u.getTipoUsuario().equals(TipoUsuario.EMPLEADO)&&u.getEstado().equals(TipoEstado.ACTIVO)){
                return 2;
            }
        }
        //Validacion Clientes
        for (Usuario u: ClienteData.getClientes()){
            if (u.getCorreo().equals(correo)&&u.getContraseña().equals(contraseña)&&u.getTipoUsuario().equals(TipoUsuario.CLIENTE)){
                return 3;
            }
        }
        return  4;
    }
}
