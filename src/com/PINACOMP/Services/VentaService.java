package com.PINACOMP.Services;

import com.PINACOMP.Data.VentasData;
import com.PINACOMP.models.entidades.Cliente;
import com.PINACOMP.models.entidades.Compra;
import com.PINACOMP.models.entidades.Videojuegos;

import java.time.LocalDate;
import java.util.List;

public class VentaService {
    public void  venderPorTitulo(List<Videojuegos> catalogo, String titulo, Cliente cliente){
        Videojuegos videojuegoVendido = null;
        for(Videojuegos v: catalogo){
            List<Videojuegos> encontrado = v.buscarTitulo(titulo);
            if(!encontrado.isEmpty()){
                videojuegoVendido=encontrado.get(0);
                break;
            }
        }
        if(videojuegoVendido==null){
            System.out.println("No se encontro ningún videojuego por el titulo" +titulo);
            return;
        }
        if(videojuegoVendido.getStock()<=0){
            System.out.println("El videojuego : "+videojuegoVendido.getTitulo() + " está agotado por el momento");
            return;
        }
        //Procedemos a la venta si no entro en ningun caso
        Compra nuevaCompra = new Compra(VentasData.obtenerVentas().size()+1,videojuegoVendido,cliente, LocalDate.of(2025,11,4),10);
        VentasData.agregarVenta(nuevaCompra);

        //actualizar el stock
        videojuegoVendido.setStock(videojuegoVendido.getStock()-1);
        System.out.println("Venta realizada correctamente");
    }
}
