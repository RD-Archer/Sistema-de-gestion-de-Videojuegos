package com.PINACOMP.Services;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;
import com.PINACOMP.models.entidades.Usuario;

import static com.PINACOMP.Services.ServiciosRegistros.solicitarCorreoValido;
import static com.PINACOMP.Services.ServiciosRegistros.solicitarNombreValido;

public class ServiciosBusqueda {
    static EmpleadosData datosEmpleados=new EmpleadosData();
    static ClienteData datosClientes=new ClienteData();

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
}
