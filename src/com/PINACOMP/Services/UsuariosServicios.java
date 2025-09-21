package com.PINACOMP.Services;

import java.util.Scanner;
import java.util.List;

import com.PINACOMP.Data.UsuariosData;

import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Persona;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

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

                System.out.println("Desea registrarse? (Si/No)");
            }

        } while (!(respuesta.equalsIgnoreCase("no")));

    }
    //nuevo--------------------------------------------------------------------- registro empleados a modificar
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

                System.out.print("Ingrese su apelludo materno: ");
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

                List<Empleado> empleados=datosUsuario.getEmpleados();
                int nuevoId=1;
                if (!empleados.isEmpty()){
                    Empleado ultimo=empleados.get(empleados.size()-1);
                    nuevoId=ultimo.getNumEmpleado()+1;
                }

                System.out.print("Indique el sueldo semanal: ");
                int sueldo=lectura.nextInt();
                lectura.nextLine();
                System.out.print("Seleccione el puesto (GERENTE/PRODUCTMANAGER/ADMIN/VENDEDOR/ANALISTA): ");
                TipoPuesto puesto = TipoPuesto.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Nombre de usuario interno: ");
                String nombreUsuario = lectura.nextLine();

                Empleado nuevoEmpleado =new Empleado(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo,nuevoId,sueldo,puesto,nombreUsuario);
                datosUsuario.getEmpleados().add(nuevoEmpleado);

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
        for(Usuario u:datosUsuario.getEmpleados()){
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
        for (Usuario u : datosUsuario.getEmpleados()) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                System.out.println("Empleado encontrado: " + u);
                return u;
            }
        }
        System.out.println("Empleado no encontrado.");
        return null;
    }
    //--------------------------------------------------------------------------------------//
    public static void buscarEmpleados(Persona persona){
        byte valor=0;
        persona.toString();

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

        int opcion = lectura.nextInt();
        lectura.nextLine();

        Empleado empleado = null;

        switch (opcion) {
            case 1:
                empleado = (Empleado) BusquedaPorNombre();
                break;
            case 2:
                empleado = (Empleado) buscarEmpleadoPorCorreo();
                break;
            case 3:
                System.out.println("Saliendo del módulo de modificación.");
                return;
            default:
                System.out.println("Opción inválida.");
                return;
        }
        System.out.println("Empleado encontrado: " + empleado.getNombre() + " " + empleado.getApellidoPaterno()+" "+empleado.getApellidoMaterno());

        boolean continuar=true;
        while (continuar){
            System.out.println("Que desea modificar: ");
            System.out.println("1) Direccion.");
            System.out.println("2) Correo.");
            System.out.println("3) Sueldo semanal.");
            System.out.println("4) Puesto.");
            System.out.println("5) contraseña.");
            //System.out.println("6) pendiente.");
            System.out.println("6) Salir.");

            byte campo=lectura.nextByte();
            lectura.nextLine();
            switch (campo){
                case 1:
                    System.out.print("Ingrese su nueva direccion: ");
                    empleado.setDomicilio(lectura.nextLine());
                    break;
                case 2:
                    System.out.print("Ingrese su nuevo correo: ");
                    empleado.setCorreo(lectura.nextLine());
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo sueldo semanal: ");
                    empleado.setSueldoSemanal(lectura.nextByte());
                    lectura.nextLine();
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo puesto a ocupar (GERENTE/PRODUCTMANAGER/ADMIN/VENDEDOR/ANALISTA): ");
                    empleado.setPuesto(TipoPuesto.valueOf(lectura.nextLine().toUpperCase()));
                    break;
                case 5:
                    System.out.print("Ingrese la nueva contraseña: ");
                    empleado.setContraseña(lectura.nextLine());
                    break;
                case 6:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
            if (continuar){
                System.out.println("Desea modificar otro campo (Si/No) ");
                String respuesta=lectura.next();
                lectura.nextLine();
                if (respuesta.equalsIgnoreCase("no")){
                    continuar=false;
                }

            }

        }
        System.out.println("Modificaciones completadas.");

    }
    //nuevo---------------------------------------------------------------------
    public static void eliminarEmpleados(){
        boolean repetir = true;

        while (repetir) {
            System.out.println("ELIMINAR EMPLEADO");
            System.out.println("Seleccione el método de búsqueda:");
            System.out.println("1) Buscar por nombre");
            System.out.println("2) Buscar por correo");
            System.out.println("3) Salir");
            int opcion = lectura.nextInt();
            lectura.nextLine();

            Empleado empleado=null;

            switch (opcion) {
                case 1:
                    Usuario resultado1 = BusquedaPorNombre();
                    if (resultado1 instanceof Empleado) {
                        empleado = (Empleado) resultado1;
                    }
                    break;
                case 2:
                    Usuario resultado2 = buscarEmpleadoPorCorreo();
                    if (resultado2 instanceof Empleado) {
                        empleado = (Empleado) resultado2;
                    }
                    break;
                case 3:
                    repetir = false;
                    continue;
                default:
                    System.out.println("Opcion no valida");
                continue;

            }

            if (empleado==null){
                System.out.println("empleado no encontrado. ¿Desea intentar de nuevo? (Si/No)");
                String respuesta=lectura.next();
                lectura.nextLine();
                if (respuesta.equalsIgnoreCase("No")){
                    repetir=false;
                }

            }else {
                System.out.println("Empleado encontrado: "+empleado.getNombre());
                System.out.println("Estas seguro que deseas eliminarlo? (Si/No)");
                String confirmacion=lectura.next();
                lectura.nextLine();
                if(confirmacion.equalsIgnoreCase("Si")){
                    datosUsuario.getEmpleados().remove(empleado);
                    System.out.println("Empleado terminado");
                }
                else {
                    System.out.println("Operacion cancelada ");
                }
                System.out.println("¿Desea eliminar otro empleado? (Si/No)");
                String otra = lectura.nextLine();
                repetir = otra.equalsIgnoreCase("si");
            }

        }

        System.out.println("Adios hasta pronto");
    }


}
