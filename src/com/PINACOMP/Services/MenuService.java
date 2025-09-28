package com.PINACOMP.Services;

import com.PINACOMP.models.entidades.Compra;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoGenero;

import java.util.List;
import java.util.Scanner;

public class MenuService {
    //Creando nuestro objeto de la clase Videojuegos servicios para utilizar metodos
    static VideojuegoServicios operacionesVideojuegos = new VideojuegoServicios();
    static EmpleadoService operacionesEmpleados = new EmpleadoService();
    //Pasamos los elementos de la lista videojuegos  a nuestra tienda
    static List<Videojuegos> tienda = operacionesVideojuegos.obtenerVideojuegos();
    static Compra c1 = new Compra();
    public void menuCliente() {
        System.out.println("-----Bienvenido------");
        System.out.println();
        System.out.println("¿Qué deseas realizar?");
        System.out.println(" 1 - Mostrar todos los videojuegos");
        System.out.println(" 2 - Buscar un videojuego");
        System.out.println(" 3 - Probar un videojuego");
        System.out.println(" 4 - Comprar un videjuego");
        System.out.println(" 0 - Salir del sistema");
    }

    public void menuEmpleado() {
        System.out.println("-----Bienvenido a nuestro Sistema de gestion de Videojuegos------");
        System.out.println();
        System.out.println("¿Qué deseas realizar?");
        System.out.println(" 1 - Mostrar todos los videojuegos");
        System.out.println(" 2 - Agregar un videojuego");
        System.out.println(" 3 - Eliminar un videojuego");
        System.out.println(" 4 - Actualizar un videojuego");
        System.out.println(" 0 - Salir del sistema");
    }

    public void menuAdministrador() {
        System.out.println("-----Bienvenido a nuestro Sistema de gestion de usuarios------");
        System.out.println();
        System.out.println("¿Qué deseas realizar?");
        System.out.println(" 1 - Mostrar todos los empleados");
        System.out.println(" 2 - Agregar un empleado");
        System.out.println(" 3 - Eliminar un empleado");
        System.out.println(" 4 - Actualizar un empleado");
        System.out.println(" 0 - Salir del sistema");
    }

    public void opcionMenuCliente(int opcion, Scanner lectura) {
        if (opcion < 0 || opcion > 4) {
            System.out.println("Tu opcion esta fuera de rango");
        } else {
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema ...");
                    break;
                case 1:
                    operacionesVideojuegos.mostrarVideojuegos(tienda);
                    break;
                case 2:
                    System.out.println("Buscando videojuego");
                    break;
                case 3:
                    probarVideojuego(lectura);
                    break;
                case 4:
                    Scanner scannerCompra = lectura;
                    c1.realizarCompra(tienda,20, scannerCompra);
                    break;

            }
        }
    }

    public void accionesEmpleado(int opcion, Scanner scanner){
        switch (opcion){
            case 1:
                operacionesEmpleados.mostrarVideojuegos(tienda);
                break;
            case 2:
                operacionesEmpleados.agregarVideojuegos(scanner);
                break;
        }
    }

    private void probarVideojuego(Scanner scanner) {
        System.out.println("Qué tipo de categoria deseas probar");
        System.out.println("1 - SIMULACION");
        System.out.println("2 - MMORPG");
        System.out.println("3 - ROL");
        System.out.println("4 - BATLEROYALE");

        int opcionCategoria = scanner.nextInt();
        int opcionV;
        int contador = 0;

        switch (opcionCategoria) {
            case 1:
                System.out.println("Elige un videojuego para probar:");
                for (int i = 0; i < tienda.size(); i++) {
                    if (tienda.get(i).getGenero() == TipoGenero.SIMULACION) {
                        contador++;
                        System.out.println(contador + ". " + tienda.get(i).getTitulo());
                    }
                }
                if (contador == 0) {
                    System.out.println("No hay videojuegos de SIMULACION");
                } else {
                    opcionV = scanner.nextInt();
                    if (opcionV > 0 && opcionV <= contador) {
                        // Recorremos de nuevo para obtener el juego correcto
                        contador = 0;
                        for (int i = 0; i < tienda.size(); i++) {
                            if (tienda.get(i).getGenero() == TipoGenero.SIMULACION) {
                                contador++;
                                if (contador == opcionV) {
                                    tienda.get(i).probarVideojuego();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción inválida");
                    }
                }
                break;

            case 2:
                System.out.println("Elige un videojuego para probar:");
                contador = 0;
                for (int i = 0; i < tienda.size(); i++) {
                    if (tienda.get(i).getGenero() == TipoGenero.MMORPG) {
                        contador++;
                        System.out.println(contador + ". " + tienda.get(i).getTitulo());
                    }
                }
                if (contador == 0) {
                    System.out.println("No hay videojuegos de MMORPG");
                } else {
                    opcionV = scanner.nextInt();
                    if (opcionV > 0 && opcionV <= contador) {
                        contador = 0;
                        for (int i = 0; i < tienda.size(); i++) {
                            if (tienda.get(i).getGenero() == TipoGenero.MMORPG) {
                                contador++;
                                if (contador == opcionV) {
                                    tienda.get(i).probarVideojuego();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción inválida");
                    }
                }
                break;

            case 3:
                System.out.println("Elige un videojuego para probar:");
                contador = 0;
                for (int i = 0; i < tienda.size(); i++) {
                    if (tienda.get(i).getGenero() == TipoGenero.RPG) {
                        contador++;
                        System.out.println(contador + ". " + tienda.get(i).getTitulo());
                    }
                }
                if (contador == 0) {
                    System.out.println("No hay videojuegos de ROL");
                } else {
                    opcionV = scanner.nextInt();
                    if (opcionV > 0 && opcionV <= contador) {
                        contador = 0;
                        for (int i = 0; i < tienda.size(); i++) {
                            if (tienda.get(i).getGenero() == TipoGenero.RPG) {
                                contador++;
                                if (contador == opcionV) {
                                    tienda.get(i).probarVideojuego();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción inválida");
                    }
                }
                break;

            case 4:
                System.out.println("Elige un videojuego para probar:");
                contador = 0;
                for (int i = 0; i < tienda.size(); i++) {
                    if (tienda.get(i).getGenero() == TipoGenero.BATTLEROYALE) {
                        contador++;
                        System.out.println(contador + ". " + tienda.get(i).getTitulo());
                    }
                }
                if (contador == 0) {
                    System.out.println("No hay videojuegos de BATLEROYALE");
                } else {
                    opcionV = scanner.nextInt();
                    if (opcionV > 0 && opcionV <= contador) {
                        contador = 0;
                        for (int i = 0; i < tienda.size(); i++) {
                            if (tienda.get(i).getGenero() == TipoGenero.BATTLEROYALE) {
                                contador++;
                                if (contador == opcionV) {
                                    tienda.get(i).probarVideojuego();
                                    break;
                                }
                            }
                        }
                    } else {
                        System.out.println("Opción inválida");
                    }
                }
                break;

            default:
                System.out.println("No está esa opción");
        }
    }
}

