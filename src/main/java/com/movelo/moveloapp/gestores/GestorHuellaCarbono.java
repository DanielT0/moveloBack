package com.movelo.moveloapp.gestores;

import com.movelo.moveloapp.models.Recorrido;

import org.springframework.stereotype.Component;

@Component
public class GestorHuellaCarbono {
    private double huellaTotal;
    private double huellaRecorrido;
    private double kgPorCarro;
    public double calcularHuellaTotal(double metros){
        kgPorCarro=0.3;
        huellaTotal=kgPorCarro *metros;
        return huellaTotal;
    }
    public double calcularHuellaRecorrido(Recorrido recorrido){
        kgPorCarro=0.3;
        huellaRecorrido = kgPorCarro*recorrido.getDistanciaTotal();
        return huellaRecorrido;
    }
    
}
