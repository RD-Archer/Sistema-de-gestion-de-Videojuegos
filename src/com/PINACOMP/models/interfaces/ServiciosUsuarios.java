package com.PINACOMP.models.interfaces;

import com.PINACOMP.models.entidades.Usuario;

import java.util.Scanner;

public interface ServiciosUsuarios {
    static Scanner lectura=new Scanner(System.in);
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



}
