package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.Cliente;
import com.PINACOMP.models.entidades.Compra;
import com.PINACOMP.models.entidades.Sistema;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoCompra;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoPago;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VentasData {
    private static final List<Compra> listaVentas = new ArrayList<>();
    static {
        //Datos ficticios de clientes
        Cliente cli1 = new Cliente("Eduardo", "lalo9807@hotmail.com", "Calle quintin gonzalez", TipoPago.FISICA, TipoCompra.FISICO);
        Cliente cli2 = new Cliente("Rogelio", "rogelio-quiroz@hotmail.com", "Calle purisima", TipoPago.TARJETA, TipoCompra.FISICO);
        Cliente cli3 = new Cliente("Nancy", "NancyM@gmail.com", "Calle benito juarez", TipoPago.FISICA, TipoCompra.DIGITAL);
        Cliente cli4 = new Cliente("Francisco", "paquito09@hotmail.com", "Calle wenceslao", TipoPago.TARJETA, TipoCompra.FISICO);
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
