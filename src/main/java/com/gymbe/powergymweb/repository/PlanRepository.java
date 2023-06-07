package com.gymbe.powergymweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymbe.powergymweb.Entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {
    
}
