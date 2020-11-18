package com.movelo.moveloapp.repositories;

import java.util.List;

import com.movelo.moveloapp.models.Arbol;
import com.movelo.moveloapp.models.Biciusuario;
import com.movelo.moveloapp.models.db.ArbolBiciusuario;
import com.movelo.moveloapp.models.db.ArbolUsuarioId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArbolRepository extends JpaRepository<ArbolBiciusuario, ArbolUsuarioId> {

    @Query("select a from ArbolBiciusuario a where a.usuario = ?1")
    public List<ArbolBiciusuario> getArbolesPorUsuario(Biciusuario usuario);
}
