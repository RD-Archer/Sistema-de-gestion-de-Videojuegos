package com.PINACOMP.models.interfaces;

import com.PINACOMP.models.entidades.Videojuegos;

public interface ServicioVideojuegos {
    public void probarVideojuego();
    //|-----------------------------------------------------------------------------------|
    public static Videojuegos ActualizarVideojuegos(Videojuegos videojuegos){
        String respuesta=null;
        do {

            System.out.println("Que de desea hacer primero?");
            System.out.println("1) Mostrar Los videojuegos disponibles");
            System.out.println("2) Modificar los videojuegos disponibles");
            System.out.println("3) salir");





        }
        while (!(respuesta.equalsIgnoreCase("3")||respuesta.equalsIgnoreCase("No")));
        return videojuegos;
    }
    //|-----------------------------------------------------------------------------------|
    public static Videojuegos agregarVideojuegos(Videojuegos videojuegos){
        System.out.println("Funcion no implementada");
        return videojuegos;
    }
    //|-----------------------------------------------------------------------------------|
    public static Videojuegos EliminarVideojuegos(Videojuegos videojuegos){
        System.out.println("Funcion no implementada");
        return videojuegos;
    }







}
