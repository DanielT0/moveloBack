package com.movelo.moveloapp.facade;

import com.movelo.moveloapp.gestores.GestorBiciusuario;
import com.movelo.moveloapp.models.Biciusuario;

public class FacadeGestores {

    private GestorBiciusuario gestBiciUsuario;

    public boolean agregarBiciusuario(Biciusuario usuario) {
        return gestBiciUsuario.agregarBiciusuario(usuario);
    }

    public FacadeGestores() {
        gestBiciUsuario = new GestorBiciusuario();
    }
}
