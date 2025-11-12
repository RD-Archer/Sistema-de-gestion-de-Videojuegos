package com.PINACOMP.Services;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;
import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.List;

import static com.PINACOMP.Excepciones.TextoInvalidoException.normalizar;
import static com.PINACOMP.Services.ServiciosBusquedaUsuarios.BusquedaPorNombre;
import static com.PINACOMP.Services.ServiciosBusquedaUsuarios.buscarEmpleadoPorCorreo;
import static com.PINACOMP.Services.ServiciosRegistros.*;
import static com.PINACOMP.Services.ServiciosRegistros.solicitarNumeroValido;
import static com.PINACOMP.Services.lectura.entradaValoresTexto;
import static com.PINACOMP.Services.lectura.validarRango;

public class AdminService {
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

                Empleado empleado=new Empleado(normalizar(nombre),normalizar(apellidoP),normalizar(apellidoM),edad,genero,pais,codigoPostal,direccion,correo,contraseña,numero,tipoUsuario,nuevoId,sueldo,puesto,apodo,estado);
                datosEmpleados.agregarEmpleados(empleado);
                System.out.println("Registro exitoso. ");
                System.out.println("Desea registrar otro empleado? (Si/No)");
            }
        }while (!respuesta.equalsIgnoreCase("no"));

    }
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
}
