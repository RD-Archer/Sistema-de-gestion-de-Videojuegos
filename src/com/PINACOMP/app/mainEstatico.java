package com.PINACOMP.app;

import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;

import java.time.LocalDate;

public class mainEstatico {
    public static void main(String[] args) {

        LocalDate f1 = LocalDate.of(2005, 12, 5);
        Sistema s1 = new Sistema(TipoConsola.XBOX,"Bill Gates","360",f1);
        Videojuegos v1 = new Videojuegos("Burnout", 500, s1, TipoClasificacion.B, TipoGenero.DEPORTES, f1, "EA", 2);
        System.out.println(v1);
    }
}
