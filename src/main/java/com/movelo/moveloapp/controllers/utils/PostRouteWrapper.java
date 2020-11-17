package com.movelo.moveloapp.controllers.utils;

import java.util.List;

import com.movelo.moveloapp.models.RegistroGeografico;

public class PostRouteWrapper {
    List<RegistroGeografico> points;
    Double totalDistance;

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

    public PostRouteWrapper(List<RegistroGeografico> points, Double totalDistance) {
        this.points = points;
        this.totalDistance = totalDistance;
    }

}
