package com.movelo.moveloapp.controllers.utils;

import java.util.List;

import com.movelo.moveloapp.models.RegistroGeografico;

public class PostRouteWrapper {
    List<RegistroGeografico> points;
    Double totalDistance;
    String email;

    public List<RegistroGeografico> getPoints() {
        return points;
    }

    public void setPoints(List<RegistroGeografico> points) {
        this.points = points;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PostRouteWrapper(List<RegistroGeografico> points, Double totalDistance, String email) {
        this.points = points;
        this.totalDistance = totalDistance;
        this.email = email;
    }

}
