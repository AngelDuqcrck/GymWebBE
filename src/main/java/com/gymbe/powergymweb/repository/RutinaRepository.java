package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.Rutina;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, Integer> {
    
}
