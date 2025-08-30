package com.PINACOMP.Services;

import com.PINACOMP.Data.Videogames;
import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;

import java.util.ArrayList;
import java.util.List;

public class VideojuegoServicios {
    private Videogames informacion;

    public VideojuegoServicios(Videogames informacion) {
        this.informacion = informacion;
    }

    //Metodo para buscar por sistema
    public List<Videojuegos> buscarPorSistema(Sistema sistema){
        List<Videojuegos> resultadoSistema = new ArrayList<>();
        for(Videojuegos v : informacion.getTienda()){
            if(v.getPlataforma().getConsola()== sistema.getConsola()){
                resultadoSistema.add(v);
            }
        }
        return resultadoSistema;
    }
}
