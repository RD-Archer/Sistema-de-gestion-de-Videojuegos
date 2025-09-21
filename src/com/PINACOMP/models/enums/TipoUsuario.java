package com.PINACOMP.models.enums;

public enum TipoUsuario {
    EMPLEADO("Empleado"),
    CLIENTE("Cliente");

    private String Usuario;

    TipoUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String toString(){

        return Usuario;
    }

}
