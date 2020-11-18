package com.movelo.moveloapp.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.repositories.BiciusuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiciusuarioServiImpl implements BiciusuarioService {

    @Autowired
    private BiciusuarioRepository repo;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean deleteByEmail(String email) {
        repo.deleteById(email);
        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Biciusuario> findByEmail(String email) {

        return repo.findById(email);
    }

    @Override
    @Transactional
    public Biciusuario save(Biciusuario rider) {
        int idupNow = getLastId();
        rider.setId(idupNow + 1);
        return repo.save(rider);
    }

    @Override
    @Transactional
    public Boolean checkUser(Biciusuario rider) {
        boolean checked = false;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("userRegister");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(5, Integer.class, ParameterMode.OUT);

        query.setParameter(1, rider.getNombre());
        query.setParameter(2, rider.getCorreo());
        query.setParameter(3, rider.getDireccion());
        query.setParameter(4, rider.getTelefono());

        query.execute();

        Integer response = (Integer) query.getOutputParameterValue(5);
        if (response == 1)
            checked = true;
        return checked;
    }

    @Transactional
    private Integer getLastId() {

        Integer lastId = 0;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getNumberUser");
        query.registerStoredProcedureParameter(1, Integer.class, ParameterMode.OUT);
        query.execute();

        Integer response = (Integer) query.getOutputParameterValue(1);
        if (response > 0)
            lastId = response;
        return lastId;
    }

    public Boolean checkUpdateHuella(Biciusuario rider, double huella){
        double actual = rider.getHuellaCarbonoAcumulada();
        double huellaTotal = huella + actual;
        rider.setHuellaCarbonoAcumulada(huellaTotal);
        return true;
    }

}
