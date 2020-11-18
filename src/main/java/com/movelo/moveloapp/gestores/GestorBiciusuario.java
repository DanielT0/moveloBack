package com.movelo.moveloapp.gestores;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorBiciusuario {

    @Autowired
    private BiciusuarioService service;

    public Boolean agregarBiciusuario(Biciusuario usuario) {
        boolean checked = service.checkUser(usuario);
        boolean saved = false;
        Biciusuario obj = null;
        if (checked) {
            obj = service.save(usuario);
        }
        if (obj != null) {
            saved = true;
        }
        return saved;
    }
}
