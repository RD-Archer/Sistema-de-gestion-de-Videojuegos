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
    public Cliente(){

    }
    public Cliente(String nombre, String apellidoPaterno, String apellidoMaterno, int edad, Genero genero, String pais, int codigoPostal, String domicilio, String correo, String contraseña, String numero, TipoUsuario rol, TipoPago tipoPago, TipoCompra compra, int pedidos) {
        super(nombre, apellidoPaterno, apellidoMaterno, edad, genero, pais, codigoPostal, domicilio, correo, contraseña, numero, rol);
        this.tipoPago = tipoPago;
        this.compra = compra;
        this.pedidos = pedidos;
    }
    //Constructor para uso de ventas
    public Cliente (String nombre, String correo, String domicilio, TipoPago tipoPago , TipoCompra compra){
        super(nombre,correo,domicilio);
        this.tipoPago=tipoPago;
        this.compra=compra;
    }
    public Cliente(TipoPago tipoPago, TipoCompra compra, int pedidos) {
        this.tipoPago = tipoPago;
        this.compra = compra;
        this.pedidos = pedidos;
    }

    // A modificar o completar
    public List<Compra> VerHistorialCompra(){
        System.out.println("Funcion no implementada");
        return VerHistorialCompra();
    }

}
