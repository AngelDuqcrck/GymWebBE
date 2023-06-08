package com.gymbe.powergymweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.Entity.ParteCuerpo;
import com.gymbe.powergymweb.service.implementations.ParteCuerpoService;
import com.gymbe.powergymweb.shared.dto.MusculoDTO;
import com.gymbe.powergymweb.shared.dto.ParteCuerpoDTO;

@RestController
@RequestMapping("/partesCuerpo")
public class ParteCuerpoController {
    
    @Autowired
    private ParteCuerpoService parteCuerpoService;

    @GetMapping
    public ResponseEntity<List<ParteCuerpoDTO>> listarPartesDelCuerpo() {
        return new ResponseEntity<>(parteCuerpoService.listarPartesCuerpo(), HttpStatus.OK);
    }
    
}
