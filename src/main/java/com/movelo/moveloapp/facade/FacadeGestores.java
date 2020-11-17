package com.movelo.moveloapp.facade;

import java.util.List;

import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.gestores.GestorRecorrido;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.RegistroGeografico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacadeGestores {

    @Autowired
    private GestorBiciusuario gestBiciUsuario;
    @Autowired
    private GestorRecorrido gestorRecorrido;

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
}
