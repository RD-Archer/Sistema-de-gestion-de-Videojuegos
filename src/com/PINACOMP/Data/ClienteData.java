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
        clientes.add(new Usuario("Ana María", "López", "Guadalajara", 25, Genero.FEMENINO, "Mexico",55786 ,"avenida","ana.lopez@gmail.com", "1234", "5546758426",TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Luis", "Torres", "Querétaro", 32, Genero.MASCULINO, "Mexico",55789,"calle", "luis.torres@gmail.com", "luispass", "5534698524",TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Valeria", "Cruz", "CDMX", 22, Genero.FEMENINO, "Mexico",57895,"calle principal", "valeria.cruz@gmail.com", "val123","78965412307" ,TipoUsuario.CLIENTE));
        clientes.add(new Usuario("Jorge", "Mendoza", "Tijuana", 40, Genero.MASCULINO,"Mexico",7 ,"avenida", "jorge.mendoza@gmail.com", "jmendoza", "5574612354",TipoUsuario.CLIENTE));

    }
    public static List<Usuario> getClientes(){
        return clientes;
    }

    public static void agregarClientes(Usuario nuevo){clientes.add(nuevo);}
    
}
