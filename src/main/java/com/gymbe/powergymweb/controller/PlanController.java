package com.gymbe.powergymweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.models.requests.PlanRequest;
import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.service.implementations.PlanService;
import com.gymbe.powergymweb.shared.dto.PlanDTO;

@RestController
@RequestMapping("/plan")
public class PlanController {
    
    @Autowired
    private PlanService planService;

    /**
     * Endpoint para obtener una lista de todos los planes.
     *
     * @return ResponseEntity con una lista de objetos PlanDTO y HttpStatus OK si la
     *         solicitud es exitosa.
     */
    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<PlanDTO>> listarPlanes() {
        return new ResponseEntity<>(planService.listarPlanes(), HttpStatus.OK);
    }

    /**
     * Endpoint para actualizar un plan existente.
     *
     * @param planId      El ID del plan que se va a actualizar.
     * @param planRequest El objeto PlanRequest con los nuevos datos del plan.
     * @return Un objeto MensajeResponse con un mensaje indicando si la
     *         actualización se realizó con éxito o si ocurrió un error.
     */
    @PutMapping
    public MensajeResponse actualizarPlan(@RequestParam Integer planId, @RequestBody @Valid PlanRequest planRequest) {

        PlanDTO planDTO = new PlanDTO();
        BeanUtils.copyProperties(planRequest, planDTO);

        PlanDTO planActualizado = planService.actualizarPlan(planId, planDTO);

        if (planActualizado != null) {
            return new MensajeResponse("Plan actualizado con éxito");
        } else {
            return new MensajeResponse("Error al actualizar el plan");
        }
    }
}
