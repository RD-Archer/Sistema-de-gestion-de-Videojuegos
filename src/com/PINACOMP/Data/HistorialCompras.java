package com.PINACOMP.Data;


import com.PINACOMP.models.entidades.Informe;
import com.PINACOMP.models.entidades.Sistema;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class HistorialCompras {
    Date fecha=new Date();
    Sistema sistema=null;
    public List<Informe>informes;


    private HistorialCompras(){
        informes=new ArrayList<>();
        generarInformes();
    }
    public void generarInformes(){
        informes.add(new Informe(fecha,07,1,300,sistema ));
    }
    public List<Informe> getInformes(){
        return informes;
    }
}
