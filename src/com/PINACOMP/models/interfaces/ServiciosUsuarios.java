package com.PINACOMP.models.interfaces;

import java.util.Scanner;

import com.PINACOMP.Services.UsuariosServicios;


//Nuevo
public interface ServiciosUsuarios {
    Scanner lectura=new Scanner(System.in);

    public static void interfazUsuario(){
        byte valor=0;
        String confirmacio=null;
        System.out.println("Que desea hacer?");
        System.out.println("1) Agregar un nuevo Empleado.");
        System.out.println("2) Modificar un empleado.");
        System.out.println("3) Eliminar un empleado");
        System.out.println("4) Salir");
        do {
            valor=lectura.nextByte();
            lectura.nextLine();


            switch (valor) {
                case 1:
                    UsuariosServicios.registroEmpleados();
                    break;
                case 2:
                    UsuariosServicios.ModificarRegistrosEmpleados();

                    break;
                case 3:
                    System.out.println("Funcion no implementada");


                    break;
                default:

                    break;
            }




        } while (!(confirmacio.equalsIgnoreCase("no")||(valor==4)));





    }




}
