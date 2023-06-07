package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.MusculoObjetivo;

@Repository
public interface MusculoObjetivoRepository extends JpaRepository<MusculoObjetivo, Integer>{
    
}
