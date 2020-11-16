package com.movelo.moveloapp.gestores;

import java.util.ArrayList;
import java.util.List;

import com.movelo.moveloapp.facade.FacadeGestores;
import com.movelo.moveloapp.models.Biciusuario;

public class GestorProxy {

    private FacadeGestores facadeGestores;

    public boolean registerBiciusuario(Biciusuario usuario) {
        return facadeGestores.agregarBiciusuario(usuario);
    }

    public GestorProxy() {
        facadeGestores = new FacadeGestores();
    }
}
