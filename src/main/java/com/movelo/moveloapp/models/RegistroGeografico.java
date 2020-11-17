package com.movelo.moveloapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "recorrido")
public class RegistroGeografico extends PuntoGeografico {

    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String timeStamp;

    @ManyToOne
    private Recorrido owner;
    /*
     * @OneToOne(mappedBy = "incidente") private Recorrido recorrido;
     */

    public RegistroGeografico(Double lat, Double lon, String timeStamp) {
        super(lat, lon);
        this.timeStamp = timeStamp;
    }

    public Recorrido getOwner() {
        return owner;
    }

    public void setOwner(Recorrido owner) {
        this.owner = owner;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public RegistroGeografico() {

    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
