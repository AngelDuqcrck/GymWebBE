package com.gymbe.powergymweb.service.implementations;

import com.gymbe.powergymweb.service.interfaces.RutinaServiceInterface;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.Entity.EjercicioRutina;
import com.gymbe.powergymweb.Entity.Rutina;
import com.gymbe.powergymweb.repository.EjercicioRepository;
import com.gymbe.powergymweb.repository.EjercicioRutinaRepository;
import com.gymbe.powergymweb.repository.RutinaRepository;
import com.gymbe.powergymweb.service.interfaces.RutinaServiceInterface;
import com.gymbe.powergymweb.shared.dto.RutinaDTO;


@Service
public class RutinaService implements RutinaServiceInterface {
    @Autowired
    private RutinaRepository rutinaRepository;
    @Autowired
    private EjercicioRepository ejercicioRepository;
    @Autowired
    private EjercicioRutinaRepository ejercicioRutinaRepository;

    /**
     * 
     * Crea una nueva rutina con los datos proporcionados y la lista de ejercicios
     * asociados.
     * 
     * @param rutinaDTO    Objeto DTO que contiene los datos de la rutina a crear.
     * 
     * @param ejercicioIds Lista de IDs de los ejercicios que se asociarán a la
     *                     rutina (opcional).
     */
    @Override
    public void crearRutina(RutinaDTO rutinaDTO, List<Integer> ejercicioIds) {
        Rutina rutina = new Rutina();
        BeanUtils.copyProperties(rutinaDTO, rutina);
        Rutina rutinaGuardada = rutinaRepository.save(rutina);

        if (ejercicioIds != null && !ejercicioIds.isEmpty()) {
            List<Ejercicio> ejercicios = ejercicioRepository.findAllById(ejercicioIds);

            for (Ejercicio ejercicio : ejercicios) {
                EjercicioRutina ejercicioRutina = new EjercicioRutina();
                ejercicioRutina.setEjercicio(ejercicio);
                ejercicioRutina.setRutina(rutinaGuardada);
                ejercicioRutina.setDescripcion(rutinaGuardada.getDescripcion());
                ejercicioRutinaRepository.save(ejercicioRutina);
            }
        }
    }  

    public List<RutinaDTO> listarRutinas() {
        List<Rutina> rutinas = rutinaRepository.findAll();
        List<RutinaDTO> rutinasDTO = new ArrayList<>();

        for (Rutina rutina : rutinas) {
            RutinaDTO rutinaListDTO = new RutinaDTO();
            BeanUtils.copyProperties(rutina, rutinaListDTO);
            rutinasDTO.add(rutinaListDTO);
        }

        return rutinasDTO;
    }
}
