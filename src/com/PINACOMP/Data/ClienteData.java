package com.PINACOMP.Data;

import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;

public class ClienteData {
    private static final List<Usuario> clientes=new ArrayList<>();

    static {
        crearClientes();
    }
    private static void crearClientes(){
        clientes.add(new Usuario("Ana María", "López", "Guadalajara", 25, Genero.FEMENINO, "Mexico", "ana.lopez@gmail.com", "1234", TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Luis", "Torres", "Querétaro", 32, Genero.MASCULINO, "Mexico", "luis.torres@gmail.com", "luispass", TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Valeria", "Cruz", "CDMX", 22, Genero.FEMENINO, "Mexico", "valeria.cruz@gmail.com", "val123", TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Jorge", "Mendoza", "Tijuana", 40, Genero.MASCULINO, "Mexico", "jorge.mendoza@gmail.com", "jmendoza", TipoUsuario.CLIENTE));

    }
    public static List<Usuario> getClientes(){
        return clientes;
    }

    public static void agregarClientes(Usuario nuevo){clientes.add(nuevo);}
    
}
