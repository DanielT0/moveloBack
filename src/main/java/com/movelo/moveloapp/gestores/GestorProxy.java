package com.movelo.moveloapp.gestores;

import java.util.List;
import java.util.Optional;

import com.movelo.moveloapp.facade.FacadeGestores;
import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.RegistroGeografico;
import com.movelo.moveloapp.services.BiciusuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GestorProxy {

    @Autowired
    private FacadeGestores facadeGestores;
    @Autowired
    private BiciusuarioService service;
    private Biciusuario usuarioActual;

    public boolean registerBiciusuario(Biciusuario usuario) {
        return facadeGestores.agregarBiciusuario(usuario);
    }

    public Biciusuario login(String email, String pass) {
        Optional oRider = service.findByEmail(email);
        Biciusuario user = null;
        if (oRider.isPresent()) {
            user = (Biciusuario) oRider.get();
            if (!(user.getCorreo().equals(email) && user.getPassword().equals(pass))) {
                user = null;
            } else {
                usuarioActual = user;
            }
        }
        return user;
    }

    public boolean finalizarRecorrido(List<RegistroGeografico> listaPuntos, Double distanciaTotal) {
        return facadeGestores.finalizarRecorrido(listaPuntos, distanciaTotal, usuarioActual);
    }

    public List<Arbol> getArbolesPorUsuario(String correo) {
        return facadeGestores.getArbolesPorUsuario(usuarioActual);
    }

    public boolean actualizarDistancia(String correo, Double kmRecorridos) {
        return facadeGestores.actualizarDistancia(correo, kmRecorridos);
    }
    public double huella(Biciusuario rider, double huella){
        facadeGestores.calcularHuellaTotal(rider);
        return huella;
    }

}
