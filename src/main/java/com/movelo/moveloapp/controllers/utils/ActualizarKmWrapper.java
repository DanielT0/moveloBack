package com.movelo.moveloapp.controllers.utils;

public class ActualizarKmWrapper {
    String email;
    Double distance;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public ActualizarKmWrapper(String email, Double distance) {
        this.email = email;
        this.distance = distance;
    }

}
