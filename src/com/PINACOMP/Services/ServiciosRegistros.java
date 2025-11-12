package com.PINACOMP.Services;

import com.PINACOMP.Data.ClienteData;
import com.PINACOMP.Excepciones.*;
import com.PINACOMP.models.entidades.Cliente;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.SortedMap;

import static com.PINACOMP.Services.lectura.*;

public class ServiciosRegistros {

    //validar
    public static String solicitarNombreValido(String campo){
        while (true){
            try {
                System.out.print("Ingrese su "+campo+": ");
                String nombre=entradaValoresTexto();
                NombreApellidosInvalidosException.validarNombreApellido(nombre);
                return nombre;
            }catch (NombreApellidosInvalidosException e){
                System.out.println(e.getMessage());
            }
        }
    }

    //validar edad para todo tipos de usuario
    public static int solicitarEdadValida() {
        while (true) {
            try {
                System.out.print("Ingrese su edad: ");
                int edad = entradaValoresSafe();
                EdadInvalidadException.validarEdad(edad);
                return edad;
            } catch (EdadInvalidadException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static String solicitarPaisValido(){
        while (true){
            try {
                System.out.print("Ingrese su pais: ");
                String pais=entradaValoresTexto();
                DireccionInvalidaException.validarPais(pais);
                return pais;
            }catch (DireccionInvalidaException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static int solicitarCodigoPostal(){
        while (true){
            try{
                System.out.print("Ingrese su codigo postal: ");
                int codigoPostal=entradaValoresSafe();
                DireccionInvalidaException.validarCodigoPostal(codigoPostal);
                return codigoPostal;

            }catch (DireccionInvalidaException e){
                System.out.println(e.getMessage());

            }
        }

    };
    public static String solicitarDireccionPostal(){
        while (true){
            try{
                System.out.print("Ingresa tu dirección postal: ");
                String direccion=entradaValoresTexto();
                DireccionInvalidaException.validarDireccionPostal(direccion);
                return direccion;

            }catch (DireccionInvalidaException e){
                System.out.println(e.getMessage());
            }
        }

    }
    //Validar correo para todo tipos de usuarios
    public static String solicitarCorreoValido(){
        while (true){
            try{
                System.out.print("Ingrese su dirección de correo: ");
                String correo=entradaValoresTexto();
                CorreoInvalidoException.validarCorreo(correo);
                return correo;
            }catch (CorreoInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    //Validar contraseña para todo tipos de usuarios
    public static String solicitarContraseñaValida(){
        while (true){
            try {
                System.out.print("Ingrese su contraseña(La contraseña debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y símbolos.): ");
                String contraseña=entradaValoresTexto();
                ContraseñaInvalidaException.validarContraseña(contraseña);
                return contraseña;
            }catch (ContraseñaInvalidaException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static void solicitarConfirmacionContraseñaValida(String original){
        while (true){
            System.out.print("Vuelva a ingresar su contraseña: ");
            String confimacion=entradaValoresTexto();
            if (confimacion.equals(original)){
                break;
            }else {
                System.out.println("Las contraseñas no coinciden. Intente de nuevo.");
            }
        }

    }
    public static Genero solicitarGeneroValido(){
        while (true){
            try {
                System.out.print("Ingrese su género (MASCULINO/FEMENINO/BINARIO/OTROS): ");
                Genero genero = Genero.valueOf(entradaValoresTexto().toUpperCase());
                return genero;
            }catch (IllegalArgumentException e){
                System.out.println("Error: Los datos ingresados no son validos");
            }

        }
    }
    public static String solicitarNumeroValido(){
        while (true){
            try {
                System.out.print("Ingrese su numero: ");
                String numero=entradaValoresTexto();
                NumeroInvalidoException.validarTelefono(numero);
                return numero;
            }catch (NumeroInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }
    public static double solicitarSueldoValido(){
        while(true) {
            try {
                System.out.print("Indique el sueldo semanal: ");
                double sueldo=entradaValoresSafeDouble();
                SueldoInvalidoException.validarSueldo(sueldo);
                return sueldo;
            } catch (SueldoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static TipoPuesto solicitarPuestoValido(){
        while (true){
            try {
                System.out.print("Seleccione el puesto (GERENTE/PRODUCTMANAGER/ADMIN/VENDEDOR/ANALISTA): ");
                TipoPuesto puesto = TipoPuesto.valueOf(entradaValoresTexto().toUpperCase());
                return puesto;
            }catch (IllegalArgumentException e){
                System.out.println("Error: Los datos ingresados no son validos");
            }

        }

    }
    public static String solicitarApodoValido(){
        while (true) {
            try {
                System.out.print("Ingrese apodo o nombre se usuario interno: ");
                String apodo = entradaValoresTexto();
                return apodo;
            } catch (ApodoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //validar estado
    public static TipoEstado solicitarEstadoValido(){
        while (true){
            try {
                System.out.print("Indique el estado del empleado: (ACTIVO/PENDIENTE/BAJA): ");
                TipoEstado estado=TipoEstado.valueOf(entradaValoresTexto().toUpperCase());
                return estado;
            }catch (IllegalArgumentException e){
                System.out.println("Error: Los datos ingresados no son validos");
            }
        }
    }
    public static Usuario validarCliente(String correo,String contraseña){
        for (Usuario u: ClienteData.getClientes()){
            if (u.getCorreo().equals(correo)&&u.getContraseña().equals(contraseña)&&u.getTipoUsuario().equals(TipoUsuario.CLIENTE)){
                return new Usuario(u.getNombre(),u.getApellidoPaterno(), u.getApellidoMaterno(), u.getPais(),u.getCodigoPostal(),u.getDomicilio(),u.getCorreo());


            }
        }
        return null;
    }

}
