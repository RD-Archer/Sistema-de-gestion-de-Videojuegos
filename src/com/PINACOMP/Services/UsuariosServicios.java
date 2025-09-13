package com.PINACOMP.Services;

import java.util.Scanner;

import com.PINACOMP.Data.UsuariosData;
import com.PINACOMP.Data.UsuariosData.ClienteData;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.List;


public class UsuariosServicios {
    static Scanner lectura=new Scanner(System.in);
    static UsuariosData datosUsuario=new UsuariosData();
    static UsuariosData.ClienteData datosCliente=datosUsuario.new ClienteData();

    public static void InicioDeSecion(){
        String correo=null;
        String contraseña = null;
        String confirmacion;
        System.out.println("Desea continuar con esta accion?");
        do {
            confirmacion=lectura.next();
            if (confirmacion.equalsIgnoreCase("si")||confirmacion.equalsIgnoreCase("yes")){
                System.out.println("Bienvenido. ");
                System.out.println("Ingreses su correo: ");
                correo=lectura.next();
                System.out.println("Ingrese su contraseña: ");
                contraseña=lectura.next();
                Usuario.BuscarUsuario(correo,contraseña);


            }




        }while (!(confirmacion.equalsIgnoreCase("no")));



    }
    //Nuevo Registro de clientes
    public static void registro(){
        String respuesta;
        System.out.println("Desea continuar con su registro? (Si/No)");

        do {
            respuesta=lectura.next();
            if (respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("yes")) {
                System.out.println("Bienvenido. Ingrese los siguentes datos");
                System.out.print("Ingrese su Nombre: ");
                String nombre=lectura.nextLine();

                System.out.print("Ingrese su Apellido paterno: ");
                String apellido1=lectura.nextLine();

                System.out.print("Ingrese su apelludi materno: ");
                String apellido2=lectura.nextLine();

                System.out.println("Ingrese su edad: ");
                byte edad=lectura.nextByte();
                lectura.nextLine();

                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Ingrese su direccion: ");
                String direccion=lectura.nextLine();

                System.out.print("Ingrese su direccion de correo: ");
                String correo=lectura.nextLine();

                System.out.print("Ingrese su contraseña");
                String contraseña=lectura.next();

                System.out.print("vuelva a ingresar su contraseña: ");
                boolean validacion=false;
                do{

                    String Contraseña=lectura.next();
                    if (Contraseña.equals(contraseña)) {
                        validacion=true;
                        break;

                    }
                    else{
                        System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
                    }

                } while (!validacion);
                TipoUsuario tipo=TipoUsuario.CLIENTE;

                Usuario nuevoCliente=new Usuario(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo);
                datosCliente.getClientes().add(nuevoCliente);

                //Usuario nuevoUsuario=new Usuario(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo);


                System.out.println("Desea registrarse? (Si/No)");
            }



        } while (!(respuesta.equalsIgnoreCase("no")));



    }
    //nuevo--------------------------------------------------------------------- registro empleados
    public static void registroEmpleados(){
        String respuesta;
        System.out.println("Desea continuar con su registro? (Si/No)");

        do {
            respuesta=lectura.next();
            if (respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("yes")) {
                System.out.println("Bienvenido. Ingrese los siguentes datos");
                System.out.print("Ingrese su Nombre: ");
                lectura.nextLine();
                String nombre=lectura.nextLine();

                System.out.print("Ingrese su Apellido paterno: ");
                String apellido1=lectura.nextLine();

                System.out.print("Ingrese su apelludi materno: ");
                String apellido2=lectura.nextLine();

                System.out.println("Ingrese su edad: ");
                byte edad=lectura.nextByte();
                lectura.nextLine();

                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Ingrese su direccion: ");
                String direccion=lectura.nextLine();

                System.out.print("Ingrese su direccion de correo: ");
                String correo=lectura.nextLine();

                System.out.print("Ingrese su contraseña: ");
                String contraseña=lectura.next();

                System.out.print("vuelva a ingresar su contraseña: ");
                boolean validacion=false;
                do{

                    String Contraseña=lectura.next();
                    if (Contraseña.equals(contraseña)) {
                        validacion=true;
                        break;

                    }
                    else{
                        System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
                    }

                } while (!validacion);
                TipoUsuario tipo=TipoUsuario.EMPLEADO;


                Usuario nuevoUsuario=new Usuario(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo);
                datosUsuario.getUsuarios().add(nuevoUsuario);

                System.out.println("Desea registrarse? de nuevo (Si/No)");
            }



        } while (!(respuesta.equalsIgnoreCase("no")));



    }
    //Nuevo buscar por nombre
    public static Usuario BusquedaPorNombre(){
        String nombre;
        String apellido1;
        String apellido2;

        System.out.println("Ingrese los siguentes datos:");
        System.out.print("Nombre(s): ");
        nombre=lectura.nextLine();
        System.out.print("Apellido paterno: ");
        apellido1=lectura.nextLine();
        System.out.print("Apellido materno: ");
        apellido2=lectura.nextLine();
        for(Usuario u:datosUsuario.getUsuarios()){
            if(u.getNombre().equalsIgnoreCase(nombre)&&u.getApellidoPaterno().equalsIgnoreCase(apellido1)&&u.getApellidoMaterno().equalsIgnoreCase(apellido2)){
                return u;
            }

        }
        System.out.println("Empleado no encontrado.");
        return null;

    }
    //Nuevo Buscar por correo
    public static Usuario buscarEmpleadoPorCorreo() {
        System.out.print("Ingrese el correo: ");
        String correo = lectura.nextLine();
        for (Usuario u : datosUsuario.getUsuarios()) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                System.out.println("Empleado encontrado: " + u);
                return u;
            }
        }
        System.out.println("Empleado no encontrado.");
        return null;
    }




    public static void buscarEmpleados(){
        byte valor=0;

        System.out.println("Seleccione su metodo de busqueda");
        System.out.println("1) Buscar por nombre: ");
        System.out.println("2) Buscar por correo");
        valor=lectura.nextByte();
        lectura.nextLine();
        switch (valor) {
            case 1:

                break;
            case 2:

                break;
            default:
                break;
        }
        System.out.println("Funcion no Terminada");
    }

    //Nuevo------------------------------------------------------------
    public static void ModificarRegistrosEmpleados(){
        System.out.println("Como desea realizar primero");
        System.out.println("1) Buscar empleado.");
        System.out.println("2) Eliminar empleado.");
        System.out.println("3) Salir.");
        System.out.println("Funcion no Terminada");



    }
    //nuevo---------------------------------------------------------------------
    public static void eliminarEmpleados(){

        System.out.println("Funcion no implementada");
    }





}
