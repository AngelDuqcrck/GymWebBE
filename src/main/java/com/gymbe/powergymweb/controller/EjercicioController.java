package com.gymbe.powergymweb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.repository.EjercicioRepository;

@RestController
@RequestMapping("ejercicios")
public class EjercicioController {
    @Autowired
    EjercicioRepository ejercicioRepository;


    /**
     * Método para listar todos los ejericicios 
     * @return
     */
    @GetMapping
    public List<Ejercicio> listarPlanes() {
        return ejercicioRepository.findAll();
    }

}
