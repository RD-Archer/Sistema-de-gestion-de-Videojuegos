package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoCompra;
import com.PINACOMP.models.enums.TipoPago;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.List;

public class Cliente extends Usuario {
    private TipoPago tipoPago;
    private TipoCompra compra;
    private int pedidos;
    private Usuario usuario;
    public Cliente(){

    }


    //Constructor para uso de ventas

    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, String pais, int codigoPostal, String domicilio, String correo, TipoPago tipoPago, TipoCompra compra) {
        super(nombre, apellidoPaterno, apellidoMaterno, pais, codigoPostal, domicilio, correo);
        this.tipoPago = tipoPago;
        this.compra = compra;
    }

    /*public Cliente (String nombre, String correo, String domicilio, TipoPago tipoPago , TipoCompra compra){
            super(nombre,correo,domicilio);
            this.tipoPago=tipoPago;
            this.compra=compra;
        }*/
    public Cliente(TipoPago tipoPago, TipoCompra compra, int pedidos) {
        this.tipoPago = tipoPago;
        this.compra = compra;
        this.pedidos = pedidos;
    }

    public Cliente(Usuario usuario,TipoPago tipoPago, TipoCompra compra) {
        this.usuario=usuario;
        this.tipoPago = tipoPago;
        this.compra=compra;

    }

    // A modificar o completar
    public List<Compra> VerHistorialCompra(){
        System.out.println("Funcion no implementada");
        return VerHistorialCompra();
    }

}
