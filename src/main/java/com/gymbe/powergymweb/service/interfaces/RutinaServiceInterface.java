package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import com.gymbe.powergymweb.shared.dto.RutinaDTO;

public interface RutinaServiceInterface {
    public void crearRutina(RutinaDTO rutinaDTO, List<Integer> ejercicioIds);
}
