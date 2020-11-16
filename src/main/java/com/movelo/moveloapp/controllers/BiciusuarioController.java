package com.movelo.moveloapp.controllers;

import java.util.Optional;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bikeriders")
public class BiciusuarioController {

    @Autowired
    private BiciusuarioService service;

    @PostMapping
    public ResponseEntity<?> createRider(@RequestBody Biciusuario rider) {
        boolean checked = service.checkUser(rider);
        Biciusuario save = null;
        HttpStatus status = HttpStatus.CREATED;
        if (!checked) {
            status = HttpStatus.CONFLICT;
            return ResponseEntity.status(status).body("El usuario tiene un atributo que ya existe");
        } else {
            save = service.save(rider);
        }
        return ResponseEntity.status(status).body(save);
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable(value = "email") String email) {
        Optional oRider = service.findByEmail(email);

        if (!oRider.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oRider);
    }

}
