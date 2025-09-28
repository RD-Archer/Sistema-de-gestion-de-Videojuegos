package com.PINACOMP.app;
import com.PINACOMP.Data.Videogames;
import com.PINACOMP.Services.MenuService;
import com.PINACOMP.Services.VideojuegoServicios;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoGenero;
import java.util.List;
import java.util.Scanner;

public class mainEstatico {
    private static Scanner lectura = new Scanner(System.in);
    //Creando nuestro objeto de la clase Videojuegos servicios para utilizar metodos
    static VideojuegoServicios operacionesVideojuegos = new VideojuegoServicios();
    //Pasamos los elementos de la lista videojuegos  a nuestra tienda
    static List<Videojuegos> tienda = operacionesVideojuegos.obtenerVideojuegos();
    static MenuService menu = new MenuService();
    public static void main(String[] args) {
        int opcion;
        System.out.println("Bienvenido a nuestra tienda Gamers de corazón");
        System.out.println("¿Qué tipo de usuario eres: \n 1-Cliente \n2-Empleado  \n0-salir");
        opcion=entradaValores();
        while(opcion!=0){
            if(opcion==1){
                int opcionCliente;
                do{

                    menu.menuCliente();
                    opcionCliente=entradaValores();
                    menu.opcionMenuCliente(opcionCliente, lectura);

                }while (opcionCliente!= 0);
            }else if(opcion==2){
                int opcionEmpleado;
                do{
                    menu.menuEmpleado();
                    opcionEmpleado=entradaValores();
                    menu.accionesEmpleado(opcionEmpleado, lectura);

                }while (opcionEmpleado!=0);

            }

            System.out.println("¿Qué tipo de usuario eres:  \n 1-Cliente \n 2-Empleado   \n 0-Salir" );
            opcion = entradaValores();
        }
        System.out.println("Gracias por usar el Sistema de librerias Eternas");
        System.out.println("¡Hasta pronto!");

    }
    public static int entradaValores(){
        int opcion;
        opcion=lectura.nextInt();
        return opcion;
    }
}
