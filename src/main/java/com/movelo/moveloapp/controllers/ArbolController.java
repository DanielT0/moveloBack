package com.movelo.moveloapp.controllers;

import java.util.List;

import com.movelo.moveloapp.gestores.GestorProxy;
import com.movelo.moveloapp.models.Arbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/arboles")
public class ArbolController {
    @Autowired
    private GestorProxy proxy;

    @GetMapping
    public ResponseEntity<?> getArbolesByUser(@RequestParam(value = "email") String correo) {
        List<Arbol> arboles = proxy.getArbolesPorUsuario(correo);
        if (arboles == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arboles);
    }
}
