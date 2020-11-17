package com.movelo.moveloapp.models;

import java.util.List;

public class Recorrido {

    private Biciusuario usuario;
    private List<RegistroGeografico> registro;
    private boolean isInRuta;
    private RegistroGeografico incidente;
    private Double distanciaTotal;

    public boolean guardarRegistro() {
        return false;
    }

    public void reportarIncidente() {

    }

    public RegistroGeografico obtenerRegistroIncial() {
        return null;
    }

    public Biciusuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Biciusuario usuario) {
        this.usuario = usuario;
    }

    public List<RegistroGeografico> getRegistro() {
        return registro;
    }

    public void setRegistro(List<RegistroGeografico> registro) {
        this.registro = registro;
    }

    public boolean isInRuta() {
        return isInRuta;
    }

    public void setInRuta(boolean isInRuta) {
        this.isInRuta = isInRuta;
    }

    public RegistroGeografico getIncidente() {
        return incidente;
    }

    public void setIncidente(RegistroGeografico incidente) {
        this.incidente = incidente;
    }

    public Double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(Double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

}
