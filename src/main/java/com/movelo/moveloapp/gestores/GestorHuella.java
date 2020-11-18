package com.movelo.moveloapp.gestores;

import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorHuella {
    @Autowired
    private BiciusuarioService service;

    private Double gCO2PorKmCarro = 404 / 1.60934;

    private Double gCO2PorKmBicicleta = 65.0;

    public Double actualizarHuella(String correo, Double kmRecorridos) {
        Double nuevaHuella = service.actualizarHuella(correo, kmRecorridos * gCO2PorKmBicicleta);
        return nuevaHuella;
    }

}
