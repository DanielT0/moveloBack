package com.movelo.moveloapp.services;

import java.util.Optional;

import com.movelo.moveloapp.models.BikeRider;

public interface BikeRiderService {

    public Optional<BikeRider> findByEmail(String email);

    public BikeRider save(BikeRider bikeRider);

    public boolean deleteByEmail(String email);
}
