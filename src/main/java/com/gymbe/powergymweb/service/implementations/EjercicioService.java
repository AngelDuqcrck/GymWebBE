package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.repository.EjercicioRepository;
import com.gymbe.powergymweb.service.interfaces.EjercicioServiceInterface;
import com.gymbe.powergymweb.shared.dto.EjercicioDTO;

@Service("ejercicioService")
public class EjercicioService implements EjercicioServiceInterface {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public List<EjercicioDTO> listarEjercicios() {
        List<Ejercicio> ejercicioEntities = ejercicioRepository.findAll();
        return ejercicioEntities.stream()
                .map(this::convertToEjercicioDTO)
                .collect(Collectors.toList());
    }

    

    private EjercicioDTO convertToEjercicioDTO(Ejercicio ejercicio) {
        EjercicioDTO ejercicioDTO = new EjercicioDTO();
        ejercicioDTO.setDescripcion(ejercicio.getDescripcion());
        ejercicioDTO.setMusculoObjetivo_id(ejercicio.getMusculoObjetivo_id());
        ejercicioDTO.setParteCuerpo_id(ejercicio.getParteCuerpo_id());
        ejercicioDTO.setUrlGif(ejercicio.getUrlGif());
        return ejercicioDTO;
    }

}
