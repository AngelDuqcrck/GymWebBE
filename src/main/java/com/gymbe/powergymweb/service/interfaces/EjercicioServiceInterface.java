package com.gymbe.powergymweb.service.interfaces;

import java.util.List;

import com.gymbe.powergymweb.Entity.Ejercicio;
import com.gymbe.powergymweb.shared.dto.EjercicioDTO;

public interface EjercicioServiceInterface {
    
    public List<Ejercicio> listarEjercicios();

    public EjercicioDTO crearEjercicio(EjercicioDTO ejercicio);
    
    public EjercicioDTO actualizarEjercicio(EjercicioDTO ejercicio, Integer ejercicioId);

    public void elimiarEjercicio(int id);
}
