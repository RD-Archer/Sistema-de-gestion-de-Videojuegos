package com.PINACOMP.Services;

import com.PINACOMP.Excepciones.TituloInvalidoException;
import com.PINACOMP.models.entidades.Cliente;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoCompra;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoPago;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.PINACOMP.Services.JuegosServiciosRegistro.validarTitulo;
import static com.PINACOMP.Services.VideojuegoServicios.busquedaVideoJuegos;
import static com.PINACOMP.Services.lectura.entradaValoresSafe;
import static com.PINACOMP.Services.lectura.validarRango;
import static com.PINACOMP.app.mainEstatico.entradaValoresDecimal;

public class MenuService {
    //Creando nuestro objeto de la clase Videojuegos servicios para utilizar metodos
    static VideojuegoServicios operacionesVideojuegos = new VideojuegoServicios();
    static EmpleadoService operacionesEmpleados = new EmpleadoService();
    static VentaService operacionesVenta = new VentaService();
    //Pasamos los elementos de la lista videojuegos  a nuestra tienda
    static List<Videojuegos> tienda = operacionesVideojuegos.obtenerVideojuegos();
    static Cliente clienteActual = new Cliente();
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
    public void iniciarPrograma(){

    }

    public void menuAdministrador() {
        System.out.println("-----Bienvenido a nuestro Sistema de gestion de usuarios------");
        System.out.println();
        System.out.println("¿Qué deseas realizar?");
        System.out.println(" 1 - Mostrar todos los empleados");
        System.out.println(" 2 - Agregar un empleado");
        System.out.println(" 3 - Eliminar un empleado");
        System.out.println(" 4 - Actualizar un empleado");
        System.out.println(" 5 - Mostrar Informaes");
        System.out.println(" 0 - Salir del sistema");
    }
    public void menuBusqueda(){
        System.out.println("Como deseas buscar el videojuego");
        System.out.println("1-Titulo \n" +
                            "2-Precio \n" +
                            "3-Rango de precio \n" +
                            "4-Sistema \n" +
                            "5-Genero");
    }

    public void accionesAdmin(int opcion){
        switch (opcion) {
            case 0:
                System.out.println("Saliendo del sistema");
                break;
            case 1:
                AdminService.mostrarEmpleados();
                break;
            case 2:
                AdminService.registroEmpleados();
                break;
            case 3:
                AdminService.eliminarEmpleados();
                break;
            case 4:
                AdminService.actualizarEmpleados();
            default:
                System.out.println("Opcion no valida");
                break;
        }

    }

    public void opcionMenuCliente(Usuario usuario, int opcion, Scanner lectura) {
        String titulo;
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo del sistema ...");
                    break;
                case 1:
                    operacionesVideojuegos.mostrarVideojuegos(tienda);
                    break;
                case 2:
                    menuBusqueda();
                    int opcionBusqueda = validarRango(1,5);
                    busquedaVideoJuegos(opcionBusqueda,tienda,operacionesVideojuegos);
                    break;
                case 3:
                    probarVideojuego(lectura);
                    break;
                case 4:
                    System.out.println("Bienvenido a nuestro sistema de venta");
                    /*System.out.println("Dame tu nombre");
                    String nombreCli= lectura.nextLine();
                    System.out.println("Dame tu correo");
                    String correoCli= lectura.nextLine();
                    System.out.println("Dame tu domicilio");
                    String domicilioCli= lectura.nextLine();*/
                    System.out.println("Elige el tipo de pago");

                    for(TipoPago pago : TipoPago.values()){
                        System.out.println(pago.ordinal()+" - ");
                    }
                    int opcionPago = entradaValoresSafe();
                    TipoPago tipoSeleccionado = TipoPago.values()[opcionPago];
                    System.out.println("Elige el tipo de compra");
                    for(TipoCompra compra : TipoCompra.values()){
                        System.out.println(compra.ordinal()+" - ");
                    }
                    int opcionCompra = entradaValoresSafe();
                    TipoCompra tipoSeleccionado2 = TipoCompra.values()[opcionCompra];
                    clienteActual = new Cliente(usuario,tipoSeleccionado,tipoSeleccionado2);
                    System.out.println("Estos son los videojuegos disponibles");
                    //Mostrar al usuario el catalogo
                    operacionesVideojuegos.mostrarVideojuegos(tienda);
                    titulo=null;
                    while(true){
                        try{
                            System.out.println("Ingresa el titulo del videojuego a comprar");
                            titulo=lectura.nextLine();
                            TituloInvalidoException.validar(titulo);
                            break;
                        }catch (TituloInvalidoException e){
                            System.out.println(e.getMessage());
                        }
                    }
                    operacionesVenta.venderPorTitulo(tienda,titulo,clienteActual);



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

