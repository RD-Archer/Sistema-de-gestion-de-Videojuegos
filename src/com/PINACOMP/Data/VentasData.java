package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.*;
import com.PINACOMP.models.enums.TipoCompra;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentasData {
    private static final List<Compra> listaVentas = new ArrayList<>();
    static Usuario usuario=new Usuario("Rogelio ","Quiroz ","San Vicente ","Mexico",55635,"Mexico","correoPurba@gmail.com");
    static {
        //Datos ficticios de clientes
        Cliente cli1 = new Cliente(new Usuario("Eduardo","Piña","Gonzalez","Mexico",55684, "Calle quintin gonzalez", "lalo9807@hotmail.com"), TipoPago.FISICA, TipoCompra.FISICO);
        Cliente cli2 = new Cliente(new Usuario("Rogelio David ","Quiroz ","san Vicente","Mexico ",54135, "Calle purisima", "rogelio-quiroz@hotmail.com"), TipoPago.TARJETA, TipoCompra.FISICO);
        Cliente cli3 = new Cliente(new Usuario("Nancy","","","Mexico",55138, "Calle benito juarez", "NancyM@gmail.com"), TipoPago.FISICA, TipoCompra.DIGITAL);
        Cliente cli4 = new Cliente(new Usuario("Francisco","","","Mexico",51384, "Calle wenceslao", "paquito09@hotmail.com"), TipoPago.TARJETA, TipoCompra.FISICO);
        Cliente cli5=new Cliente(usuario,TipoPago.FISICA,TipoCompra.FISICO);
        ///datos ficticios de sistema
        Sistema s1 = new Sistema(TipoConsola.XBOX, "360");
        Sistema s2 = new Sistema(TipoConsola.PLAYSTATION, "5");
        Sistema s3 = new Sistema(TipoConsola.NINTENDO, "switch");
        Sistema s4 = new Sistema(TipoConsola.XBOX, "Series X");

        //Datos ficticios de videojuegos
        Videojuegos v1 = new Videojuegos(1,"Halo",1300,s1, TipoGenero.SHHOTERS);
        Videojuegos v2 = new Videojuegos(2,"Mario Bros",1500,s3, TipoGenero.AVENTURA);
        Videojuegos v3 = new Videojuegos(3,"Silent Hill",1800,s2, TipoGenero.TERROR);
        Videojuegos v4 = new Videojuegos(4,"Call of duty",1000,s4, TipoGenero.SHHOTERS);


        listaVentas.add( new Compra(1,v1,cli1, LocalDate.of(2025,10,5),10));
        listaVentas.add(new Compra(2,v2,cli2, LocalDate.of(2025,5,25),15));
        listaVentas.add( new Compra(3,v3,cli3, LocalDate.of(2025,7,12),5));
        listaVentas.add( new Compra(4,v4,cli4, LocalDate.of(2025,11,2),20));
    }
    //Obtener todas las ventas (Incluyendo nuevas)
    public  static List<Compra> obtenerVentas(){
        return listaVentas;
    }

    //Agregar una nueva venta
    public static void agregarVenta(Compra compra){
        listaVentas.add(compra);
    }
}
