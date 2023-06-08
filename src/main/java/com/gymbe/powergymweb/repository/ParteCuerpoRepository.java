package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.ParteCuerpo;


public interface ParteCuerpoRepository  extends JpaRepository<ParteCuerpo, Integer>{
    
}
