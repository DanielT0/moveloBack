package com.movelo.moveloapp.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "recorrido")
public class Recorrido implements Serializable {
    @Column(length = 50, nullable = false, unique = true)
    private boolean isInRuta;

    @Column(length = 50, nullable = false, unique = true)
    private Double distanciaTotal;

    private Long id;

    /*
     * @OneToOne
     * 
     * @JoinColumn(name = "usuario_id") private Biciusuario usuario;
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroGeografico> registro = new ArrayList<RegistroGeografico>();
    /*
     * @OneToOne
     * 
     * @JoinColumn(name = "incidente_id") private RegistroGeografico incidente;
     */

    public boolean guardarRegistro() {
        return false;
    }

    public void reportarIncidente() {

    }

    public RegistroGeografico obtenerRegistroFinal() {
        return registro.get(registro.size() - 1);
    }

    public RegistroGeografico obtenerRegistroIncial() {
        return registro.get(0);
    }
    /*
     * public Biciusuario getUsuario() { return usuario; }
     * 
     * public void setUsuario(Biciusuario usuario) { this.usuario = usuario; }
     */

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

    /*
     * public RegistroGeografico getIncidente() { return incidente; }
     * 
     * public void setIncidente(RegistroGeografico incidente) { this.incidente =
     * incidente; }
     */

    public Double getDistanciaTotal() {
        return distanciaTotal;
    }

    public void setDistanciaTotal(Double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }

    public Recorrido(Biciusuario usuario, List<RegistroGeografico> listaPuntos, boolean isInRuta,
            RegistroGeografico incidente, Double distanciaTotal) {
        // this.usuario = usuario;
        for (RegistroGeografico registro : listaPuntos) {
            registro.setOwner(this);
            this.registro.add(registro);
        }
        this.isInRuta = isInRuta;
        // this.incidente = incidente;
        this.distanciaTotal = distanciaTotal;
    }

    public Recorrido(Biciusuario usuario, List<RegistroGeografico> listaPuntos, Double distanciaTotal) {
        // this.usuario = usuario;
        for (RegistroGeografico registro : listaPuntos) {
            registro.setOwner(this);
            this.registro.add(registro);
        }
        this.registro = listaPuntos;
        this.isInRuta = false;
        // this.incidente = null;
        this.distanciaTotal = distanciaTotal;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recorrido() {
    }

}
