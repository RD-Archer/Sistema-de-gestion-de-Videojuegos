package com.PINACOMP.app;


import com.PINACOMP.Excepciones.RangoInvalidoException;
import com.PINACOMP.Services.MenuService;
import com.PINACOMP.Services.UsuariosServicios;
import com.PINACOMP.Services.VideojuegoServicios;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.entidades.Videojuegos;
import static com.PINACOMP.Services.lectura.entradaValoresSafe;
import static com.PINACOMP.Services.lectura.entradaValoresTexto;

import java.util.List;
import java.util.Scanner;

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
            int entradaGlobal2;
            try {
                entradaGlobal2=entradaValoresSafe();
                RangoInvalidoException.validarRango(entradaGlobal2, 1, 2);
                opcion=entradaGlobal2;
            }catch (RangoInvalidoException e){
                System.out.println("Error: "+e.getMessage());
            }
            if(opcion==1){
                String correo,contraseña;
                int opcionMenu;
                System.out.println("Ingrese su correo");
                correo=entradaValoresTexto();
                System.out.println("Ingrese su contraseña");
                contraseña=entradaValoresTexto();
                if(UsuariosServicios.validarInicio(correo,contraseña)==1) {
                    do {
                        menu.menuAdministrador();
                        opcionMenu=entradaValoresSafe();
                        menu.accionesAdmin(opcionMenu, lectura);
                    }while (opcionMenu!=0);
                } else if(UsuariosServicios.validarInicio(correo,contraseña)==2){
                    do {
                        menu.menuEmpleado();
                        opcionMenu=entradaValoresSafe();
                        menu.accionesEmpleado(opcionMenu, lectura);
                    }while (opcionMenu!=0);
                } else if (UsuariosServicios.validarInicio(correo,contraseña)==3) {
                    do {
                        menu.menuCliente();
                        opcionMenu=entradaValoresSafe();
                        menu.opcionMenuCliente(opcionMenu, lectura);
                    }while(opcionMenu!=0);
                } else if (UsuariosServicios.validarInicio(correo,contraseña)==4) {
                    System.out.println("Usuario no encontrado o inactivo");
                }
            } else if (opcion==2) {
                UsuariosServicios.registroClientes();
            }
        }
    }

}
