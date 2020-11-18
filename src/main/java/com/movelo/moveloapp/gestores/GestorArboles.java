package com.movelo.moveloapp.gestores;

import java.util.List;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.ArbolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorArboles {
    @Autowired
    private ArbolService service;

    public Arbol getArbol(Long id) {
        return null;
    }

    public Arbol getArbol(Double precio) {
        return service.getArbol(precio);
    }

    public List<Arbol> getArbolesPorUsuario(Biciusuario usuario) {
        return service.getArbolesUsuario(usuario);
    }
}
