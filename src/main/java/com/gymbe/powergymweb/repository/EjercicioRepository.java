package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymbe.powergymweb.Entity.Ejercicio;
import java.util.Optional;
import java.util.List;



public interface EjercicioRepository  extends JpaRepository<Ejercicio, Integer>{
    
    Optional<Ejercicio> findById(int id);
    
    Ejercicio findByDescripcion(String descripcion);
}
