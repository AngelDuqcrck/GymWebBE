package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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

    /**
     * Servicio para listar todos los planes.
     *
     * @return Una lista de objetos PlanDTO que representa los planes.
     */
    @Override
    public List<PlanDTO> listarPlanes() {
        List<Plan> planEntities = planRepository.findAll();
        return planEntities.stream()
                .map(this::convertToPlanDTO)
                .collect(Collectors.toList());
    }

    /**
     * Servicio para actualizar un plan
     *
     * @param planId  El ID del plan que se va a actualizar.
     * @param planDTO El objeto PlanDTO con los nuevos datos del plan.
     * @return El objeto PlanDTO actualizado.
     * @throws RuntimeException Si no se encuentra el plan con el ID especificado.
     */
    @Override
    public PlanDTO actualizarPlan(Integer planId, PlanDTO planDTO) {
        Plan planExistente = planRepository.findById(planId)
                .orElseThrow(() -> new RuntimeException("No se encontró el plan con el ID: " + planId));

        planExistente.setDescripcion(planDTO.getDescripcion());
        planExistente.setPrecio(planDTO.getPrecio());

        Plan planActualizado = planRepository.save(planExistente);

        PlanDTO planActualizadoDTO = new PlanDTO();
        BeanUtils.copyProperties(planActualizado, planActualizadoDTO);

        return planActualizadoDTO;
    }

    /**
     * Convierte un objeto Plan en un objeto PlanDTO.
     *
     * @param planEntity El objeto Plan que se va a convertir.
     * @return El objeto PlanDTO resultante.
     */
    private PlanDTO convertToPlanDTO(Plan planEntity) {
        PlanDTO planDTO = new PlanDTO();
        planDTO.setNombre(planEntity.getNombre());
        planDTO.setDescripcion(planEntity.getDescripcion());
        planDTO.setPrecio(planEntity.getPrecio());
        return planDTO;
    }
}
