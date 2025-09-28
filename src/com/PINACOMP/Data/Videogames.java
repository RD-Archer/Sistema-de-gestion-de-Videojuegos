package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.Simulacion;
import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoSimulacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Videogames {
    public static List<Videojuegos> tienda = new ArrayList<>();

static{
        LocalDate f1 = LocalDate.of(2005, 12, 5);
        LocalDate f2 = LocalDate.of(2020, 10, 23);
        LocalDate f3 = LocalDate.of(2026, 3, 15);
        Sistema s1 = new Sistema(TipoConsola.XBOX, "Bill Gates", "360", f1);
        tienda.add(new Videojuegos(1,"Burnout", 500, s1, TipoClasificacion.B, TipoGenero.DEPORTES, f1, "EA", 2));
        Sistema s2 = new Sistema(TipoConsola.PLAYSTATION, "Ken kutaragi", "4", f2);
        tienda.add(new Videojuegos(2,"Spiderman", 1500, s2, TipoClasificacion.A, TipoGenero.AVENTURA, f2, "Insomiac Games", 1));
        Sistema s3 = new Sistema(TipoConsola.NINTENDO, "Shigeru Miyamoto", "switch", f3);
        tienda.add(new Videojuegos(3,"Super Smash Bros. Ultimate", 899, s3, TipoClasificacion.A, TipoGenero.ACCION, f3, "Bandai Namco", 4));
        tienda.add(new Simulacion(4,"Flight Simulator", 1200, s1, TipoClasificacion.B, TipoGenero.SIMULACION, f1, "Microsoft", 1, "Monaco", TipoSimulacion.VUELO));
        tienda.add(new Simulacion(5,"The Sims 4", 800, s1, TipoClasificacion.C, TipoGenero.SIMULACION, f2, "Maxis", 1, "SimTown", TipoSimulacion.VIDA));
        tienda.add(new Simulacion(6,"Sea of Thieves", 1300, s2, TipoClasificacion.B, TipoGenero.SIMULACION, f3, "Rare", 4, "Caribbean Sea", TipoSimulacion.NAVEGACION));

    }
    //metodo para acceder a lista
    public static List<Videojuegos> obtenerVideojuegos(){
        return tienda;
    }
}


