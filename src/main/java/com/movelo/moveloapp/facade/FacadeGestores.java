package com.movelo.moveloapp.facade;

import java.util.List;

import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.gestores.GestorHuellaCarbono;
import com.movelo.moveloapp.gestores.GestorRecorrido;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.Recorrido;
import com.movelo.moveloapp.models.RegistroGeografico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacadeGestores {

    @Autowired
    private GestorBiciusuario gestBiciUsuario;
    @Autowired
    private GestorRecorrido gestorRecorrido;

    private GestorHuellaCarbono gestorHuellaCarbono;

    public boolean agregarBiciusuario(Biciusuario usuario) {
        return gestBiciUsuario.agregarBiciusuario(usuario);
    }

    public GestorBiciusuario getGestBiciUsuario() {
        return gestBiciUsuario;
    }

    public void setGestBiciUsuario(GestorBiciusuario gestBiciUsuario) {
        this.gestBiciUsuario = gestBiciUsuario;
    }

    public boolean finalizarRecorrido(List<RegistroGeografico> listaPuntos, Double distanciaTotal,
            Biciusuario usuario) {
        return gestorRecorrido.finalizarRecorrido(listaPuntos, distanciaTotal, usuario);
    }

    public double calcularHuellaTotal(Biciusuario ciclista){
        double huella = gestorHuellaCarbono.calcularHuellaTotal(ciclista.getMetrosRecorridos());
        actualizarHuella(ciclista, huella);
        return huella;
    }
    public void actualizarHuella(Biciusuario ciclista, double huella){
        gestBiciUsuario.actualizarHuella(ciclista, huella);
    }
    public double calcularHuellaRecorrido(Recorrido recorrido){
        double huella = gestorHuellaCarbono.calcularHuellaRecorrido(recorrido);
        return huella;
    }
}
