package com.gymbe.powergymweb.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.Entity.EjercicioRutina;
import com.gymbe.powergymweb.Entity.Rutina;
import com.gymbe.powergymweb.models.requests.RutinaRequest;
import com.gymbe.powergymweb.models.responses.MensajeResponse;
import com.gymbe.powergymweb.repository.RutinaRepository;
import com.gymbe.powergymweb.service.implementations.RutinaService;
import com.gymbe.powergymweb.shared.dto.RutinaDTO;

@RestController
@RequestMapping("/rutina")
public class RutinaController {
    
    @Autowired
    private RutinaService rutinaService;

    @Autowired
    private RutinaRepository rutinaRepository;

    /**
     * 
     * Crea una nueva rutina con los datos proporcionados y la lista de ejercicios
     * asociados.
     * 
     * @param rutinaDTO    Objeto DTO que contiene los datos de la rutina a crear.
     * @param ejercicioIds Lista de IDs de los ejercicios que se asociarán a la
     *                     rutina (opcional).
     * @return Un objeto MensajeResponse indicando el resultado de la operación.
     * @throws EntityNotFoundException Si no se pudo crear la rutina.
     */
    @PostMapping
    public MensajeResponse crearRutina(@RequestBody @Valid RutinaRequest rutinaRequest) {
        try {
            RutinaDTO rutinaDTO = new RutinaDTO();
            BeanUtils.copyProperties(rutinaRequest, rutinaDTO);
            rutinaService.crearRutina(rutinaDTO, rutinaRequest.getEjercicioIds());
            return new MensajeResponse("Se ha creado la rutina");
        } catch (EntityNotFoundException e) {
             return new MensajeResponse("NO se creo la rutina");
         }
    }

    @GetMapping
    public List<RutinaDTO> listarRutinas() {
        return rutinaService.listarRutinas();
    }

    @GetMapping("/ejerciciosRutina/{id}")
    public List<Ejercicio> listarEjerciciosDeUnaRutina(@PathVariable int id) {
        Rutina rutina = this.rutinaRepository.findById(id).get();
        List<EjercicioRutina> ejerciciosRutina = rutina.getEjerciciosRutinas();
        List<Ejercicio> listaEjercicios = new ArrayList<>();
        for (EjercicioRutina ejercicios : ejerciciosRutina){
            listaEjercicios.add(ejercicios.getEjercicio());
        }
        return listaEjercicios;
    }
}
