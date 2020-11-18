package com.movelo.moveloapp.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap<String, List<Arbol>> arbolMap = new HashMap<>();
        arbolMap.put("arboles", arboles);
        if (arboles == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arbolMap);
    }

    @GetMapping("/todos")
    public ResponseEntity<?> getArbolesTodos() {
        List<Arbol> arboles = proxy.getTodosArbol();
        HashMap<String, List<Arbol>> arbolMap = new HashMap<>();
        arbolMap.put("arboles", arboles);
        if (arboles == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(arbolMap);
    }
}
