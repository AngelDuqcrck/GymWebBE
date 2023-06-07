package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Plan;
import com.gymbe.powergymweb.repository.PlanRepository;
import com.gymbe.powergymweb.service.interfaces.PlanServiceInterface;
import com.gymbe.powergymweb.shared.dto.PlanDTO;

@Service("planService")
public class PlanService implements PlanServiceInterface {
    
    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<PlanDTO> listarPlanes() {
        List<Plan> planEntities = planRepository.findAll();
        return planEntities.stream()
                .map(this::convertToPlanDTO)
                .collect(Collectors.toList());
    }
    

    private PlanDTO convertToPlanDTO(Plan planEntity) {
        PlanDTO planDTO = new PlanDTO();
        planDTO.setNombre(planEntity.getNombre());
        planDTO.setDescripcion(planEntity.getDescripcion());
        planDTO.setPrecio(planEntity.getPrecio());
        return planDTO;
    }
}
