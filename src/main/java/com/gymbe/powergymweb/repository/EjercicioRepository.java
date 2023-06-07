package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.Ejercicio;

@Repository
public interface EjercicioRepository  extends JpaRepository<Ejercicio, Integer>{
    
}
