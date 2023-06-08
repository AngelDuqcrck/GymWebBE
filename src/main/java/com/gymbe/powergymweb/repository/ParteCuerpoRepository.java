package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gymbe.powergymweb.Entity.ParteCuerpo;
import java.util.List;
import java.util.Optional;



public interface ParteCuerpoRepository  extends JpaRepository<ParteCuerpo, Integer>{
    ParteCuerpo findByDescripcion(String descripcion);
    Optional<ParteCuerpo> findById(int id);
}
