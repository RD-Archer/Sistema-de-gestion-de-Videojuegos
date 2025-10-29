package com.PINACOMP.Services;

import java.text.Normalizer;
import java.util.Scanner;
import java.util.List;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;
import com.PINACOMP.Excepciones.*;
import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

import static com.PINACOMP.Services.ServiciosRegistros.*;
import static com.PINACOMP.Services.lectura.*;


public class UsuariosServicios {
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
    //nuevo
    public static void registroClientes(){
        String respuesta;
        System.out.println("Desea continuar con su registro? (Si/No)");
        do {
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

                Usuario cliente=new Usuario(nombre,apellidoM,apellidoP,edad,genero,pais,codigoPostal,direccion,correo,contraseña,numero,TipoUsuario.CLIENTE);
                datosClientes.agregarClientes(cliente);
                System.out.println("Registro exitoso. ");
                break;
            }
        }while (!respuesta.equalsIgnoreCase("no"));
    }
    //Nuevo
    public static void registroEmpleados() {
        String respuesta;
        System.out.println("Desea continuar el registro? (Si/No)");
        do {
            respuesta=entradaValoresTexto();
            if (respuesta.equalsIgnoreCase("si")){
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
                TipoUsuario tipoUsuario=TipoUsuario.EMPLEADO;
                List<Empleado> empleados=datosEmpleados.getEmpleados();
                int nuevoId=1;
                if (!empleados.isEmpty()){
                    Empleado ultimo=empleados.get(empleados.size()-1);
                    nuevoId=ultimo.getNumEmpleado()+1;
                }
                double sueldo=solicitarSueldoValido();
                TipoPuesto puesto=solicitarPuestoValido();
                String apodo=solicitarApodoValido();
                TipoEstado estado=solicitarEstadoValido();

                Empleado empleado=new Empleado(nombre,apellidoP,apellidoM,edad,genero,pais,codigoPostal,direccion,correo,contraseña,numero,tipoUsuario,nuevoId,sueldo,puesto,apodo,estado);
                datosEmpleados.agregarEmpleados(empleado);
                System.out.println("Registro exitoso. ");
                System.out.println("Desea registrar otro empleado? (Si/No)");
            }
        }while (!respuesta.equalsIgnoreCase("no"));

    }

    //Nuevo Registro de clientes
    /*public static void registroClientes(){
        String respuesta,entradaGlobal;
        String nombre,apellidoP,apellidoM;
        int entradaNumerica,edad;
        String correo, contraseña;
        System.out.println("Desea continuar con su registro? (Si/No)");
        do {
            respuesta=entradaValoresTexto();
            if (respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("yes")) {
                System.out.println("Bienvenido. Ingrese los siguentes datos");
                while (true) {
                    try {
                        System.out.print("Ingrese su Nombre: ");
                        entradaGlobal = entradaValoresTexto();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        nombre = entradaGlobal;
                        break;
                    } catch (NombreApellidosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                }
                while (true) {
                    try {
                        System.out.print("Ingrese su apellido paterno: ");
                        entradaGlobal = entradaValoresTexto();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        apellidoP = entradaGlobal;
                        break;
                    } catch (NombreApellidosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }

                }
                while (true) {
                    try {
                        System.out.print("Ingrese su apellido materno: ");
                        entradaGlobal = entradaValoresTexto();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        apellidoM = entradaGlobal;
                        break;
                    } catch (NombreApellidosInvalidosException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("Ingrese su edad: ");
                        entradaNumerica = entradaValoresSafe();
                        EdadInvalidadException.validarEdad(entradaNumerica);
                        edad = entradaNumerica;
                        break;
                    } catch (EdadInvalidadException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Ingrese su dirección postal: ");
                String direccion = lectura.nextLine();

                while (true) {
                    try {
                        System.out.print("Ingrese su dirección de correo: ");
                        entradaGlobal = entradaValoresTexto();
                        CorreoInvalidoException.validarCorreo(entradaGlobal);
                        correo = entradaGlobal;
                        break;
                    } catch (CorreoInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                }

                while (true) {
                    try {
                        System.out.println("Ingrese su contraseña(La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.)");
                        entradaGlobal = entradaValoresTexto();
                        ContraseñaInvalidaException.validarContraseña(entradaGlobal);
                        contraseña = entradaGlobal;
                        break;
                    } catch (ContraseñaInvalidaException e) {
                        System.out.println(e.getMessage());
                    }
                }

                System.out.print("vuelva a ingresar su contraseña: ");
                while (true) {
                    String Contraseña = lectura.next();
                    if (Contraseña.equals(contraseña)) {
                        lectura.nextLine();
                        break;
                    } else {
                        System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
                    }
                }
                TipoUsuario tipo = TipoUsuario.CLIENTE;

                Usuario nuevoCliente=new Usuario(nombre, apellidoP, apellidoM, edad, genero, direccion, correo, contraseña, tipo);
                datosClientes.agregarClientes(nuevoCliente);
                System.out.println("Registro exitoso.");
                mostrarClientes();
                break;
            }

        } while (!(respuesta.equalsIgnoreCase("no")));
    }*/
    //nuevo--------------------------------------------------------------------- registro empleados a modificar
    /*public static void registroEmpleados(){
        String respuesta,entradaGlobal;
        String nombre,apellidoP,apellidoM;
        int entradaNumerica,edad;
        double sueldo;
        String correo, contraseña;

        System.out.println("Desea continuar el registro? (Si/No)");
        do {
            respuesta=lectura.next();
            if (respuesta.equalsIgnoreCase("si")||respuesta.equalsIgnoreCase("yes")) {
                System.out.println("Bienvenido. Ingrese los siguentes datos");
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
                while (true){
                    try {
                        System.out.print("Ingrese su apellido paterno: ");
                        entradaGlobal=entradaValoresTexto();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        apellidoP=entradaGlobal;
                        break;
                    }catch (NombreApellidosInvalidosException e){
                        System.out.println(e.getMessage());
                    }
                }

                while (true){
                    try{
                        System.out.print("Ingrese su apellido materno: ");
                        entradaGlobal=entradaValoresTexto();
                        NombreApellidosInvalidosException.validarNombreApellido(entradaGlobal);
                        apellidoM=entradaGlobal;
                        break;
                    }catch (NombreApellidosInvalidosException e){
                        System.out.println(e.getMessage());
                    }
                }

                while (true){
                    try {
                        System.out.print("Ingrese su edad: ");
                        entradaNumerica = entradaValoresSafe();
                        EdadInvalidadException.validarEdad(entradaNumerica);
                        edad=entradaNumerica;
                        break;
                    }
                    catch (EdadInvalidadException e){
                        System.out.println("Error: "+e.getMessage());
                    }
                }
                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(lectura.nextLine().toUpperCase());

                System.out.print("Ingrese su direccion: ");
                String direccion=lectura.nextLine();
                while (true){
                    try {
                        System.out.print("Ingrese su direccion de correo: ");
                        entradaGlobal=entradaValoresTexto();
                        CorreoInvalidoException.validarCorreo(entradaGlobal);
                        correo=entradaGlobal;
                        break;
                    }catch (CorreoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                while (true){
                    try {
                        System.out.println("Ingrese su contraseña(La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.)");
                        entradaGlobal=entradaValoresTexto();
                        ContraseñaInvalidaException.validarContraseña(entradaGlobal);
                        contraseña=entradaGlobal;
                        break;
                    }catch (ContraseñaInvalidaException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.print("vuelva a ingresar su contraseña: ");
                while (true){
                    String Contraseña=lectura.next();
                    if (Contraseña.equals(contraseña)) {
                        lectura.nextLine();
                        break;
                    }
                    else{
                        System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
                    }
                }
                TipoUsuario tipo=TipoUsuario.EMPLEADO;
                List<Empleado> empleados=datosEmpleados.getEmpleados();
                int nuevoId=1;
                if (!empleados.isEmpty()){
                    Empleado ultimo=empleados.get(empleados.size()-1);
                    nuevoId=ultimo.getNumEmpleado()+1;
                }
                while(true) {
                    try {
                        System.out.print("Indique el sueldo semanal: ");
                        double entradaNumericaDouble=entradaValoresSafeDouble();
                        SueldoInvalidoException.validarSueldo(entradaNumerica);
                        sueldo = entradaNumericaDouble;
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

                Empleado nuevoEmpleado =new Empleado(nombre, apellidoP, apellidoM, edad, genero, direccion, correo, contraseña, tipo,nuevoId,sueldo,puesto,nombreUsuario,estado);
                datosEmpleados.agregarEmpleados(nuevoEmpleado);
                break;
            }
        } while (!(respuesta.equalsIgnoreCase("no")));

    }*/
    //Nuevo buscar por nombre
    public static Usuario BusquedaPorNombre(){
        System.out.println("Ingrese los siguentes datos:");
        String nombre=solicitarNombreValido("nombre");
        String apellidoP=solicitarNombreValido("apellido paterno");
        String apellidoM=solicitarNombreValido("apellido materno");
            for(Usuario u:datosEmpleados.getEmpleados()){
                if(u.getNombre().equalsIgnoreCase(nombre)&&u.getApellidoPaterno().equalsIgnoreCase(apellidoP)&&u.getApellidoMaterno().equalsIgnoreCase(apellidoM)){
                    return u;
                }
            }
            return null;
    }
    //Nuevo Buscar por correo
    public static Usuario buscarEmpleadoPorCorreo() {
        String correo=solicitarCorreoValido();
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
        boolean continuar=false;
        Empleado empleado = null;
        System.out.println("Como desea realizar primero");
        System.out.println("1) Buscar por nombre.");
        System.out.println("2) Buscar por correo.");
        System.out.println("3) Salir.");

       int opcion=validarRango(1,3);
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
        }

        if (empleado == null) {
            System.out.println("No se encontró el empleado. No se puede continuar con la modificación.");
            return;
        }
        else {
            System.out.println("Empleado encontrado: " + empleado.getNombreCompleto());
            continuar=true;
        }

        while (continuar){
            System.out.println("Que desea modificar: ");
            System.out.println("1) Direccion.");
            System.out.println("2) Correo.");
            System.out.println("3) Sueldo semanal.");
            System.out.println("4) Puesto.");
            System.out.println("5) Contraseña.");
            System.out.println("6) Numero");
            System.out.println("7) Estado.");
            System.out.println("8) Salir.");

            int campo=validarRango(1,8);
            switch (campo){
                case 1:
                    System.out.println("Cambio de direccion: ");
                    empleado.setPais(solicitarPaisValido());
                    empleado.setCodigoPostal(solicitarCodigoPostal());
                    empleado.setDomicilio(solicitarDireccionPostal());
                    break;
                case 2:
                    System.out.println("Nuevo correo: ");
                    empleado.setCorreo(solicitarCorreoValido());
                    break;
                case 3:
                    System.out.println("Nuevo sueldo semanal: ");
                    empleado.setSueldoSemanal(solicitarSueldoValido());

                    break;
                case 4:
                    System.out.println("Nuevo puesto: ");
                    empleado.setPuesto(solicitarPuestoValido());
                    break;
                case 5:
                    System.out.println("Nueva contraseña: ");
                    empleado.setContraseña(solicitarContraseñaValida());
                    break;
                case 6:
                    System.out.println("Cambio de numero: ");
                   empleado.setNumero(solicitarNumeroValido());
                    break;
                case 7:
                    System.out.println("Cambio de estado: ");
                    empleado.setEstado(solicitarEstadoValido());
                    break;
                case 8:
                    continuar = false;
                    break;
            }
            if (continuar){
                System.out.println("Desea modificar otro campo (Si/No) ");
                String respuesta=entradaValoresTexto();
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
        Empleado empleado=null;

        while (repetir) {
            System.out.println("ELIMINAR EMPLEADO");
            System.out.println("Seleccione el método de búsqueda:");
            System.out.println("1) Buscar por nombre");
            System.out.println("2) Buscar por correo");
            System.out.println("3) Salir");
            int opcion = validarRango(1, 3);


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
                    System.out.println("Saliendo....");
                    return;
            }
            if (empleado == null) {
                System.out.println("empleado no encontrado. ¿Desea intentar de nuevo? (Si/No)");
                String respuesta = entradaValoresTexto();
                if (respuesta.equalsIgnoreCase("No")) {
                    repetir = false;
                }
            } else {
                System.out.println("Empleado encontrado: " + empleado.getNombre());
                System.out.println("Estas seguro que deseas eliminarlo? (Si/No)");
                String confirmacion = entradaValoresTexto();
                if (confirmacion.equalsIgnoreCase("Si")) {
                    datosEmpleados.getEmpleados().remove(empleado);
                    System.out.println("Empleado terminado");
                } else {
                    System.out.println("Operacion cancelada ");
                    break;
                }
                System.out.println("¿Desea eliminar otro empleado? (Si/No)");
                String otra = entradaValoresTexto();
                repetir = otra.equalsIgnoreCase("si");
            }
        }
        System.out.println("Adios hasta pronto");
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
