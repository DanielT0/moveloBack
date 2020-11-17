package com.movelo.moveloapp.facade;

import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.models.Biciusuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacadeGestores {

    @Autowired
    private GestorBiciusuario gestBiciUsuario;

    public boolean agregarBiciusuario(Biciusuario usuario) {
        return gestBiciUsuario.agregarBiciusuario(usuario);
    }

    public GestorBiciusuario getGestBiciUsuario() {
        return gestBiciUsuario;
    }

    public void setGestBiciUsuario(GestorBiciusuario gestBiciUsuario) {
        this.gestBiciUsuario = gestBiciUsuario;
    }
}
