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
    public static List<Videojuegos> busquedaPorTitulo(List<Videojuegos>tienda,VideojuegoServicios operacionesVideojuegos){
        String titulo=validarTitulo();
        List<Videojuegos>encontrados=new ArrayList<>();
        for (Videojuegos videojuego: tienda ){
            List<Videojuegos> resultados = videojuego.buscarTitulo(titulo);
                encontrados.addAll(resultados);
        }
        if(encontrados.isEmpty()){
            System.out.println("No tenemos aun ese título en nuestro catalogo de videojuegos");
        }
        else {
            operacionesVideojuegos.mostrarVideojuegos(encontrados);
        }
        return encontrados;
    }
    //-------------------------------------------------------------------------------------|
    public static List<Videojuegos> busquedaPorPrecio(List<Videojuegos>tienda,VideojuegoServicios operacionesVideojuegos){
        System.out.println("Dame el precio del videojuego");
        double precio= entradaValoresSafeDouble();
        List<Videojuegos>encontrados=new ArrayList<>();
        for(Videojuegos videojuegos: tienda){
            List<Videojuegos> resultados= videojuegos.buscarPrecio(precio);
            encontrados.addAll(resultados);
        }
        if(encontrados.isEmpty()){
            System.out.println("No tenemos videojuegos con ese precio en nuestro catalogo.");
        }
        else {
            operacionesVideojuegos.mostrarVideojuegos(encontrados);
        }
        return encontrados;
    }
    public static List<Videojuegos> busquedaPorRango(List<Videojuegos>tienda,VideojuegoServicios operacionesVideojuegos){
        System.out.println("Dame tu precio minimo");
        double precioMin=entradaValoresSafeDouble();
        System.out.println("Dame tu precio Maximo");
        double precioMax=entradaValoresSafeDouble();
        List<Videojuegos> encontrados= new ArrayList<>();
        for(Videojuegos videojuego : tienda){
            List<Videojuegos> resultados =videojuego.buscarPorRangoPrecio(precioMin,precioMax);
               encontrados.addAll(resultados);
        }
        if(encontrados.isEmpty()){
            System.out.println("No tenemos ningún videojuego en ese rango de precio en nuestro catalogo.");
        }
        else {
            operacionesVideojuegos.mostrarVideojuegos(encontrados);
        }
        return encontrados;
    }
    public static List<Videojuegos>busquedaPorSistema(List<Videojuegos>tienda,VideojuegoServicios operacionesVideojuegos){
        System.out.println("Estos son nuestros sistemas");
        TipoConsola[] consolas = TipoConsola.values();
        for (int i=0; i< consolas.length; i++){
            System.out.println(consolas[i]);
        }
        System.out.println("Escribe el sistema que deseas ver sus videojuegos");
        String sistema= entradaValoresTexto();
        TipoConsola sistemaElegido = solicitarSistemaValido();

        List<Videojuegos> encontrados = new ArrayList<>();
        for(Videojuegos videojuego : tienda){
            List<Videojuegos> resultados=videojuego.buscarPorPlataforma(sistemaElegido);
            encontrados.addAll(resultados);
        }
        if(encontrados.isEmpty()){
            System.out.println("No tenemos ningún videojuego para ese sistema en nuestro catalogo.");
        }
        else {
            operacionesVideojuegos.mostrarVideojuegos(encontrados);
        }
        return encontrados;
    }
    public static List<Videojuegos> busquedaPorGenero( List<Videojuegos> tienda, VideojuegoServicios operacionesVideojuegos) {
        System.out.println("Estos son nuestros géneros en Videojuegos");
        TipoGenero[] generos  = TipoGenero.values();
        for (int i=0; i< generos.length; i++){
            System.out.println(generos[i]);
        }
        System.out.println("Escribe el Género que deseas ver sus videojuegos");
        String genero= entradaValoresTexto();
        TipoGenero generoElegido = solicitarGeneroValido();

        List<Videojuegos> encontrados = new ArrayList<>();
        for (Videojuegos videojuego : tienda) {
            List<Videojuegos> resultados = videojuego.buscarPorGenero(generoElegido);
            encontrados.addAll(resultados);
        }

        if (encontrados.isEmpty()) {
            System.out.println("No tenemos ningún videojuego para ese género en nuestro catálogo.");
        } else {
            operacionesVideojuegos.mostrarVideojuegos(encontrados);
        }

        return encontrados;
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
