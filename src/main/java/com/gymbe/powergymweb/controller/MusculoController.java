package com.gymbe.powergymweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.gymbe.powergymweb.service.implementations.MusculoService;
import com.gymbe.powergymweb.shared.dto.MusculoDTO;

@RestController
@RequestMapping("/musculoObjetivo")
public class MusculoController {
    
    @Autowired
    private MusculoService musculoService;

    @GetMapping
    public ResponseEntity<List<MusculoDTO>> listarMusculos() {
        return new ResponseEntity<>(musculoService.listarMusculos(), HttpStatus.OK);
    }

}
