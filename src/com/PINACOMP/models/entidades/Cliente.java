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

    public Cliente(String nombre, String aPaterno, String aMaterno, int edad, Genero genero, String domicilio, String correo, String contraseña, TipoUsuario rol, TipoPago tipoPago, TipoCompra compra, int pedidos) {
        super(nombre, aPaterno, aMaterno, edad, genero, domicilio, correo, contraseña, rol);
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
