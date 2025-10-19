package com.PINACOMP.Services;

import java.util.Scanner;
import java.util.List;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;
import com.PINACOMP.Excepciones.NombreApellidosInvalidosException;
import com.PINACOMP.Excepciones.SueldoInvalidoException;
import com.PINACOMP.models.entidades.Cliente;
import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

public class UsuariosServicios {
    static Scanner lectura=new Scanner(System.in);
    static EmpleadosData datosEmpleados=new EmpleadosData();
    static ClienteData datosClientes=new ClienteData();

    public static void mostrarEmpleados(){

        for (Empleado empleado:datosEmpleados.getEmpleados()){

                System.out.println("Nombre: " + empleado.getNombreCompleto()
                        + "\n" + "Edad: " + empleado.getEdad()
                        + "\n" + "Genero: " + empleado.getGenero()
                        + "\n" + "Direccion: " + empleado.getDomicilio()
                        + "\n" + "Correo: " + empleado.getCorreo()
                        + "\n" + "Contraseña: " + "No disponible"
                        + "\n" + "Tipo: " + empleado.getTipoUsuario()
                        + "\n" + "Numero de empleado: " + empleado.getNumEmpleado()
                        + "\n" + "Sueldo: " + empleado.getSueldoSemanal()
                        + "\n" + "Puesto: " + empleado.getPuesto()
                        + "\n" + "Nombre de usuario: " + empleado.getNombreUsuario()
                        + "\n" + "Estado del empleado: " + empleado.getEstado());
            System.out.println();
        }
    }
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

    //Nuevo Registro de clientes
    public static void registro(){
        String respuesta;
        System.out.println("Desea continuar con su registro? (Si/No)");

        do {
            respuesta=lectura.next();
            lectura.nextLine();
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
                TipoUsuario tipo=TipoUsuario.CLIENTE;

                Usuario nuevoCliente=new Usuario(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo);
                datosClientes.getClientes().add(nuevoCliente);
                System.out.println("Registro exitoso.");

            }

        } while (!(respuesta.equalsIgnoreCase("no")));

    }
    //nuevo--------------------------------------------------------------------- registro empleados a modificar
    public static void registroEmpleados(){
        String respuesta;
        System.out.println("Desea continuar con su registro? (Si/No)");
        do {
            String entradaGlobal;
            respuesta=lectura.next();
            if (respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("yes")) {
                System.out.println("Bienvenido. Ingrese los siguentes datos");
                String nombre= null;
                lectura.nextLine();
                while(true){
                    try {
                        System.out.print("Ingrese su Nombre: ");
                        entradaGlobal=lectura.nextLine();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        nombre=entradaGlobal;
                        break;

                    }catch (NombreApellidosInvalidosException e){
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("Ingrese su Apellido paterno: ");
                String apellido1=lectura.nextLine();

                System.out.print("Ingrese su apelludo materno: ");
                String apellido2=lectura.nextLine();

                int entradaNum=lectura.nextInt();
                while (entradaNum<18){
                    System.out.println("Error  de edad Ingrese su edad: ");

                }
                /*
                if(entradaNum<18){
                    System.out.println("No puedes contratar a un menor de edad");
                    break;
                }
                if(entradaNum==0){
                    System.out.println("La edad no puede ser cero");
                    break;
                }
                if(entradaNum<0){
                    System.out.println("No puedees tener edades negativas");
                    break;
                }
*/

                byte edad=lectura.nextByte();

                lectura.nextLine();

                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Ingrese su direccion: ");
                String direccion=lectura.nextLine();

                System.out.print("Ingrese su direccion de correo: ");
                String correo=lectura.nextLine();

                System.out.print("Ingrese su contraseña:  minimo 8 caracteres" );
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

                List<Empleado> empleados=datosEmpleados.getEmpleados();
                int nuevoId=1;
                if (!empleados.isEmpty()){
                    Empleado ultimo=empleados.get(empleados.size()-1);
                    nuevoId=ultimo.getNumEmpleado()+1;
                }
                lectura.nextLine();
                double sueldo = 0;
                while(true) {
                    try {
                        System.out.print("Indique el sueldo semanal: ");
                        entradaGlobal = lectura.nextLine();
                        double entradaDouble = Double.parseDouble(entradaGlobal);
                        SueldoInvalidoException.validarSueldo(entradaDouble);
                        sueldo = entradaDouble;
                        break;

                    } catch (SueldoInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("Seleccione el puesto (GERENTE/PRODUCTMANAGER/ADMIN/VENDEDOR/ANALISTA): ");
                TipoPuesto puesto = TipoPuesto.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Nombre de usuario interno: ");
                String nombreUsuario = lectura.nextLine();

                System.out.println("Indique el estado del empleado: (ACTIVO/PENDIENTE/BAJA)");
                TipoEstado estado=TipoEstado.valueOf(lectura.nextLine().toUpperCase());

                Empleado nuevoEmpleado =new Empleado(nombre, apellido1, apellido2, edad, genero, direccion, correo, contraseña, tipo,nuevoId,sueldo,puesto,nombreUsuario,estado);
                datosEmpleados.getEmpleados().add(nuevoEmpleado);

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
        for(Usuario u:datosEmpleados.getEmpleados()){
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
        for (Usuario u : datosEmpleados.getEmpleados()) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                System.out.println("Empleado encontrado: " + u);
                return u;
            }
        }
        System.out.println("Empleado no encontrado.");
        return null;
    }

    //Nuevo------------------------------------------------------------
    public static void actualizarEmpleados(){

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
        System.out.println("Empleado encontrado: " + empleado.getNombreCompleto());

        boolean continuar=true;
        while (continuar){
            System.out.println("Que desea modificar: ");
            System.out.println("1) Direccion.");
            System.out.println("2) Correo.");
            System.out.println("3) Sueldo semanal.");
            System.out.println("4) Puesto.");
            System.out.println("5) contraseña.");
            System.out.println("6) Estado.");
            System.out.println("7) Salir.");

            byte campo=lectura.nextByte();
            lectura.nextLine();
            switch (campo){
                case 1:
                    System.out.print("Ingrese su nueva direccion: ");
                    empleado.setDomicilio(lecturaTexto());
                    break;
                case 2:
                    System.out.print("Ingrese su nuevo correo: ");
                    empleado.setCorreo(lecturaTexto());
                    break;
                case 3:
                    System.out.print("Ingrese el nuevo sueldo semanal: ");
                    empleado.setSueldoSemanal(lectura.nextByte());
                    lectura.nextLine();
                    break;
                case 4:
                    System.out.print("Ingrese el nuevo puesto a ocupar (GERENTE/PRODUCTMANAGER/ADMIN/VENDEDOR/ANALISTA): ");
                    empleado.setPuesto(TipoPuesto.valueOf(lecturaTexto().toUpperCase()));
                    break;
                case 5:
                    System.out.print("Ingrese la nueva contraseña: ");
                    empleado.setContraseña(lecturaTexto());
                    break;
                case 6:
                    System.out.println("Ingrese el estado del empleado(ACTIVO/PENDIENTE/BAJA): ");
                    empleado.setEstado(TipoEstado.valueOf(lecturaTexto().toUpperCase()));
                    break;
                case 7:
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
                    datosEmpleados.getEmpleados().remove(empleado);
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
    public static String lecturaTexto(){
        String texto;
        texto=lectura.nextLine();
        return texto;
    }


}
