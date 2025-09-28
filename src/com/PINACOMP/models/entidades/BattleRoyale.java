package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Pais;
import com.PINACOMP.models.enums.TipoClasificacion;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.interfaces.ServicioVideojuegos;

import java.time.LocalDate;
import java.util.Date;

public class BattleRoyale extends Videojuegos implements ServicioVideojuegos {
    String eventos;
    Pais servidores;
    Date duracion;
    String partida;

    public BattleRoyale(int id,String titulo, double precio, Sistema plataforma, TipoClasificacion clasificacion, TipoGenero genero, LocalDate anioLanzamiento, String desarrolladora, int noJugadores, String eventos, Pais servidores, Date duracion, String partida) {
        super(id,titulo, precio, plataforma, clasificacion, genero, anioLanzamiento, desarrolladora, noJugadores);
        this.eventos = eventos;
        this.servidores = servidores;
        this.duracion = duracion;
        this.partida = partida;
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

    public String getPartida() {
        return partida;
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
        sb.append(" La partida: ").append(partida);

        return super.toString() + sb.toString();
    }
}
