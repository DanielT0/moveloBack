package com.movelo.moveloapp.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bikeriders")
public class BikeRider implements Serializable {
    @Column(length = 50, nullable = false, unique = true)
    private String id;
    // private ArrayList<Bicicleta> bikes;
    @Column(length = 50, nullable = false, unique = true)
    private String name;
    @Id
    private String email;
    @Column(nullable = false, unique = true)
    private String address;
    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false)
    private Double carbonFPrint;
    // private List<GeoPoint> ContribuitedTrees;
    @Column(nullable = false)
    private int noPlantedMtrs;
    @Column(nullable = false)
    private int travelledMtrs;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getCarbonFPrint() {
        return this.carbonFPrint;
    }

    public void setCarbonFPrint(Double carbonFPrint) {
        this.carbonFPrint = carbonFPrint;
    }

    public int getNoPlantedMtrs() {
        return this.noPlantedMtrs;
    }

    public void setNoPlantedMtrs(int noPlantedMtrs) {
        this.noPlantedMtrs = noPlantedMtrs;
    }

    public int getTravelledMtrs() {
        return this.travelledMtrs;
    }

    public void setTravelledMtrs(int travelledMtrs) {
        this.travelledMtrs = travelledMtrs;
    }

}
