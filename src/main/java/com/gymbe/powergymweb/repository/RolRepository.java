package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
}
