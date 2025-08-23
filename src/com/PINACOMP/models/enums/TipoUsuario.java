package com.PINACOMP.models.enums;

public enum TipoUsuario {
    Administrador("Administrador del sistema."),
    USUARIO("Cliente");

    private String Usuario;

    TipoUsuario(String usuario) {
        this.Usuario = usuario;
    }

    public String toString(){

        return Usuario;
    }

}
