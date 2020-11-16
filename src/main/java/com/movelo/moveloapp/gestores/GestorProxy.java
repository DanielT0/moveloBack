package com.movelo.moveloapp.gestores;

import java.util.List;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.Usuario;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;

public class GestorProxy {

    List<Usuario> usuarios;
    @Autowired
    private BiciusuarioService service;

    public List<Object> registerBiciusuario(Biciusuario usuario) {
        boolean checked = service.checkUser(usuario);
        Biciusuario saved = null;
        String message = "";
        if (checked) {
            saved = service.save(usuario);
        }
        return null;
    }
}
