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
        do{

            menu.menuCliente();
            opcion=entradaValores();
            menu.opcionMenuCliente(opcion, lectura);

        }while (opcion!= 0);
    }
    public static int entradaValores(){
        int opcion;
        System.out.println("Digita el numero de la opcion que te interesa realizar");
        opcion=lectura.nextInt();
        return opcion;
    }
}
