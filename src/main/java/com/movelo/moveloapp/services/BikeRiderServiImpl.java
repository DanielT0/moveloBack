package com.movelo.moveloapp.services;

import java.util.Optional;

import com.movelo.moveloapp.models.BikeRider;
import com.movelo.moveloapp.repositories.BikeRiderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BikeRiderServiImpl implements BikeRiderService {

    @Autowired
    private BikeRiderRepository repo;

    @Override
    @Transactional
    public boolean deleteByEmail(String email) {
        repo.deleteById(email);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BikeRider> findByEmail(String email) {

        return repo.findById(email);
    }

    @Override
    @Transactional
    public BikeRider save(BikeRider bikeRider) {

        return repo.save(bikeRider);
    }

}
