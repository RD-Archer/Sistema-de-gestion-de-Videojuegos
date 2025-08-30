package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Pais;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.interfaces.ServicioVideojuegos;

import java.time.LocalDate;
import java.util.Date;

public class Mmorpg  extends Videojuegos implements ServicioVideojuegos {
    private String eventos;
    private Pais servidores;
    private Date duracion;
    private String recompensas;

    public Mmorpg(String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores, String eventos, Date duracion, Pais servidores, String recompensas) {
        super(titulo, precio, plataforma, clasificacion, genero, anioLanzamiento, desarrolladora, noJugadores);
        this.eventos = eventos;
        this.duracion = duracion;
        this.servidores = servidores;
        this.recompensas = recompensas;
    }

    public String getEventos() {
        return eventos;
    }

    public Pais getServidores() {
        return servidores;
    }

    public Date getDuracion() {
        return duracion;
    }

    public String getRecompensas() {
        return recompensas;
    }

    @Override
    public void probarVideojuego() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("El evento llamado: ").append(eventos);
        sb.append(" El evento empieza el: ").append(duracion);
        sb.append(" Estas en el servidor de: ").append(servidores);
        sb.append(" Las recompensas son: ").append(recompensas);

        return super.toString() + sb.toString();
    }
}
