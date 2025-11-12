package com.PINACOMP.Services;

import com.PINACOMP.Data.Videogames;
import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;

import java.util.ArrayList;
import java.util.List;


import static com.PINACOMP.Services.ServiciosBusquedaVideoJuegos.*;

public class VideojuegoServicios {
    private final List<Videojuegos> videojuegos;

    public VideojuegoServicios(){
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
    //Metodo para buscar por sistema
    public List<Videojuegos> buscarPorSistema(Sistema sistema){
        List<Videojuegos> resultadoSistema = new ArrayList<>();
        for(Videojuegos v : videojuegos){
            if(v.getPlataforma().getConsola()== sistema.getConsola()){
                resultadoSistema.add(v);
            }
        }
        return resultadoSistema;
    }

    public static void busquedaVideoJuegos(int opcion, List<Videojuegos> tienda,VideojuegoServicios operacionesVideojuegos){
        switch (opcion){
            case 1:
                busquedaPorTitulo(tienda,operacionesVideojuegos);
                break;
            case 2:
                busquedaPorPrecio(tienda,operacionesVideojuegos);
                break;
            case 3:
                busquedaPorRango(tienda,operacionesVideojuegos);
                break;
            case 4:
                busquedaPorSistema(tienda,operacionesVideojuegos);
                break;
            case 5:
                busquedaPorGenero(tienda,operacionesVideojuegos);
                break;

        }
    }

}
