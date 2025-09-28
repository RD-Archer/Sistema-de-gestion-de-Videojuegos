/*package com.PINACOMP.app;

import com.PINACOMP.models.entidades.Usuario;

import java.util.Scanner;

//import static com.PINACOMP.models.interfaces.ServiciosUsuarios.InicioDeSecion;



public class IntefazInicioDeSecion {
    static Scanner lectura=new Scanner(System.in);




    public static void filtro(int valor){
        System.out.println("ha");
        switch (valor){

            case 1:
                InicioDeSecion();
                break;

            case 2:
                //registro();

                break;
            case 3:
                System.out.println("Ok");
                break;

            default:
                System.out.println("Valor no valido. Intente de nuevo.");



        }

    }

    public static void interfaz(){

        System.out.println("Que desea hacer?");
        System.out.println("1) Iniciar session");
        System.out.println("2) Registrarse");
        System.out.println("3) Salir.");

    }

    public static void main(String[] args) {
        int valor=0;
        String confirmacion;

        System.out.println("Bienvenido");
        System.out.println("Desea Continuar? (Si/No)");

        do {
            confirmacion=lectura.next();
            if(confirmacion.equalsIgnoreCase("Si")){
                interfaz();
                valor=lectura.nextInt();
                filtro(valor);

            }

        }while (!(confirmacion.equalsIgnoreCase("No")||valor==3));
        System.out.println("Adios. Hasta pronto.");

    }
}
*/