package com.movelo.moveloapp.controllers;

import com.movelo.moveloapp.controllers.utils.PostRouteWrapper;
import com.movelo.moveloapp.gestores.GestorProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routes")
public class RutasController {
    @Autowired
    private GestorProxy proxy;

    @PostMapping
    public ResponseEntity<?> saveRoute(@RequestBody PostRouteWrapper wrapper) {
        boolean saved = proxy.finalizarRecorrido(wrapper.getPoints(), wrapper.getTotalDistance());
        String message = "la ruta fue guardada satisfactoriamente";
        HttpStatus status = HttpStatus.CREATED;
        if (!saved) {
            message = "No se pudo guardar la ruta";
            status = HttpStatus.CONFLICT;
        }
        return ResponseEntity.status(status).body(message);
    }
}
