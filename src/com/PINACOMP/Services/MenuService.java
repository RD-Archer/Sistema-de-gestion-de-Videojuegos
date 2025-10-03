package com.PINACOMP.Services;

import com.PINACOMP.models.entidades.Compra;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;

import java.util.ArrayList;
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
    public void accionesAdmin(int opcion, Scanner lectura){

        switch (opcion) {
            case 1:
                UsuariosServicios.registroEmpleados();
                break;
            case 2:
                UsuariosServicios.ModificarRegistrosEmpleados();

                break;
            case 3:
                UsuariosServicios.eliminarEmpleados();
                break;
            case 4:
                //confirmacion=false;
                System.out.println("Saliendo del sistema");
                break;

            default:
                System.out.println("Opcion no valida");
                break;
        }

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
                    System.out.println("Como deseas buscar el videojuego");
                    System.out.println("1-Titulo \n2-Precio \n3-Rango de precio \n4-Sistema \n5-Genero");
                    try{
                    int opcionBusqueda = lectura.nextInt();
                    lectura.nextLine();

                        if(opcionBusqueda==1){
                            System.out.println("Dame el titulo de tu videojuego: ");
                            String titulo = lectura.nextLine();
                            boolean videojuegoEnLista= false;
                            for (Videojuegos videojuego: tienda ){
                                List<Videojuegos> encontrados = videojuego.buscarTitulo(titulo);
                                if(!encontrados.isEmpty()){
                                    operacionesVideojuegos.mostrarVideojuegos(encontrados);
                                    videojuegoEnLista=true;
                                }
                            }
                            if(!videojuegoEnLista){
                                System.out.println("No tenemos aun ese título en nuestro catalogo de videojuegos");
                            }
                        }
                        if (opcionBusqueda==2){
                            System.out.println("Dame el precio del videojuego");
                            double precio= lectura.nextDouble();
                            boolean videojuegoEnLista = false;
                            for(Videojuegos videojuegos: tienda){
                                List<Videojuegos> encontrados= videojuegos.buscarPrecio(precio);
                                if(!encontrados.isEmpty()){
                                    operacionesVideojuegos.mostrarVideojuegos(encontrados);
                                    videojuegoEnLista=true;
                                }
                            }
                            if(!videojuegoEnLista){
                                System.out.println("No tenemos videojuegos con ese precio en nuestro catalogo.");
                            }

                        }
                        if(opcionBusqueda==3){
                            System.out.println("Dame tu precio minimo");
                            double precioMin=lectura.nextDouble();
                            System.out.println("Dame tu precio Maximo");
                            double precioMax=lectura.nextDouble();
                            boolean encontrado=false;
                            List<Videojuegos> encontrados= new ArrayList<>();
                            for(Videojuegos videojuego : tienda){
                                encontrados=videojuego.buscarPorRangoPrecio(precioMin,precioMax);
                                if(!encontrados.isEmpty()){
                                    operacionesVideojuegos.mostrarVideojuegos(encontrados);
                                    encontrado=true;
                                }
                            }
                            if(!encontrado){
                                System.out.println("No tenemos ningún videojuego en ese rango de precio en nuestro catalogo.");
                            }
                        }
                        if(opcionBusqueda==4){
                            System.out.println("Estos son nuestros sistemas");
                            TipoConsola[] consolas = TipoConsola.values();
                            for (int i=0; i< consolas.length; i++){
                                System.out.println(consolas[i]);
                            }
                            System.out.println("Escribe el sistema que deseas ver sus videojuegos");
                            String sistema= lectura.nextLine();
                            TipoConsola sistemaElegido = TipoConsola.valueOf(sistema.toUpperCase());
                            boolean encontrado=false;
                            List<Videojuegos> encontrados = new ArrayList<>();
                            for(Videojuegos videojuego : tienda){
                                encontrados=videojuego.buscarPorPlataforma(sistemaElegido);
                                if(!encontrados.isEmpty()){
                                    operacionesVideojuegos.mostrarVideojuegos(encontrados);
                                    encontrado=true;
                                }
                            }
                            if(!encontrado){
                                System.out.println("No tenemos ningún videojuego para ese sistema en nuestro catalogo.");
                            }

                        }
                        if (opcionBusqueda==5){
                            System.out.println("Estos son nuestros géneros en Videojuegos");
                            TipoGenero[] generos  = TipoGenero.values();
                            for (int i=0; i< generos.length; i++){
                                System.out.println(generos[i]);
                            }
                            System.out.println("Escribe el Género que deseas ver sus videojuegos");
                            String genero= lectura.nextLine();
                            TipoGenero generoElegido = TipoGenero.valueOf(genero.toUpperCase());
                            boolean encontrado=false;
                            List<Videojuegos> encontrados = new ArrayList<>();
                            for(Videojuegos videojuego : tienda){
                                encontrados=videojuego.buscarPorGenero(generoElegido);
                                if(!encontrados.isEmpty()){
                                    operacionesVideojuegos.mostrarVideojuegos(encontrados);
                                    encontrado=true;
                                }
                            }
                            if(!encontrado){
                                System.out.println("No tenemos ningún videojuego para ese sistema en nuestro catalogo.");
                            }
                        }
                    }catch (java.util.InputMismatchException e){
                        System.out.println("Error. debes ingresar un número");
                        lectura.nextLine();
                    }
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
            case 3:
                operacionesEmpleados.eliminarVideojuego(scanner);
                break;
            case 4:
                operacionesEmpleados.actualizarVideojuego(scanner);
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

