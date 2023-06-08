package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.MusculoObjetivo;
import com.gymbe.powergymweb.repository.MusculoObjetivoRepository;
import com.gymbe.powergymweb.shared.dto.MusculoDTO;

@Service("musculoService")
public class MusculoService {
    
    @Autowired
    private MusculoObjetivoRepository musculoObjetivoRepository;

    public List<MusculoDTO> listarMusculos() {
        List<MusculoObjetivo> musculos = musculoObjetivoRepository.findAll();
        return musculos.stream()
                .map(this::convertToMusculoDTO)
                .collect(Collectors.toList());
    }

    private MusculoDTO convertToMusculoDTO(MusculoObjetivo musculoObjetivo) {
        MusculoDTO musculoDTO = new MusculoDTO();
        musculoDTO.setId(musculoObjetivo.getId());
        musculoDTO.setDescripcion(musculoObjetivo.getDescripcion());
        return musculoDTO;
    }
}
