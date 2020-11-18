package com.movelo.moveloapp.services;

import java.util.Optional;

import com.movelo.moveloapp.models.Biciusuario;

public interface BiciusuarioService {

    public Optional<Biciusuario> findByEmail(String email);

    public Biciusuario save(Biciusuario Biciusuario);

    public boolean deleteByEmail(String email);

    public Boolean checkUser(Biciusuario rider);

    public Double actualizarKm(String correo, Double kmReco);

    public Double actualizarHuella(String correo, Double huellaNueva);
    public Boolean checkUpdateHuella(Biciusuario rider, double huella);
}
