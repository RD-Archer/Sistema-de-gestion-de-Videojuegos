package com.PINACOMP.Data;


import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
import com.PINACOMP.models.enums.TipoEstado;
import com.PINACOMP.models.enums.TipoPuesto;
import com.PINACOMP.models.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.List;
//Nuevo
public class UsuariosData {
    private List<Empleado> empleados;

    public UsuariosData(){

        empleados=new ArrayList<>();
        crearUsuarios();

    }
    private void crearUsuarios(){
        empleados.add(new Empleado("Rogelio David","Quiroz","San Vicente",19,Genero.MASCULINO,"Mexico","correoprueba06@gmail.com","Contraseña",TipoUsuario.EMPLEADO,0000001,1000, TipoPuesto.ADMIN,"Archer",TipoEstado.ACTIVO));
        empleados.add(new Empleado("Carlos", "Ramírez", "Monterrey", 30, Genero.MASCULINO, "Mexico", "carlos.ramirez@gmail.com", "abcd", TipoUsuario.EMPLEADO,0000002,750,TipoPuesto.GERENTE,"Pendiente", TipoEstado.PENDIENTE));
        empleados.add(new Empleado("Laura", "González", "Puebla", 28, Genero.FEMENINO, "Mexico", "laura.gonzalez@gmail.com", "laura123", TipoUsuario.EMPLEADO, 0000003, 800, TipoPuesto.VENDEDOR, "Activo", TipoEstado.ACTIVO));
        empleados.add(new Empleado("Miguel", "Hernández", "CDMX", 35, Genero.MASCULINO, "Mexico", "miguel.hdz@gmail.com", "miguelpass", TipoUsuario.EMPLEADO, 0000004, 950, TipoPuesto.SUPERVISOR, "Activo", TipoEstado.ACTIVO));
        empleados.add(new Empleado("Sofía", "Martínez", "Toluca", 26, Genero.FEMENINO, "Mexico", "sofia.mtz@gmail.com", "sofia456", TipoUsuario.EMPLEADO, 0000005, 700, TipoPuesto.VENDEDOR, "Pendiente", TipoEstado.PENDIENTE));



    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }





    public class ClienteData {
        private List<Usuario> clientes;

        public ClienteData(){

            clientes=new ArrayList<>();
            crearClientes();

        }
        private void crearClientes(){
            clientes.add(new Usuario("Ana María", "López", "Guadalajara", 25, Genero.FEMENINO, "Mexico", "ana.lopez@gmail.com", "1234", TipoUsuario.CLIENTE));
            clientes.add(new Usuario("Luis", "Torres", "Querétaro", 32, Genero.MASCULINO, "Mexico", "luis.torres@gmail.com", "luispass", TipoUsuario.CLIENTE));
            clientes.add(new Usuario("Valeria", "Cruz", "CDMX", 22, Genero.FEMENINO, "Mexico", "valeria.cruz@gmail.com", "val123", TipoUsuario.CLIENTE));
            clientes.add(new Usuario("Jorge", "Mendoza", "Tijuana", 40, Genero.MASCULINO, "Mexico", "jorge.mendoza@gmail.com", "jmendoza", TipoUsuario.CLIENTE));


        }
        public List<Usuario> getClientes(){

            return clientes;
        }





    }





}

