package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosData {
    private List<Usuario> Usuarios;

    public UsuariosData(){

        Usuarios=new ArrayList<>();
        crearUsuarios();

    }
    private void crearUsuarios(){
        Usuarios.add(new Usuario("Rogelio David","Quiroz","San Vicente",19,Genero.MASCULINO,"Mexico","correoprueba06@gmail.com","Contraseña",TipoUsuario.EMPLEADO));
        Usuarios.add(new Usuario("Ana María", "López", "Guadalajara", 25, Genero.FEMENINO, "Mexico", "ana.lopez@gmail.com", "1234", TipoUsuario.CLIENTE));
        Usuarios.add(new Usuario("Carlos", "Ramírez", "Monterrey", 30, Genero.MASCULINO, "Mexico", "carlos.ramirez@gmail.com", "abcd", TipoUsuario.EMPLEADO));


    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }
}
