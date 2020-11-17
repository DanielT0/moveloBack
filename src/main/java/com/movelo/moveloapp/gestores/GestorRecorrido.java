package com.movelo.moveloapp.gestores;

import java.util.List;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.Recorrido;
import com.movelo.moveloapp.models.RegistroGeografico;
import com.movelo.moveloapp.services.RutaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorRecorrido {

    @Autowired
    private RutaService service;

    public boolean finalizarRecorrido(List<RegistroGeografico> listaPuntos, Double distanciaTotal,
            Biciusuario usuario) {
        Recorrido nuevo = new Recorrido(usuario, listaPuntos, distanciaTotal);
        nuevo = service.save(nuevo);
        boolean saved = false;
        if (nuevo != null)
            saved = true;
        return saved;

    }
}
