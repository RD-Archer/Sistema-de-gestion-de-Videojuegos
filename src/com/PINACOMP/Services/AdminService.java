package com.PINACOMP.Services;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Data.EmpleadosData;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;

import static com.PINACOMP.Excepciones.TextoInvalidoException.normalizar;
import static com.PINACOMP.Services.ServiciosRegistros.*;
import static com.PINACOMP.Services.ServiciosRegistros.solicitarNumeroValido;
import static com.PINACOMP.Services.lectura.entradaValoresTexto;

public class AdminService {
    static EmpleadosData datosEmpleados=new EmpleadosData();
    static ClienteData datosClientes=new ClienteData();
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

                Usuario cliente=new Usuario(normalizar(nombre),normalizar(apellidoP),normalizar(apellidoM),edad,genero,pais,codigoPostal,direccion,correo,contraseña,numero, TipoUsuario.CLIENTE);
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
}
