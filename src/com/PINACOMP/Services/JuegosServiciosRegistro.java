package com.PINACOMP.Services;

import com.PINACOMP.Excepciones.TituloInvalidoException;
import com.PINACOMP.models.entidades.Videojuegos;
import com.PINACOMP.models.enums.TipoConsola;
import com.PINACOMP.models.enums.TipoGenero;
import com.PINACOMP.models.enums.TipoPuesto;

import java.util.ArrayList;
import java.util.List;


import static com.PINACOMP.Services.lectura.entradaValoresSafeDouble;
import static com.PINACOMP.Services.lectura.entradaValoresTexto;


public class JuegosServiciosRegistro {
    public static String validarTitulo(){
        while(true){
            try{
                System.out.println("Dame el titulo de tu videojuego: ");
                String titulo = entradaValoresTexto();
                TituloInvalidoException.validar(titulo);
                return titulo;
            }catch (TituloInvalidoException e){
                System.out.println(e.getMessage());
            }
        }
    }


    public static TipoGenero solicitarGeneroValido(){
        while (true){
            try {
                TipoGenero tipoGenero = TipoGenero.valueOf(entradaValoresTexto().toUpperCase());
                return tipoGenero;
            }catch (IllegalArgumentException e){
                System.out.println("Error: Los datos ingresados no son validos");
            }
        }
    }
    public static TipoConsola solicitarSistemaValido(){
        while (true){
            try {
                TipoConsola consola = TipoConsola.valueOf(entradaValoresTexto().toUpperCase());
                return consola;
            }catch (IllegalArgumentException e){
                System.out.println("Error: Los datos ingresados no son validos");
            }
        }
    }

}
