package com.PINACOMP.app;
import com.PINACOMP.Excepciones.CorreoInvalidoException;
import com.PINACOMP.Services.MenuService;
import com.PINACOMP.Services.UsuariosServicios;
import com.PINACOMP.Services.VideojuegoServicios;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.entidades.Videojuegos;

import java.util.List;
import java.util.Scanner;

import static com.PINACOMP.Services.ServiciosRegistros.validarCliente;
import static com.PINACOMP.Services.lectura.entradaValoresSafe;
import static com.PINACOMP.Services.lectura.validarRango;

public class mainEstatico {
    private static Scanner lectura = new Scanner(System.in);
    //Creando nuestro objeto de la clase Videojuegos servicios para utilizar metodos
    static VideojuegoServicios operacionesVideojuegos = new VideojuegoServicios();
    //Pasamos los elementos de la lista videojuegos  a nuestra tienda
    static List<Videojuegos> tienda = operacionesVideojuegos.obtenerVideojuegos();
    static MenuService menu = new MenuService();
    static Usuario U1=new Usuario();
    public static void main(String[] args) {
        int opcion;
        String correo,contraseña;
        System.out.println("Bienvenido a nuestra tienda Gamers de corazón");
        //System.out.println("¿Qué tipo de usuario eres: \n 1-Cliente \n2-Empleado  \n0-salir");

        System.out.println("Indica que quieres hacer? "+"\n"+"1-Iniciar como cliente "+"\n"+"2-Iniciar como empleado "+"\n"+"3-Registrarse "+"\n"+"0-Salir");
        opcion=entradaValoresSafe();
        while(opcion!=0){
            if(opcion==1){
                while(true){
                    try{
                        System.out.println("Ingresa tu correo: ");
                        correo=entradaValoresTexto();
                        CorreoInvalidoException.validarCorreo(correo);
                        break;

                    }catch (CorreoInvalidoException e){
                        System.out.println(e.getMessage());
                    }
                }
                System.out.println("Ingresa tu contraseña: ");
                contraseña=entradaValoresTexto();
                boolean validadorClientes;
                validadorClientes=U1.inicioSesionCliente(correo,contraseña);
                if (validadorClientes==true){
                    int opcionCliente;
                    do{
                        menu.menuCliente();
                        opcionCliente=validarRango(0,4);
                        menu.opcionMenuCliente(validarCliente(correo, contraseña), opcionCliente, lectura);
                    }while (opcionCliente!= 0);
                }else{
                    System.out.println("el correo o contraseña son incorrectos.");

                }
            }else if(opcion==2){
                System.out.println("Cual es tu roll? \n1.Vendedor \n2.Administrador ");
                int opcionEmpleado;
                opcionEmpleado=entradaValoresSafe();
                if (opcionEmpleado==1){

                    System.out.println("Ingresa tu correo: ");
                    correo=entradaValoresTexto();
                    System.out.println("Ingresa tu contraseña: ");
                    contraseña=entradaValoresTexto();
                    boolean validador;
                    validador=U1.inicioSesionEmpleado(correo,contraseña);
                    if (validador==true){
                        do{
                            menu.menuEmpleado();
                            opcionEmpleado=validarRango(0,4);
                            menu.accionesEmpleado(opcionEmpleado, lectura);
                        }while (opcionEmpleado!=0);
                    }else{
                        System.out.println("el correo o contraseña son incorrectos.");
                    }
                } else if (opcionEmpleado==2) {
                    lectura.nextLine();
                    System.out.println("Ingresa tu correo: ");
                    correo=entradaValoresTexto();
                    System.out.println("Ingresa tu contraseña: ");
                    contraseña=entradaValoresTexto();
                    boolean validador;
                    validador=U1.inicioSesionAdmin(correo,contraseña);
                    if (validador==true){
                        int opcionAdmin;
                        do {
                            menu.menuAdministrador();
                            opcionAdmin=validarRango(0,4);
                            menu.accionesAdmin(opcionAdmin);
                        }while (opcionAdmin!=0);

                    }else{
                        System.out.println("el correo o contraseña son incorrectos.");

                    }
                }

            } else if (opcion==3){
                UsuariosServicios.registroClientes();

            }
            System.out.println(" Indica que quieres hacer? "+"\n"+"1-Iniciar como cliente "+"\n"+"2-Iniciar como empleado "+"\n"+"3-Registrarse ");
            opcion = entradaValores();

            /*System.out.println("¿Qué tipo de usuario eres:  \n 1-Cliente \n 2-Empleado   \n 0-Salir" );
            opcion = entradaValores();*/
        }
        System.out.println("Gracias por usar el Sistema de librerias Eternas");
        System.out.println("¡Hasta pronto!");

    }
    public static int entradaValores(){
        boolean entradaValida=false;
        int opcion=0;
        while(!entradaValida){
            if(lectura.hasNextInt()){
                opcion = lectura.nextInt();
                entradaValida=true;
                lectura.nextLine();
            }else{
                System.out.println("Entrada inválida. Porfavor ingresa un número entero");
                lectura.nextLine();
            }
        }

        return opcion;
    }
    public static double entradaValoresDecimal(){
        boolean entradaValida=false;
        double opcion=0;
        while(!entradaValida){
            if(lectura.hasNextDouble()){
                opcion = lectura.nextDouble();
                entradaValida=true;
                lectura.nextLine();
            }else{
                System.out.println("Entrada inválida. Porfavor ingresa un número con punto decil¿mal");
                lectura.nextLine();
            }
        }

        return opcion;
    }
    public static String entradaValoresTexto(){
        String cadena;
        cadena=lectura.nextLine();
        return cadena;
    }
}
