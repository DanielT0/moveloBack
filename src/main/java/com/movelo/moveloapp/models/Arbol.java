package com.movelo.moveloapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "arbol")
public class Arbol {
    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 50, nullable = false, unique = true)
    private String nombre;
    @Column(length = 50, nullable = false, unique = true)
    private String nombreCientifi;
    @NaturalId(mutable = false)
    @ColumnDefault("200")
    private Double precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifi() {
        return nombreCientifi;
    }

    public void setNombreCientifi(String nombreCientifi) {
        this.nombreCientifi = nombreCientifi;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Arbol() {
    }

    public Arbol(String nombre, String nombreCientifi, Double precio) {
        this.nombre = nombre;
        this.nombreCientifi = nombreCientifi;
        this.precio = precio;
    }

}
