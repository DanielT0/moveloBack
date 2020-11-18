package com.movelo.moveloapp.facade;

import java.util.List;

import com.movelo.moveloapp.gestores.GestorArboles;
import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.gestores.GestorRecorrido;
import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
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

    private Arbol getArbol(Double precio) {
        return gestArboles.getArbol(precio);
    }

    public List<Arbol> getArbolesPorUsuario(Biciusuario usuario) {
        return gestArboles.getArbolesPorUsuario(usuario);
    }

    public boolean actualizarDistancia(String correo, Double kmRecorridos) {
        Double nuevaDistancia = gestBiciUsuario.actualizarDistanciaReco(correo, kmRecorridos);
        System.out.println(getArbol(nuevaDistancia));
        return true;
    }

}
