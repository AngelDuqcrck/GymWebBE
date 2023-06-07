package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymbe.powergymweb.Entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    Rol findByDescripcion(String descripcion);
}
