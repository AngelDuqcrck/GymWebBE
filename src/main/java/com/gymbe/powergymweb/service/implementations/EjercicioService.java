package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
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

    /**
     * Crea un nuevo ejercicio a partir del objeto EjercicioDTO proporcionado.
     *
     * @param ejercicio El objeto EjercicioDTO que contiene los datos del ejercicio
     *                  a crear.
     * @return El objeto EjercicioDTO del ejercicio recién creado.
     */
    @Override
    public List<EjercicioDTO> listarEjercicios() {
        List<Ejercicio> ejercicioEntities = ejercicioRepository.findAll();
        return ejercicioEntities.stream()
                .map(this::convertToEjercicioDTO)
                .collect(Collectors.toList());
    }

    /**
     * Crea un nuevo ejercicio a partir del objeto EjercicioDTO proporcionado.
     *
     * @param ejercicio El objeto EjercicioDTO que contiene los datos del ejercicio
     *                  a crear.
     * @return El objeto EjercicioDTO del ejercicio recién creado.
     */
    @Override
    public EjercicioDTO crearEjercicio(EjercicioDTO ejercicio) {
        Ejercicio ejercicioEntity = new Ejercicio();
        BeanUtils.copyProperties(ejercicio, ejercicioEntity);
        Ejercicio nuevoEjercicio = ejercicioRepository.save(ejercicioEntity);
        EjercicioDTO nuevoEjercicioDTO = new EjercicioDTO();
        BeanUtils.copyProperties(nuevoEjercicio, nuevoEjercicioDTO);
        return nuevoEjercicioDTO;
    }

    /**
     * Convierte un objeto Ejercicio a un objeto EjercicioDTO.
     *
     * @param ejercicio El objeto Ejercicio a convertir.
     * @return El objeto EjercicioDTO convertido.
     */
    private EjercicioDTO convertToEjercicioDTO(Ejercicio ejercicio) {
        EjercicioDTO ejercicioDTO = new EjercicioDTO();
        BeanUtils.copyProperties(ejercicio, ejercicioDTO);
        return ejercicioDTO;
    }

}
