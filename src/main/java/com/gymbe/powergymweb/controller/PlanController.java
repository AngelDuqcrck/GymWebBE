package com.gymbe.powergymweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.service.implementations.PlanService;
import com.gymbe.powergymweb.shared.dto.PlanDTO;

@RestController
@RequestMapping("/plan")
public class PlanController {
    
    @Autowired
    private PlanService planService;

    @GetMapping
    public ResponseEntity<List<PlanDTO>> listarPlanes(){
        return new ResponseEntity<>(planService.listarPlanes(), HttpStatus.OK);
    }
}
