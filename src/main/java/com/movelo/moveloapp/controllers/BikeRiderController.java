package com.movelo.moveloapp.controllers;

import java.util.Optional;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.services.BikeRiderService;

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
public class BikeRiderController {

    @Autowired
    private BikeRiderService service;

    @PostMapping
    public ResponseEntity<?> createRider(@RequestBody Biciusuario rider) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rider));
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
