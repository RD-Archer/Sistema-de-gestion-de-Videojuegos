package com.PINACOMP.app;

import static com.PINACOMP.models.interfaces.ServiciosUsuarios.interfazUsuario;
import static com.PINACOMP.models.interfaces.ServiciosUsuarios.lectura;


public class InterfazAdministrador {

    public static void menu(){

        System.out.println("Que desea hacer?");
        System.out.println("1) Modificar Inventario de videojuegos");
        System.out.println("2) Modificar Empleados");
        System.out.println("3) Registros");
        System.out.println("4) Salir");

    }

    public static void InterfazAdmi(byte Valor) {

        switch (Valor) {
            case 1:


                break;

            case 2:
                interfazUsuario();


                break;

            case 3:
                System.out.println("Funcion no implementada");

                break;

            default:
                System.out.println("Valor no valido. Intente de nuevo.");
                break;
        }



    }

    public static void main(String[] args) {

        System.out.println("Bienvenido. desea continuar?");
        String confirmacion;
        byte valor=0;
        do {
            confirmacion =lectura.next();
            if (confirmacion.equalsIgnoreCase("si")||confirmacion.equalsIgnoreCase("yes")) {
                menu();
                valor=lectura.nextByte();
                lectura.nextLine();
                InterfazAdmi(valor);

            }


        } while (!(confirmacion.equalsIgnoreCase("no")||confirmacion.equalsIgnoreCase("4")));
        System.out.println("Adios. Hasta pronto.");







    }




}