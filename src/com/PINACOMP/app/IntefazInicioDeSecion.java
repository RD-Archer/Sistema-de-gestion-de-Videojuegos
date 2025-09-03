package com.PINACOMP.app;

import com.PINACOMP.models.entidades.Usuario;

import java.util.Scanner;

import static com.PINACOMP.models.interfaces.ServiciosUsuarios.InicioDeSecion;


public class IntefazInicioDeSecion {
    static Scanner lectura=new Scanner(System.in);




    public static void filtro(int valor){
        System.out.println("ha");
        switch (valor){

            case 1:
                InicioDeSecion();
            break;

            case 2:

                break;
            case 3:

                break;

            default:
                System.out.println("Valor no valido. Intente de nuevo.");



        }

    }

    public static void interfaz(){
        int valor=0;
        System.out.println("Que desea hacer?");
        System.out.println("1) Iniciar session");
        System.out.println("2) Registrarse");
        System.out.println("3) Salir.");
        valor=lectura.nextInt();
        filtro(valor);
    }


    public static void main(String[] args) {

        String confirmacion;

        System.out.println("Bienvenido");
        System.out.println("Desea Continuar? ");

        do {
            confirmacion=lectura.next();
            if(confirmacion.equalsIgnoreCase("Si")){
                interfaz();




            }



        }while (!(confirmacion.equalsIgnoreCase("No")));

    }
}
