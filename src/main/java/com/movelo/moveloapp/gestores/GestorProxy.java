package com.movelo.moveloapp.gestores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.movelo.moveloapp.facade.FacadeGestores;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorProxy {

    @Autowired
    private FacadeGestores facadeGestores;
    @Autowired
    private BiciusuarioService service;

    public boolean registerBiciusuario(Biciusuario usuario) {
        return facadeGestores.agregarBiciusuario(usuario);
    }

    public Biciusuario login(String email, String pass) {
        Optional oRider = service.findByEmail(email);
        Biciusuario user = null;
        if (oRider.isPresent()) {
            user = (Biciusuario) oRider.get();
            if (!(user.getCorreo().equals(email) && user.getPassword().equals(pass))) {
                user = null;
            }
        }
        return user;
    }

    public FacadeGestores getFacadeGestores() {
        return facadeGestores;
    }

    public void setFacadeGestores(FacadeGestores facadeGestores) {
        this.facadeGestores = facadeGestores;
    }
}
