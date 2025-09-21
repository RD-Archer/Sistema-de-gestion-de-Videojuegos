package com.PINACOMP.Data;


import com.PINACOMP.models.entidades.Empleado;
import com.PINACOMP.models.entidades.Usuario;
import com.PINACOMP.models.enums.Genero;
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
        empleados.add(new Empleado("Rogelio David","Quiroz","San Vicente",19,Genero.MASCULINO,"Mexico","correoprueba06@gmail.com","Contraseña",TipoUsuario.EMPLEADO,0000001,1000, TipoPuesto.ADMIN,"Archer"));
        empleados.add(new Empleado("Carlos", "Ramírez", "Monterrey", 30, Genero.MASCULINO, "Mexico", "carlos.ramirez@gmail.com", "abcd", TipoUsuario.EMPLEADO,0000002,750,TipoPuesto.GERENTE,"Pendiente"));


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

        }
        public List<Usuario> getClientes(){

            return clientes;
        }





    }





}

