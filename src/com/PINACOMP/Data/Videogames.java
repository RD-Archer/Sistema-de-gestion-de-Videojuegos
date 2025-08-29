package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Videogames {
    public static List<Videojuegos> crearVideojuegos(){
        LocalDate f1 = LocalDate.of(2005, 12, 5);
        LocalDate f2 = LocalDate.of(2020, 10, 23);
        LocalDate f3 = LocalDate.of(2026, 3, 15);
        Sistema s1 = new Sistema(TipoConsola.XBOX,"Bill Gates","360",f1);
        Videojuegos v1 = new Videojuegos("Burnout", 500, s1, TipoClasificacion.B, TipoGenero.DEPORTES, f1, "EA", 2);
        Sistema s2 = new Sistema(TipoConsola.PLAYSTATION,"Ken kutaragi","4",f2);
        Videojuegos v2 = new Videojuegos("Spiderman", 1500, s2, TipoClasificacion.A, TipoGenero.AVENTURA, f2, "Insomiac Games", 1);
        Sistema s3 = new Sistema(TipoConsola.NINTENDO,"Shigeru Miyamoto","switch",f3);
        Videojuegos v3 = new Videojuegos("Super Smash Bros. Ultimate", 899, s3, TipoClasificacion.A, TipoGenero.ACCION, f3, "Bandai Namco", 4);
        return Arrays.asList(v1, v2, v3);
    }
}
