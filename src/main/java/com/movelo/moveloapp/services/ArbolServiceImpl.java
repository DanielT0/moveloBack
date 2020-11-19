package com.movelo.moveloapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.db.ArbolBiciusuario;
import com.movelo.moveloapp.repositories.ArbolRepository;
import com.movelo.moveloapp.repositories.ArbolUsuarioRepository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArbolServiceImpl implements ArbolService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ArbolUsuarioRepository repoArbolUsuario;
    @Autowired
    private ArbolRepository repoArbol;

    @Override
    public Arbol getArbol(Double precio) {
        Arbol arbol = entityManager.unwrap(Session.class).bySimpleNaturalId(Arbol.class).load(precio);
        return arbol;
    }

    @Override
    public List<Arbol> getArbolesUsuario(Biciusuario usuario) {

        Optional<List<ArbolBiciusuario>> arbolesUsua = Optional
                .ofNullable(repoArbolUsuario.getArbolesPorUsuario(usuario));
        if (arbolesUsua.isPresent()) {
            List<Arbol> arboles = new ArrayList<>();
            for (ArbolBiciusuario arbolUsua : arbolesUsua.get()) {
                arboles.add(arbolUsua.getArbol());
            }
            return arboles;
        }
        return null;
    }

    @Override
    public List<Arbol> getTodosArboles() {
        List<Arbol> arboles = repoArbol.findAll();
        return arboles;
    }

    @Override
    public ArbolBiciusuario anadirArbol(ArbolBiciusuario arbolUsuario) {
        return repoArbolUsuario.save(arbolUsuario);
    }

}
