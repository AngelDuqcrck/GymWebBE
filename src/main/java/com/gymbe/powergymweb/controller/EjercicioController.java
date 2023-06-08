package com.gymbe.powergymweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.repository.EjercicioRepository;
import com.gymbe.powergymweb.service.implementations.EjercicioService;
import com.gymbe.powergymweb.shared.dto.EjercicioDTO;

@RestController
@RequestMapping("/ejercicio")
public class EjercicioController {
    @Autowired
    EjercicioService ejercicioService;


    @GetMapping
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<List<EjercicioDTO>> listarPlanes() {
        return new ResponseEntity<>(ejercicioService.listarEjercicios(), HttpStatus.OK);
    }
    
}
