package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import com.gymbe.powergymweb.shared.dto.PlanDTO;

public interface PlanServiceInterface {
    
    public List<PlanDTO> listarPlanes();

    public PlanDTO actualizarPlan(Integer planId, PlanDTO planDTO);
}