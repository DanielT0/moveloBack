package com.movelo.moveloapp.models;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class PuntoGeografico implements Serializable {

    private Double latitude;
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public PuntoGeografico(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PuntoGeografico() {
    }

}
