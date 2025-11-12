package com.PINACOMP.app;


import com.PINACOMP.Excepciones.RangoInvalidoException;
import com.PINACOMP.Services.MenuService;
import com.PINACOMP.Services.UsuariosServicios;
import com.PINACOMP.Services.VideojuegoServicios;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.entidades.Videojuegos;

import java.util.List;
import java.util.Scanner;

import static com.PINACOMP.Services.ServiciosRegistros.validarCliente;
import static com.PINACOMP.Services.lectura.*;

public class NuevoMenu {
    private static Scanner lectura = new Scanner(System.in);
    //Creando nuestro objeto de la clase Videojuegos servicios para utilizar metodos
    static VideojuegoServicios operacionesVideojuegos = new VideojuegoServicios();
    //Pasamos los elementos de la lista videojuegos  a nuestra tienda
    static List<Videojuegos> tienda = operacionesVideojuegos.obtenerVideojuegos();
    static MenuService menu = new MenuService();
    static Usuario u=null;
    public static void main(String[] args) {

        int opcion = 0;
        System.out.println("Bienvenido a nuestra tienda Gamers de corazón");
        while (true){
            System.out.println("que desea hacer?");
            System.out.println("1) Iniciar sesión");
            System.out.println("2) Registrarse");
            opcion=validarRango(1,2);
            if(opcion==1){
                String correo,contraseña;
                int opcionMenu;
                System.out.println("Ingrese su correo");
                correo=entradaValoresTexto();
                System.out.println("Ingrese su contraseña");
                contraseña=entradaValoresTexto();
                switch (UsuariosServicios.validarInicio(correo,contraseña)){
                    case 1:
                        do {
                            menu.menuAdministrador();
                            opcionMenu=validarRango(0,5);
                            menu.accionesAdmin(opcionMenu);
                        }while (opcionMenu!=0);
                        break;
                    case 2:
                        do {
                            menu.menuEmpleado();
                            opcionMenu=validarRango(0,5);
                            menu.accionesEmpleado(opcionMenu, lectura);
                        }while (opcionMenu!=0);
                        break;
                    case 3:
                        do {
                            menu.menuCliente();
                            opcionMenu=validarRango(0,4);
                            menu.opcionMenuCliente(validarCliente(correo,contraseña),opcionMenu, lectura);
                        }while(opcionMenu!=0);
                        break;
                    case 4:
                        System.out.println("Usuario no encontrado o inactivo");
                        break;
                }
            } else if (opcion==2) {
                UsuariosServicios.registroClientes();
            }
        }
    }
}
