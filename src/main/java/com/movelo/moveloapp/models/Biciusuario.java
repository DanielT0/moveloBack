package com.movelo.moveloapp.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "biciusuario")
public class Biciusuario extends Usuario {
    @Column(length = 50, nullable = false, unique = true)
    private String cc;
    @Column(length = 50, nullable = false, unique = true)
    private String nombre;

    @Column(length = 50, nullable = false, unique = true)
    private String direccion;
    @Column(length = 50, nullable = false, unique = true)
    private String telefono;
    @Column(nullable = false)
    private Double huellaCarbonoAcumulada;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PuntoGeografico> ContribuitedTrees;
    @Column(nullable = false)
    private int metrosNoPlantados;
    @Column(nullable = false)
    private Double kmRecorridos;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Arbol> arboles = new ArrayList<>();

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

    public Double getkmRecorridos() {
        return kmRecorridos;
    }

    public void setkmRecorridos(Double kmRecorridos) {
        this.kmRecorridos = kmRecorridos;
    }

    public Biciusuario() {
        this.huellaCarbonoAcumulada = 0.0;
        this.metrosNoPlantados = 0;
        this.kmRecorridos = 0.0;
    }

    public Biciusuario(String cc, String nombre, String direccion, String telefono, String correo, String password) {
        super(correo, password);
        this.cc = cc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.huellaCarbonoAcumulada = 0.0;
        this.metrosNoPlantados = 0;
        this.kmRecorridos = 0.0;
        ContribuitedTrees = new ArrayList<>();
    }

    public Biciusuario(String cc, String nombre, String direccion, String telefono, String correo, String password,
            Double huella, Double kmReco) {
        super(correo, password);
        this.cc = cc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.huellaCarbonoAcumulada = huella;
        this.metrosNoPlantados = 0;
        this.kmRecorridos = kmReco;
        ContribuitedTrees = new ArrayList<>();
    }

    public void addArbol(Arbol arb) {
        this.arboles.add(arb);
    }

}
