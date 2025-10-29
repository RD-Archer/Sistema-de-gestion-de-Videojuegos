package com.PINACOMP.Services;


import com.PINACOMP.Excepciones.RangoInvalidoException;

import java.util.Scanner;

public class lectura {
    static Scanner lectura=new Scanner(System.in);

    public static int entradaValoresSafe(){
        while (true){
            String entrada=lectura.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            }catch (NumberFormatException e){
                System.out.println("Error: debes de ingresar un numero.");
            }
        }
    }
    public static double entradaValoresSafeDouble(){
        while (true){
            String entrada=lectura.nextLine().trim();
            try {
                return Double.parseDouble(entrada);
            }catch (NumberFormatException e){
                System.out.println("Error: debes de ingresar un numero.");
            }
        }
    }

    public static String entradaValoresTexto(){
        String cadena;
        cadena=lectura.nextLine();
        return cadena;
    }
    public static int validarRango(int rangoI,int rangoF){
        while (true){
            try {
                int opcion=entradaValoresSafe();
                RangoInvalidoException.validarRango(opcion, rangoI, rangoF);
                return opcion;
            }catch (RangoInvalidoException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }
    public static String limpieza(){
        return lectura.nextLine();
    }

}
