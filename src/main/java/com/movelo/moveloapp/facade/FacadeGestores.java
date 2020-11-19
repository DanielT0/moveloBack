package com.movelo.moveloapp.facade;

import java.util.List;

import com.movelo.moveloapp.gestores.GestorArboles;
import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.gestores.GestorHuella;
import com.movelo.moveloapp.gestores.GestorProxy;
import com.movelo.moveloapp.gestores.GestorHuellaCarbono;
import com.movelo.moveloapp.gestores.GestorRecorrido;
import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.Recorrido;
import com.movelo.moveloapp.models.RegistroGeografico;
import com.movelo.moveloapp.models.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.CoreConstants;

@Component
public class FacadeGestores {

    @Autowired
    private GestorBiciusuario gestBiciUsuario;
    @Autowired
    private GestorRecorrido gestorRecorrido;

    @Autowired
    private GestorArboles gestArboles;
    private GestorHuellaCarbono gestorHuellaCarbono;

    @Autowired
    private GestorHuella gestHuella;

    public boolean agregarBiciusuario(Biciusuario usuario) {
        return gestBiciUsuario.agregarBiciusuario(usuario);
    }

    public boolean finalizarRecorrido(List<RegistroGeografico> listaPuntos, Double distanciaTotal,
            Biciusuario usuario) {
        return gestorRecorrido.finalizarRecorrido(listaPuntos, distanciaTotal, usuario);
    }

    private Arbol getArbol(Double precio) {
        return gestArboles.getArbol(precio);
    }

    public List<Arbol> getArbolesPorUsuario(Biciusuario usuario) {
        return gestArboles.getArbolesPorUsuario(usuario);
    }

    public boolean actualizarDistancia(String correo, Double kmRecorridos) {
        Double nuevaDistancia = gestBiciUsuario.actualizarDistanciaReco(correo, kmRecorridos);
        if (nuevaDistancia != null) {
            System.out.println(getArbol(nuevaDistancia));
            return true;
        }
        return false;
    }

    public boolean actualizarHuella(String correo, Double kmRecorridos) {
        Double nuevaHuella = gestHuella.actualizarHuella(correo, kmRecorridos);
        if (nuevaHuella != null) {
            System.out.println(nuevaHuella);
            return true;
        }
        return false;
    }

    public GestorBiciusuario getGestBiciUsuario() {
        return gestBiciUsuario;
    }

    public void setGestBiciUsuario(GestorBiciusuario gestBiciUsuario) {
        this.gestBiciUsuario = gestBiciUsuario;
    }

    public int getCantiArboles(Biciusuario usuario) {
        return gestArboles.getCantiArboles(usuario);
    }

    public List<Arbol> getTodosArboles() {
        return gestArboles.getArbolesTodos();
    }

    public double calcularHuellaTotal(Biciusuario ciclista) {
        double huella = gestorHuellaCarbono.calcularHuellaTotal(ciclista.getkmRecorridos());
        actualizarHuella(ciclista, huella);
        return huella;
    }

    public void actualizarHuella(Biciusuario ciclista, double huella) {
        gestBiciUsuario.actualizarHuella(ciclista, huella);
    }

    public double calcularHuellaRecorrido(Recorrido recorrido) {
        double huella = gestorHuellaCarbono.calcularHuellaRecorrido(recorrido);
        return huella;
    }

    public boolean anadirArbol(Biciusuario usuario, Double precio) {
        return gestArboles.anadirArbol(usuario, precio);
    }
}
