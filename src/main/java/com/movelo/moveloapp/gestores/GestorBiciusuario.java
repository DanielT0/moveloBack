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
        Biciusuario saved = null;
        if (checked) {
            saved = service.save(usuario);
        }
        return checked;
    }

    public Boolean actualizarHuella(Biciusuario ciclista, double huellaTotal){
        boolean check = service.checkUpdateHuella(ciclista,huellaTotal);
        return check;
    }

    public BiciusuarioService getService() {
        return service;
    }

    public Double actualizarDistanciaReco(String correo, Double kmRecorridos) {
        Double nuevaDistancia = service.actualizarKm(correo, kmRecorridos);
        return nuevaDistancia;
    }
    public void setService(BiciusuarioService service) {
        this.service = service;
    }

}
