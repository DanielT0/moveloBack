package com.movelo.moveloapp.gestores;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;

public class GestorBiciusuario {

    @Autowired
    private BiciusuarioService service;

    public Boolean agregarBiciusuario(Biciusuario usuario) {
        boolean checked = service.checkUser(usuario);
        Biciusuario saved = null;
        if (checked) {
            saved = service.save(usuario);
        }
        return checked;
    }

}
