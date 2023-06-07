package com.gymbe.powergymweb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gymbe.powergymweb.Entity.Plan;
import java.util.Optional;



public interface PlanRepository extends JpaRepository<Plan, Integer> {
    Plan findByNombre(String nombre);
    Optional<Plan> findById(int id);
}
