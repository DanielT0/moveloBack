package com.movelo.moveloapp.repositories;

import com.movelo.moveloapp.models.Recorrido;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RutaRepository extends JpaRepository<Recorrido, Long> {

}
