package com.PINACOMP.models.entidades;

import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoCompra;
import com.PINACOMP.models.enums.TipoPago;
import com.PINACOMP.models.interfaces.ServiciosUsuarios;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona  {
    private TipoPago tipoPago;
    private TipoCompra compra;
    private int pedidos;

    public Cliente(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, TipoPago tipoPago, TipoCompra compra, int pedidos) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio);
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
