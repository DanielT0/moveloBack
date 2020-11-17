package com.movelo.moveloapp.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.movelo.moveloapp.models.Recorrido;
import com.movelo.moveloapp.repositories.RutaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RutaServiceImpl implements RutaService {

    @Autowired
    private RutaRepository repo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Recorrido save(Recorrido recorrido) {
        return repo.save(recorrido);
    }

}
