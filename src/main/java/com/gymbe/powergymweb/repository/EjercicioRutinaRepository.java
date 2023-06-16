package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.EjercicioRutina;

@Repository
public interface EjercicioRutinaRepository extends JpaRepository<EjercicioRutina, Integer> {
    
}

