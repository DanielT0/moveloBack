package com.movelo.moveloapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "biciusuario")
public class Biciusuario extends Usuario {
    @Column(length = 50, nullable = false, unique = true)
    private String cc;
    // private ArrayList<Bicicleta> bikes;
    @Column(length = 50, nullable = false, unique = true)
    private String nombre;
    @Column(nullable = false, unique = true)
    private String direccion;
    @Column(nullable = false, unique = true)
    private String telefono;
    @Column(nullable = false)
    private Double huellaCarbonoAcumulada;
    // private List<GeoPoint> ContribuitedTrees;
    @Column(nullable = false)
    private int metrosNoPlantados;
    @Column(nullable = false)
    private int metrosRecorridos;

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getHuellaCarbonoAcumulada() {
        return huellaCarbonoAcumulada;
    }

    public void setHuellaCarbonoAcumulada(Double huellaCarbonoAcumulada) {
        this.huellaCarbonoAcumulada = huellaCarbonoAcumulada;
    }

    public int getMetrosNoPlantados() {
        return metrosNoPlantados;
    }

    public void setMetrosNoPlantados(int metrosNoPlantados) {
        this.metrosNoPlantados = metrosNoPlantados;
    }

    public int getMetrosRecorridos() {
        return metrosRecorridos;
    }

    public void setMetrosRecorridos(int metrosRecorridos) {
        this.metrosRecorridos = metrosRecorridos;
    }

    public Biciusuario() {
        this.huellaCarbonoAcumulada = 0.0;
        this.metrosNoPlantados = 0;
        this.metrosRecorridos = 0;
    }

    public Biciusuario(String cc, String nombre, String direccion, String telefono, String correo, String password) {
        super(correo, password);
        this.cc = cc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.huellaCarbonoAcumulada = 0.0;
        this.metrosNoPlantados = 0;
        this.metrosRecorridos = 0;
    }

}
