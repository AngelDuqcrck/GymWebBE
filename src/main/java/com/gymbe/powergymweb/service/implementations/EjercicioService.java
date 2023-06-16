package com.gymbe.powergymweb.service.implementations;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.Entity.MusculoObjetivo;
import com.gymbe.powergymweb.Entity.ParteCuerpo;
import com.gymbe.powergymweb.repository.EjercicioRepository;
import com.gymbe.powergymweb.repository.MusculoObjetivoRepository;
import com.gymbe.powergymweb.repository.ParteCuerpoRepository;
import com.gymbe.powergymweb.service.interfaces.EjercicioServiceInterface;
import com.gymbe.powergymweb.shared.dto.EjercicioDTO;

@Service("ejercicioService")
public class EjercicioService implements EjercicioServiceInterface {

    @Autowired
    private EjercicioRepository ejercicioRepository;
    @Autowired
    private ParteCuerpoRepository parteCuerpoRepository;
    @Autowired
    private MusculoObjetivoRepository musculoObjetivoRepository;

    /**
     * Crea un nuevo ejercicio a partir del objeto EjercicioDTO proporcionado.
     *
     * @param ejercicio El objeto EjercicioDTO que contiene los datos del ejercicio
     *                  a crear.
     * @return El objeto EjercicioDTO del ejercicio recién creado.
     */
    @Override
    public Optional<Ejercicio> buscarEjerciciosId(int id) {
       Optional<Ejercicio> ejercicioEntities = ejercicioRepository.findById(id);
        return ejercicioEntities;
    }

    /**
     * Crea un nuevo ejercicio a partir del objeto EjercicioDTO proporcionado.
     *
     * @param ejercicio El objeto EjercicioDTO que contiene los datos del ejercicio
     *                  a crear.
     * @return El objeto EjercicioDTO del ejercicio recién creado.
     */
    @Override
    public List<Ejercicio> listarEjercicios() {
        List<Ejercicio> ejercicioEntities = ejercicioRepository.findAll();
        return ejercicioEntities;
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
        Optional<MusculoObjetivo> musculoEntity = musculoObjetivoRepository.findById(ejercicio.getMusculoObjetivo_id());
        Optional<ParteCuerpo> parteCuerpo = parteCuerpoRepository.findById(ejercicio.getParteCuerpo_id());
        ejercicioEntity.setMusculoObjetivo_id(musculoEntity.get());
        ejercicioEntity.setParteCuerpo_id(parteCuerpo.get());
        Ejercicio nuevoEjercicio = ejercicioRepository.save(ejercicioEntity);
        EjercicioDTO nuevoEjercicioDTO = new EjercicioDTO();
        BeanUtils.copyProperties(nuevoEjercicio, nuevoEjercicioDTO);
        return nuevoEjercicioDTO;
    }

    public EjercicioDTO actualizarEjercicio(EjercicioDTO ejercicio, Integer ejercicioId){
        Optional<Ejercicio> ejerciciofound = ejercicioRepository.findById(ejercicioId);
        if(ejerciciofound.isEmpty()){
            throw new EntityNotFoundException("No se pudo encontrar el ejercicio");
        }
        Ejercicio ejercicioEntity = ejerciciofound.get();
        BeanUtils.copyProperties(ejercicio, ejercicioEntity);
        Optional<MusculoObjetivo> musculoEntity = musculoObjetivoRepository.findById(ejercicio.getMusculoObjetivo_id());
        Optional<ParteCuerpo> parteCuerpo = parteCuerpoRepository.findById(ejercicio.getParteCuerpo_id());
        ejercicioEntity.setMusculoObjetivo_id(musculoEntity.get());
        ejercicioEntity.setParteCuerpo_id(parteCuerpo.get());
        ejercicioRepository.save(ejercicioEntity);
        EjercicioDTO ejercicioActualizado = new EjercicioDTO();
        BeanUtils.copyProperties(ejercicioEntity, ejercicioActualizado);
        return ejercicioActualizado;

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

    @Override
    public void elimiarEjercicio(int id) {
        this.ejercicioRepository.deleteById(id);
    }


}
