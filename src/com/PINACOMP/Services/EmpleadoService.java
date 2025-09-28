package com.PINACOMP.Services;

import com.PINACOMP.Data.Videogames;
import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpleadoService {
    private final List<Videojuegos> videojuegos;
    public EmpleadoService(){
        this.videojuegos= Videogames.obtenerVideojuegos();
    }
    public List<Videojuegos> obtenerVideojuegos(){
        return videojuegos;
    }

    public void mostrarVideojuegos(List<Videojuegos> resultados){
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

    public void agregarVideojuegos(Scanner scanner){
        System.out.println("=== Ingresa los datos del videojuego que deseas agregar ===");
        System.out.println("ID del videojuego");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Titulo: ");
        String titulo = scanner.nextLine();
        System.out.println("Precio: ");
        double precio=scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Desarrolladora: ");
        String desarrolladora= scanner.nextLine();
        System.out.println("Cantidad de Jugadores");
        int cantJugadores= scanner.nextInt();
        scanner.nextLine();

        //obtenemos primero los sistemas
        List<Sistema> sistemasDisponibles = new ArrayList<>();
        for(Videojuegos v : Videogames.obtenerVideojuegos()){
            if (!sistemasDisponibles.contains(v.getPlataforma())){
                sistemasDisponibles.add(v.getPlataforma());
            }
        }
        System.out.println("Elige un Consola para ese videojuego (Elige el número)");
        for(int i= 0; i<sistemasDisponibles.size(); i++){
            Sistema s = sistemasDisponibles.get(i);
            System.out.println((i+1) + "- " +s.getVersion());
        }
        int opcionConsola= scanner.nextInt();
        scanner.nextLine();
        Sistema sistemaSeleccionado = sistemasDisponibles.get(opcionConsola-1);

        System.out.println("Genero (Elige un número) :");
        for(TipoGenero genero : TipoGenero.values()){
            System.out.println(genero.ordinal()+ " - " +genero);
        }
        int opcionGenero= scanner.nextInt();
        scanner.nextLine();
        TipoGenero generoSeleccionado = TipoGenero.values()[opcionGenero];

        System.out.println("Clasificación (Elige un número) :");
        for(TipoClasificacion clasificacion : TipoClasificacion.values()){
            System.out.println(clasificacion.ordinal()+ " - " +clasificacion);
        }
        int opcionClasificacion= scanner.nextInt();
        scanner.nextLine();
        TipoClasificacion  clasificacionSeleccionada = TipoClasificacion.values()[opcionClasificacion];


        System.out.println("Ingresa la fecha de salida: (DIA)");
        int dia=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa la fecha de salida: (MES 1-12) ");
        int mes=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa la fecha de salida: (AÑO)");
        int anio=scanner.nextInt();
        scanner.nextLine();
        //Creando fecha
        LocalDate f = LocalDate.of(anio, mes, dia);

        //Creando videojuego
        Videojuegos v = new Videojuegos(id,titulo,precio,sistemaSeleccionado,clasificacionSeleccionada,generoSeleccionado,f,desarrolladora,cantJugadores);
        videojuegos.add(v);
        System.out.println("Videojuego agregado correctamente: " + titulo);
    }

    public void actualizarVideojuego(Scanner scanner){
        System.out.println("===Actualizando Videojuego ====");
        System.out.println("Ingresa el ID del libro que deseas actualizar");
        int idActualizar = scanner.nextInt();
        scanner.nextLine();

        //Buscando el libro por el id
        Videojuegos videojuegoActualizar = null;
        for(Videojuegos videojuego : videojuegos){
            if(videojuego.getId()==idActualizar){
                videojuegoActualizar= videojuego;
                break;
            }
        }
        if (videojuegoActualizar==null){
            System.out.println("No se encontro el videojuego por ID");
            return;
        }
        System.out.println("Videojuego encontrado: " +videojuegoActualizar);
        System.out.println("¿Qué atributo deseas actualizar? ");
        System.out.println("1. Título");
        System.out.println("2. Precio");
        System.out.println("3. Genero");
        System.out.println("4. Clasificación");
        System.out.println("5. Desarolladora");
        System.out.println("6. Fecha");
        System.out.println("7. Sistema");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion){
            case 1: {
                System.out.println("Nuevo título: ");
                String nuevoTitulo=scanner.nextLine();
                videojuegoActualizar.setTitulo(nuevoTitulo);
            }
        }
        System.out.println("Libro actualizado correctamente: " + videojuegoActualizar);
    }


}
