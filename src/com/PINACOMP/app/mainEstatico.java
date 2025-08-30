package com.PINACOMP.app;
import com.PINACOMP.Data.Videogames;
import com.PINACOMP.models.entidades.Simulacion;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoGenero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mainEstatico {
    private static Scanner lectura = new Scanner(System.in);
    private static List<Videojuegos> tienda = new ArrayList<>();
    public static void main(String[] args) {
        Videogames data = new Videogames();
        tienda=data.getTienda();
        int opcion;
        do{
            mostrarMenu();
            opcion=entradaValores();
            seleccionarOpcion(opcion);

        }while (opcion!= 0);
    }
    public static void mostrarMenu(){
        System.out.println("BIENVENIDO A NUESTRO SISTEMA DE VIDEOJUEGOS");
        System.out.println("¿Qué deseas realizar");
        System.out.println(" 1 - Mostrar todos los videojuegos");
        System.out.println(" 2 - Buscar un videojuego");
        System.out.println(" 3 - Probar un videojuego");
        System.out.println(" 4 - Probar un videjuego");
        System.out.println(" 0 - Salir del sistema");

    }
    public static int entradaValores(){
        int opcion;
        System.out.println("Digita el numero de la opcion que te interesa realizar");
        opcion=lectura.nextInt();
        return opcion;
    }
    public  static void seleccionarOpcion(int opcion){
        if (opcion <0 || opcion>4){
            System.out.println("Tu opcion esta fuera de rango");
        }else{
            switch (opcion){
                case 0:
                    System.out.println("Saliendo del sistema ...");
                    break;
                case 1:
                    mostrarVideojuegos(tienda);
                    break;
                case 2:
                    System.out.println("Buscando videojuego");
                    break;
                case 3:
                    Scanner lecturaOpcion = new Scanner(System.in);
                    int opcionCategoria, opcionV;
                    System.out.println("Qué tipo de categoria deseas probar");
                    System.out.println("1 - SIMULACION");
                    System.out.println("2 - MMORPG");
                    System.out.println("3 - ROL");
                    System.out.println("4 - BATLEROYALE");
                    opcionCategoria= lecturaOpcion.nextInt();
                    switch (opcionCategoria){
                        case 1:
                            System.out.println("Elige un videojuego para probar");
                            int contador=0;
                            for (int i=0; i<tienda.size(); i++){
                                if (tienda.get(i).getGenero()== TipoGenero.SIMULACION){
                                    System.out.println((i+1) +". "+tienda.get(i).getTitulo());
                                    contador++;

                                }
                            }
                            if (contador==0){
                                System.out.println("No hay videojuegos que simular");
                            }else{
                                opcionV=lecturaOpcion.nextInt();
                                if (opcionV > 0 && opcionV <= tienda.size()){
                                    Videojuegos juego = tienda.get(opcionV -1);
                                    juego.probarVideojuego();
                                }
                            }


                    }

                    break;
                default:
                    System.out.println("No esta esa opcion");
            }
        }
    }
    private static void mostrarVideojuegos(List<Videojuegos> resultados){
        int contador;
        if(resultados.isEmpty()){
            System.out.println("No tengo aun videojuegos");
        }else{
            System.out.println("TENGO "+ resultados.size()+ " VIDEJUEGOS ACTUALMENTE");
            contador=1;
            for (Videojuegos videojuego : resultados){
                System.out.println("INFORMACION VIDEOJUEGO " + contador + ":");
                System.out.println(videojuego);
                System.out.println();
                contador++;
            }
        }
    }
}
